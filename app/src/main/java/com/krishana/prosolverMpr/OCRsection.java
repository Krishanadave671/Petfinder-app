package com.krishana.prosolverMpr;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

public class OCRsection extends AppCompatActivity {

        ImageView imageview,wait,close,share,camera, temp;
        TextView tvresult;
        EditText textview;
        Button Detect;
        private static final int STORAGE_PERMISSION_CODE = 113;
        ActivityResultLauncher<Intent> gallerylauncher;
        private  static final  String  TAG = "MyTAG";
        InputImage inputImage;
        TextRecognizer textRecognizer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_ocrsection);


            imageview = findViewById(R.id.imageView);
            temp = imageview;
            textview = findViewById(R.id.textView);
            Detect = findViewById(R.id.button);
            tvresult = findViewById(R.id.customresult);
            wait = findViewById(R.id.Rukozara);
            close = findViewById(R.id.close);
            share = findViewById(R.id.share);
            camera = findViewById(R.id.camera);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    close.setVisibility(View.INVISIBLE);
                    tvresult.setVisibility(View.INVISIBLE);
                    share.setVisibility(View.INVISIBLE);
                    imageview.setImageResource(R.drawable.scanner);
                    camera.setVisibility(View.VISIBLE);
                    textview.setText(" ");


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

            textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startcropActivity();
                }
            });
            Detect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wait.setVisibility(View.VISIBLE);
                    new WolframFeed().execute();

                }
            });

        }

        private void startcropActivity() {
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);
        }

        private void ConvertImagetotext(Uri imageuri) {
            try{
                inputImage = InputImage.fromFilePath(getApplicationContext(),imageuri);
                Task<Text> result = textRecognizer.process(inputImage).
                        addOnSuccessListener(new OnSuccessListener<Text>() {
                            @Override
                            public void onSuccess(@NonNull Text text) {
                                textview.setText(text.getText());

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }catch (Exception e){
                Toast.makeText(OCRsection.this, "OCR failed ", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onResume() {
            super.onResume();
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result.getUri();
                    imageview.setImageURI(resultUri);
                    camera.setVisibility(View.INVISIBLE);
                    ConvertImagetotext(resultUri);
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result.getError();
                }
            }
        }
        private class WolframFeed extends AsyncTask<Void, Void, String> {
            private WAException exception;

            @Override
            protected String doInBackground(Void... params) {
                String result="";
                try {

                    Log.e("TRYing", "wolfram try/");
                    //System.out.println("Query URL:");
                    //System.out.println(engine.toURL(query));
                    //System.out.println("");

                    WAEngine engine = new WAEngine();

                    engine.setAppID("32JT6V-ALE8R368AY");
                    engine.addFormat("plaintext");


                    WAQuery query = engine.createQuery();
                    query.setInput(textview.getText().toString());


                    WAQueryResult queryResult = engine.performQuery(query);


                    if (queryResult.isError()) {

                        String err= "Query error" + "  error code: " + queryResult.getErrorCode() + "  error message: " + queryResult.getErrorMessage();
                        Log.e("err: ",err);

                    } else if (!queryResult.isSuccess()) {
                        Log.e("err: " ,"Query was not understood; no results available.");

                    } else {
                        // Got a result.
                        Log.e("err: ","Successful query. Pods follow:\n");

                        for (WAPod pod : queryResult.getPods()) {

                            if (!pod.isError()) {
                                result+="\n";
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

            @Override
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