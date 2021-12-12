package com.krishana.prosolverMpr.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.krishana.prosolverMpr.Adapter.Useradapter;
import com.krishana.prosolverMpr.Model.UserModel;
import com.krishana.prosolverMpr.databinding.FragmentSearchBinding;

import java.util.ArrayList;


public class searchFragment extends Fragment {
    ArrayList <UserModel> list = new ArrayList<>();
    FirebaseAuth auth;
    FirebaseFirestore fstore;
    FragmentSearchBinding binding;
    public searchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding =  FragmentSearchBinding.inflate(inflater , container, false);
        Useradapter useradapter = new Useradapter(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.searchRV.setLayoutManager(linearLayoutManager);
        binding.searchRV.setAdapter(useradapter);
        fstore.collection("Users").document(auth.getCurrentUser().getUid()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(@NonNull DocumentSnapshot snapshot){
                UserModel user = snapshot.toObject(UserModel.class);
                user.setUserId(snapshot.getId());
                list.add(user);
            }
        });
        useradapter.notifyDataSetChanged();



        return binding.getRoot();
    }
}