package com.krishana.prosolverMpr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.krishana.prosolverMpr.databinding.ActivitySubtopiclistBinding;

public class subtopiclist extends AppCompatActivity {
    ActivitySubtopiclistBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubtopiclistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.mean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(subtopiclist.this,Mean_median_mode.class));
            }
        });
    }
}