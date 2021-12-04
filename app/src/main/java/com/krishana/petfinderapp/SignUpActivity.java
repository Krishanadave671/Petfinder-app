package com.krishana.petfinderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.krishana.petfinderapp.Model.UserModel;
import com.krishana.petfinderapp.databinding.ActivitySignUpBinding;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
     FirebaseAuth mauth;
     FirebaseFirestore db;
     String Userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mauth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        binding.gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, Login_Activity.class);
                startActivity(intent);
            }
        });
        binding.btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailinput.getEditText().getText().toString().trim();
                String password = binding.passwordtextinput.getEditText().getText().toString().trim();
                String name  = binding.Nameet.getEditText().getText().toString().trim();
                String proffession = binding.Proffesionet.getEditText().getText().toString().trim();
                mauth.createUserWithEmailAndPassword(email ,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Authenticated successfully ", Toast.LENGTH_SHORT).show();
                            Userid = mauth.getCurrentUser().getUid();
                            DocumentReference documentReference = db.collection("Users").document(Userid);
                            Map<String, Object> user = new HashMap<>();
                            user.put ("email",email);
                            user.put( "name",name);
                            user.put( "Password",password);
                            user.put("Profession",proffession);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(SignUpActivity.this, "Signin successfully !", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpActivity.this,"Signin failed ", Toast.LENGTH_SHORT).show();
                                }
                            });


                        }
                    }

                    });
                }});
    }
}
