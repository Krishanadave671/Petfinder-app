package com.krishana.prosolverMpr.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.krishana.prosolverMpr.Model.UserModel;
import com.krishana.prosolverMpr.R;
import com.krishana.prosolverMpr.databinding.FragmentAddBinding;


public class AddFragment extends Fragment {
FragmentAddBinding binding;
FirebaseAuth auth;
FirebaseFirestore db;


    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        db.collection("Users").document(FirebaseAuth.getInstance().getUid()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if(value.exists()){
                    UserModel user  = value.toObject(UserModel.class);
                    Glide.with(getContext())
                            .load(user.getProfile_photo())
                            .placeholder(R.drawable.profileimg)
                            .into(binding.profileImage);
                    binding.name.setText(user.getName());
                    binding.profession.setText(user.getProffession());


                }
            }
        });
       binding = FragmentAddBinding.inflate(inflater, container, false);
       binding.addformula.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               binding.Formula.setVisibility(View.VISIBLE);
               binding.Title.setVisibility(View.VISIBLE);
           }
       });

       binding.formuladesc.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               String description = binding.formuladesc.getText().toString();
               if(!description.isEmpty()){
                   binding.uploadbtn.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.orangeback));
                   binding.uploadbtn.setTextColor(getContext().getResources().getColor(R.color.white));
                   binding.uploadbtn.setEnabled(true);
               }
               else{
                   binding.uploadbtn.setBackgroundDrawable(ContextCompat.getDrawable(getContext(),R.drawable.circlewhite));
                   binding.uploadbtn.setTextColor(getContext().getResources().getColor(R.color.grey));
                   binding.uploadbtn.setEnabled(false);

               }

           }

           @Override
           public void afterTextChanged(Editable editable) {

           }
       });


       return binding.getRoot();
    }
}