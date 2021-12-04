package com.krishana.petfinderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.krishana.petfinderapp.Adapter.RecyclerviewAdapter;
import com.krishana.petfinderapp.Adapter.custominputvaradapter;
import com.krishana.petfinderapp.Model.custominputvarmodel;
import com.krishana.petfinderapp.databinding.CustomformularvBinding;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

public class customlayout extends AppCompatActivity {
    ArrayList<custominputvarmodel> list;
    Button calculate;
    custominputvaradapter adapter;
    RecyclerView.ViewHolder viewHolder;
    TextView Title, Formula,tvresult;




    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlayout);
        calculate = findViewById(R.id.btn_calculatecustom);
        recyclerView = findViewById(R.id.custominputrv);
        Title = findViewById(R.id.titlecustom);
        Formula = findViewById(R.id.Formulacustom);
        tvresult = findViewById(R.id.customresult);
        calculate = findViewById(R.id.btn_calculatecustom);
        int count = getcount(Formula.getText().toString()) -1 ;
        int[] val = new int[count];
        char[] var = new char[count];



//        adapter.setOnItemclicklistener(new custominputvaradapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                int count = getcount(Formula.getText().toString()) - 1;
//                int arr[] = new int[count];
//
//
//            }
//        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i = 0; i < count;i++){
                     val[i] = Integer.parseInt(adapter.getValuestr());
                     var[i] = adapter.getVariablestr().charAt(0);
                }



            }
        });

        // karl pearson r




        list = new ArrayList<>(count);
        for(int i = 0; i < count;i++){
            list.add(new custominputvarmodel("",""));
        }



        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        adapter = new custominputvaradapter(list,getApplicationContext());


        recyclerView.setAdapter(adapter);



    }
    private int getcount(String s){
        s = Formula.getText().toString();
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            c[i] = s.charAt(i);
        }

        char[] c2 = new char[s.length()/2 + 1];
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            if (((c[i] <= 90) && (c[i] >= 65)) || ((c[i] <= 122) && (c[i] >= 97))) {
                if(j == 0) {
                    c2[j] = c[i];
                    j++;
                }
                else {
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
    private String getquestion(String s, char[] C, int[] I){


        s = Formula.getText().toString();
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            c[i] = s.charAt(i);
        }

        char[] c2 = new char[s.length()/2 + 1];
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            if (((c[i] <= 90) && (c[i] >= 65)) || ((c[i] <= 122) && (c[i] >= 97))) {
                if(j == 0) {
                    c2[j] = c[i];
                    j++;
                }
                else {
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
        for(int i = 0; i<c.length; i++) {
            int count = 0;
            for(int k = 0; k<j-1; k++) {
                if (c[i] == C[k]){
                    str = str + I[k];
                    count = 1;
                    break;
                }
            }
            if(count == 0) {
                str = str + c[i];
            }
        }
       return str;
    }




}