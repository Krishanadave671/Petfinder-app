package com.krishana.prosolverMpr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.krishana.prosolverMpr.databinding.ActivityLoginBinding;

public class Login_Activity extends AppCompatActivity {
    ActivityLoginBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser currentuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        currentuser = auth.getCurrentUser();
        binding.gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login_Activity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });
        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailinput.getEditText().getText().toString().trim();
                String password = binding.passwordtextinput.getEditText().getText().toString().trim();
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(Login_Activity.this,MainActivity.class));



                        }
                    }
                });


            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentuser!= null){
            startActivity(new Intent(Login_Activity.this,MainActivity.class));
        }
    }
}