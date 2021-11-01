package com.krishana.petfinderapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.krishana.petfinderapp.Adapter.DashboardAdapter;
import com.krishana.petfinderapp.Adapter.storyAdapter;
import com.krishana.petfinderapp.Model.DashboardModel;
import com.krishana.petfinderapp.Model.storyModel;
import com.krishana.petfinderapp.R;

import java.util.ArrayList;


public class Homefragment extends Fragment {

    RecyclerView StoryRv,dashboardRv;
    ArrayList<storyModel> list;
    ArrayList<DashboardModel> postlist;

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
        StoryRv = view.findViewById(R.id.story_recycler_view);
        dashboardRv = view.findViewById(R.id.dashboardRv);
        postlist = new ArrayList<>();
        postlist.add(new DashboardModel(R.drawable.dog,R.drawable.cat,R.drawable.ic_baseline_bookmark_border_24,"Doggie","345","74","Lover","42"));
        postlist.add(new DashboardModel(R.drawable.dog,R.drawable.cat,R.drawable.ic_baseline_bookmark_border_24,"Doggie","345","74","Lover","42"));
        postlist.add(new DashboardModel(R.drawable.dog,R.drawable.cat,R.drawable.ic_baseline_bookmark_border_24,"Doggie","345","74","Lover","42"));
        postlist.add(new DashboardModel(R.drawable.dog,R.drawable.cat,R.drawable.ic_baseline_bookmark_border_24,"Doggie","345","74","Lover","42"));
        postlist.add(new DashboardModel(R.drawable.dog,R.drawable.cat,R.drawable.ic_baseline_bookmark_border_24,"Doggie","345","74","Lover","42"));
        postlist.add(new DashboardModel(R.drawable.dog,R.drawable.cat,R.drawable.ic_baseline_bookmark_border_24,"Doggie","345","74","Lover","42"));

        DashboardAdapter postadapter = new DashboardAdapter(postlist,getContext());
        LinearLayoutManager postlinearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        dashboardRv.setLayoutManager(postlinearLayoutManager);
        dashboardRv.setNestedScrollingEnabled(false);
        dashboardRv.setAdapter(postadapter);


        list = new ArrayList<>();
        list.add(new storyModel(R.drawable.cat,R.drawable.ic_home,R.drawable.dog,"Tommy"));
        list.add(new storyModel(R.drawable.cat,R.drawable.ic_home,R.drawable.dog,"Tommy"));
        list.add(new storyModel(R.drawable.cat,R.drawable.ic_home,R.drawable.dog,"Tommy"));

        storyAdapter adapter = new storyAdapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        StoryRv.setLayoutManager(linearLayoutManager);
        StoryRv.setNestedScrollingEnabled(false);
        StoryRv.setAdapter(adapter);
        return view;
    }
}