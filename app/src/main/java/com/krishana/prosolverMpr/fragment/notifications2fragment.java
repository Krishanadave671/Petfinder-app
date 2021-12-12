package com.krishana.prosolverMpr.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krishana.prosolverMpr.Adapter.Notification2adapter;
import com.krishana.prosolverMpr.Model.NotificationModel;
import com.krishana.prosolverMpr.R;

import java.util.ArrayList;


public class notifications2fragment extends  Fragment
{
    RecyclerView recyclerView;
    ArrayList<NotificationModel> list;
    public notifications2fragment() {


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_notifications2fragment,container,false);
       recyclerView = view.findViewById(R.id.notification_recyclerview);
       list = new ArrayList<>();
       list.add(new NotificationModel(R.drawable.dog,"<b>krishna</b> mention you in a comment : try again","just now"));
       list.add(new NotificationModel(R.drawable.dog,"<b>krishna</b> mention you in a comment : try again","just now"));
       list.add(new NotificationModel(R.drawable.dog,"<b>krishna</b> mention you in a comment : try again","just now"));
       list.add(new NotificationModel(R.drawable.dog,"<b>krishna</b> mention you in a comment : try again","just now"));
       list.add(new NotificationModel(R.drawable.dog,"<b>krishna</b> mention you in a comment : try again","just now"));
        Notification2adapter adapter = new Notification2adapter(list,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        return  view;
    }
}


