package com.krishana.petfinderapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krishana.petfinderapp.Adapter.RecyclerviewAdapter;
import com.krishana.petfinderapp.Model.mathsmodel;
import com.krishana.petfinderapp.R;

import java.util.ArrayList;


public class MathsFragment extends Fragment {
    RecyclerView chapterrecyclerview;
    RecyclerviewAdapter recyclerviewAdapter;
    ArrayList<mathsmodel>list;
    public MathsFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maths, container, false);

        chapterrecyclerview = view.findViewById(R.id.maths_recyclerview);
            list = new ArrayList<>();
        list.add(new mathsmodel("Algebra","let us learn algebra",R.drawable.algebra));
        list.add(new mathsmodel("Geometry","let us learn Geometry",R.drawable.geometry_tools));
        list.add(new mathsmodel("logic", "let us learn logic", R.drawable.logic));
        list.add(new mathsmodel("matrix","let us learn matrix",R.drawable.matrix));
        list.add(new mathsmodel("statistics","let us learn statistics",R.drawable.statistics));
        list.add(new mathsmodel("summationimg","let us learn summationimg",R.drawable.summationimg));
        list.add(new mathsmodel("probability","let us learn probability",R.drawable.dice));
        list.add(new mathsmodel("algebra","let us learn algebra",R.drawable.algebra));
        list.add(new mathsmodel("Algebra","let us learn algebra",R.drawable.algebra));
        list.add(new mathsmodel("Geometry","let us learn Geometry",R.drawable.geometry_tools));
        list.add(new mathsmodel("statistics","let us learn statistics",R.drawable.statistics));
        list.add(new mathsmodel("logic", "let us learn logic", R.drawable.logic));
        list.add(new mathsmodel("matrix","let us learn matrix",R.drawable.matrix));
        list.add(new mathsmodel("probability","let us learn probability",R.drawable.dice));
        list.add(new mathsmodel("summationimg","let us learn summationimg",R.drawable.summationimg));
        list.add(new mathsmodel("algebra","let us learn algebra",R.drawable.algebra));
        list.add(new mathsmodel("Algebra","let us learn algebra",R.drawable.algebra));
        list.add(new mathsmodel("Geometry","let us learn Geometry",R.drawable.geometry_tools));
        list.add(new mathsmodel("statistics","let us learn statistics",R.drawable.statistics));
        list.add(new mathsmodel("logic", "let us learn logic", R.drawable.logic));
        list.add(new mathsmodel("matrix","let us learn matrix",R.drawable.matrix));
        list.add(new mathsmodel("probability","let us learn probability",R.drawable.dice));
        list.add(new mathsmodel("summationimg","let us learn summationimg",R.drawable.summationimg));
        list.add(new mathsmodel("algebra","let us learn algebra",R.drawable.algebra));
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
            chapterrecyclerview.setLayoutManager(layoutManager);
            recyclerviewAdapter = new RecyclerviewAdapter(getContext(), list);
            chapterrecyclerview.setAdapter(recyclerviewAdapter);

        return view;
    }


}