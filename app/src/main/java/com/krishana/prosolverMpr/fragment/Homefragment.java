package com.krishana.prosolverMpr.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.krishana.prosolverMpr.Activity_Thankyou;
import com.krishana.prosolverMpr.Adapter.CustomFormulaAdapter;
import com.krishana.prosolverMpr.Inbuilt_formulas;
import com.krishana.prosolverMpr.Model.customformulamodel;
import com.krishana.prosolverMpr.Model.storyModel;
import com.krishana.prosolverMpr.OCRsection;
import com.krishana.prosolverMpr.R;

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
        subtopics = view.findViewById(R.id.subtopics);
        cameraocr = view.findViewById(R.id.cameraocr);
        subtopics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Inbuilt_formulas.class));
            }
        });
        cameraocr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), OCRsection.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Activity_Thankyou.class));
            }
        });

        postlist = new ArrayList<>();
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Dhruv Gansinghani", "Student","Energy equivalence","(20a + 19b)*15c = 40k","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Krishana Dave", "Student","Krishana 's formula "," e = m*c^2","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"prajwal dhule", "Student","Energy equivalence","a+B*c*d*e = f","24","56","10"));
        postlist.add(new customformulamodel(R.drawable.profileimg,R.drawable.bookmark,"Ayush dodia", "Student","Energy equivalence","a*b/c/d = f","24","56","10"));
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