package com.krishana.petfinderapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.krishana.petfinderapp.Adapter.CustomFormulaAdapter;
import com.krishana.petfinderapp.Adapter.DashboardAdapter;
import com.krishana.petfinderapp.Adapter.storyAdapter;
import com.krishana.petfinderapp.Inbuilt_formulas;
import com.krishana.petfinderapp.Model.DashboardModel;
import com.krishana.petfinderapp.Model.customformulamodel;
import com.krishana.petfinderapp.Model.storyModel;
import com.krishana.petfinderapp.R;

import java.util.ArrayList;


public class Homefragment extends Fragment {

    RecyclerView dashboardRv;
    ArrayList<storyModel> list;
    ArrayList<customformulamodel> postlist;
    ImageView profile, subtopics,cameraocr;

    public Homefragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_homefragment, container, false);

        dashboardRv = view.findViewById(R.id.dashboardRv);
        profile = view.findViewById(R.id.profile_image);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Inbuilt_formulas.class));
            }
        });

        postlist = new ArrayList<>();
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","(a+B*C)","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","m*c^2","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","a+B+C","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","a*b/c/d","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","m*c^2","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","m*c^2","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","m*c^2","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","a*b","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","m*c^2","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","m*c^2","24","56","10"));

        CustomFormulaAdapter postadapter = new CustomFormulaAdapter(postlist,getContext());
        LinearLayoutManager postlinearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        dashboardRv.setLayoutManager(postlinearLayoutManager);
        dashboardRv.setNestedScrollingEnabled(false);
        dashboardRv.setAdapter(postadapter);



        return view;
    }
}