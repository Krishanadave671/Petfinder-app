package com.krishana.petfinderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.iammert.library.readablebottombar.ReadableBottomBar;
import com.krishana.petfinderapp.databinding.ActivityMainBinding;
import com.krishana.petfinderapp.fragment.AddFragment;
import com.krishana.petfinderapp.fragment.Homefragment;
import com.krishana.petfinderapp.fragment.ProfileFragment;
import com.krishana.petfinderapp.fragment.notificationFragment;
import com.krishana.petfinderapp.fragment.searchFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        binding.toolbar.setVisibility(View.GONE);
        transaction.replace(R.id.container,new Homefragment());
        transaction.commit();
        setSupportActionBar(binding.toolbar);
        MainActivity.this.setTitle("My Profile");


        binding.readablebottombar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i){
                    case 0:
                        binding.toolbar.setVisibility(View.GONE);
                        transaction.replace(R.id.container,new Homefragment());
                        break;
                        case 1:
                            transaction.replace(R.id.container,new searchFragment());
                        break;
                        case 2:
                            binding.toolbar.setVisibility(View.GONE);
                            transaction.replace(R.id.container,new AddFragment());
                        break;
                        case 3:
                            binding.toolbar.setVisibility(View.GONE);
                            transaction.replace(R.id.container,new notificationFragment());
                        break;
                        case 4:
                            binding.toolbar.setVisibility(View.VISIBLE);
                            transaction.replace(R.id.container,new ProfileFragment());
                        break;

                }
                transaction.commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings,menu);
        return true;
    }
}