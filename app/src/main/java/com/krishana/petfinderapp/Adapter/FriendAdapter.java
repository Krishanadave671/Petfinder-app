package com.krishana.petfinderapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.petfinderapp.Model.Friendmodel;
import com.krishana.petfinderapp.R;

import java.io.FileReader;
import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.viewHolder> {
    ArrayList<Friendmodel> list ;
    Context context;

    public FriendAdapter(ArrayList<Friendmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friendrv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Friendmodel friendmodel = list.get(position);
        holder.profile.setImageResource(friendmodel.getProfile());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView profile;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_image);

        }
    }
}
