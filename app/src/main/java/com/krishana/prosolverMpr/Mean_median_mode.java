package com.krishana.prosolverMpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.krishana.prosolverMpr.databinding.ActivityMeanMedianModeBinding;

import java.util.Arrays;

public class Mean_median_mode extends AppCompatActivity {
 ActivityMeanMedianModeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMeanMedianModeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MMM m = new MMM();
                String meanip = binding.meaninput.getText().toString();
                int  arr[] = m.getArray(meanip);
                Arrays.sort(arr);
                binding.meanres.setText(m.mean(arr) + "");
                binding.medianres.setText(m.median(arr) + "");

                String mode  = Arrays.toString(m.mode(arr)) ;
                binding.moderes.setText(mode + "");
            }
        });
        binding.closemean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.meaninput.setText("");
                binding.meanres.setText(" ");
                binding.medianres.setText(" ");
                binding.moderes.setText(" ");
            }
        });

    }
}