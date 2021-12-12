package com.krishana.prosolverMpr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Activity_homepage extends AppCompatActivity {
    TextInputEditText a,d,n;
    Button calculate;
    TextView result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        a = findViewById(R.id.editext_firsterm);
        d = findViewById(R.id.edittext_commond);
        n = findViewById(R.id.editext_numbern);
        calculate = findViewById(R.id.button_calculate);
        result = findViewById(R.id.textView_result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double firstterm  = Double.parseDouble(a.getText().toString());
                double difference = Double.parseDouble(d.getText().toString());
                int noofterms = Integer.parseInt(n.getText().toString());
                TermSum sum = new TermSum();
                String res = Double.toString(sum.apSum(firstterm,noofterms,difference));
                 result.setText(res);



            }
        });




    }
}