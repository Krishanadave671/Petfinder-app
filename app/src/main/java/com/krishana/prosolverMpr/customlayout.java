package com.krishana.prosolverMpr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.krishana.prosolverMpr.Adapter.custominputvaradapter;
import com.krishana.prosolverMpr.Model.custominputvarmodel;

import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

import java.util.ArrayList;

public class customlayout extends AppCompatActivity {
    ArrayList<custominputvarmodel> list;
    Button calculate;
    ImageView wait, close , share;
    custominputvaradapter adapter;
    RecyclerView.ViewHolder viewHolder;
    TextView Title, Formula, tvresult;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlayout);
        wait = findViewById(R.id.Rukozara);
        close = findViewById(R.id.close);
        share = findViewById(R.id.share);
        calculate = findViewById(R.id.customcalculate);
        recyclerView = findViewById(R.id.custominputrv);
        Title = findViewById(R.id.titlecustom);
        Formula = findViewById(R.id.Formulacustom);
        tvresult = findViewById(R.id.customresult);


        Intent intent = getIntent();
        String  formpost = intent.getStringExtra("message_str");
        String  title =  intent.getStringExtra("title");
        Formula.setText(formpost);
        Title.setText(title);
        int count = getcount(Formula.getText().toString()) - 1;

        //      adapter.setOnItemclicklistener(new custominputvaradapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                int count = getcount(Formula.getText().toString()) - 1;
//                i

//
//            }
//        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wait.setVisibility(View.VISIBLE);
                new WolframFeed().execute();




            }
        });

        // karl pearson r

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close.setVisibility(View.INVISIBLE);
                tvresult.setVisibility(View.INVISIBLE);
                share.setVisibility(View.INVISIBLE);




            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, tvresult.getText().toString() + "\n Thanks for using Prosolver Android app for more solutions Download on playstore \n\n Have a nice day !!");
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
        list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(new custominputvarmodel("", ""));
        }


        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        adapter = new custominputvaradapter(list, getApplicationContext());


        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private int getcount(String s) {
        s = Formula.getText().toString();
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }

        char[] c2 = new char[s.length() / 2 + 1];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if (((c[i] <= 90) && (c[i] >= 65)) || ((c[i] <= 122) && (c[i] >= 97))) {
                if (j == 0) {
                    c2[j] = c[i];
                    j++;
                } else {
                    for (int k = 0; k < j; k++) {
                        if (c2[k] == c[i]) {
                            count = 1;
                            break;
                        }
                    }
                    if (count == 0) {
                        c2[j] = c[i];
                        j++;
                    }
                }
            }

        }
        return j;
    }

    private String getquestion(String s, char[] C, int[] I) {


        s = Formula.getText().toString();
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }

        char[] c2 = new char[s.length() / 2 + 1];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if (((c[i] <= 90) && (c[i] >= 65)) || ((c[i] <= 122) && (c[i] >= 97))) {
                if (j == 0) {
                    c2[j] = c[i];
                    j++;
                } else {
                    for (int k = 0; k < j; k++) {
                        if (c2[k] == c[i]) {
                            count = 1;
                            break;
                        }
                    }
                    if (count == 0) {
                        c2[j] = c[i];
                        j++;
                    }
                }
            }

        }

        // a*b + c*d *e = c
        // count getcount(formula) -> 3
        // varaiable ->
        // expression -> string question = getquestion(char a[], int value[]);


        String str = "";
        for (int i = 0; i < c.length; i++) {
            int count = 0;
            for (int k = 0; k < j - 1; k++) {
                if (c[i] == C[k]) {
                    str = str + I[k];
                    count = 1;
                    break;
                }
            }
            if (count == 0) {
                str = str + c[i];
            }
        }
        return str;
    }

    private class WolframFeed extends AsyncTask<Void, Void, String> {
        private WAException exception;

        @Override
        protected String doInBackground(Void... params) {
            String result = "";
            try {

                Log.e("TRYing", "wolfram try/");
                //System.out.println("Query URL:");
                //System.out.println(engine.toURL(query));
                //System.out.println("");

                WAEngine engine = new WAEngine();

                engine.setAppID("32JT6V-ALE8R368AY");
                engine.addFormat("plaintext");
                String equation = Formula.getText().toString();
                int count = getcount(Formula.getText().toString()) - 1;

                int[] val = new int[count];
                char[] var = new char[count];
                for(int i = 0;i <  count ; i++){
                    val[i] = adapter.getValues().get(i);
                }
                for(int i = 0;i <  count ; i++){
                    var[i] = adapter.getVariables().get(i);
                }
                String exp = getquestion(equation, var, val);
                WAQuery query = engine.createQuery();
                query.setInput(exp);


                WAQueryResult queryResult = engine.performQuery(query);


                if (queryResult.isError()) {

                    String err = "Query error" + "  error code: " + queryResult.getErrorCode() + "  error message: " + queryResult.getErrorMessage();
                    Log.e("err: ", err);

                } else if (!queryResult.isSuccess()) {
                    Log.e("err: ", "Query was not understood; no results available.");

                } else {
                    // Got a result.
                    Log.e("err: ", "Successful query. Pods follow:\n");

                    for (WAPod pod : queryResult.getPods()) {

                        if (!pod.isError()) {
                            result += "\n";
                            for (WASubpod subpod : pod.getSubpods()) {
                                for (Object element : subpod.getContents()) {
                                    if (element instanceof WAPlainText) {
                                        if (((WAPlainText) element).getText() != "") {
                                            result += "    " + pod.getTitle();
                                            result += "\n --------------------\n";
                                            result += "   " + ((WAPlainText) element).getText();
                                            result += " \n";
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            } catch (WAException e) {
                e.printStackTrace();

            }
            return result;
        }


        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            wait.setVisibility(View.INVISIBLE);
            tvresult.setText("Answer  : \n " + result);
            tvresult.setVisibility(View.VISIBLE);
            close.setVisibility(View.VISIBLE);
            share.setVisibility(View.VISIBLE);
        }
    }
}