package com.krishana.prosolverMpr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.prosolverMpr.Model.DashboardModel;
import com.krishana.prosolverMpr.R;

import java.util.ArrayList;

public class DashboardAdapter extends  RecyclerView.Adapter<DashboardAdapter.viewHolder> {
    ArrayList<DashboardModel> list;
    Context context;

    public DashboardAdapter(ArrayList<DashboardModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboardrecyclerview,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DashboardModel model = list.get(holder.getAdapterPosition());
        holder.profile.setImageResource(model.getProfile());
        holder.postImage.setImageResource(model.getPostimage());
        holder.save.setImageResource(model.getSave());
        holder.name.setText(model.getName());
        holder.like.setText(model.getLike());
        holder.comment.setText(model.getComment());
        holder.share.setText(model.getShare());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView profile , postImage , save ;
        TextView name , about, like, share,comment;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_image);
            postImage = itemView.findViewById(R.id.postimage);
            save = itemView.findViewById(R.id.save);
            name = itemView.findViewById(R.id.username);
            about = itemView.findViewById(R.id.about);
            like = itemView.findViewById(R.id.like);
            share = itemView.findViewById(R.id.share);
            comment = itemView.findViewById(R.id.comment);
        }
    }
}
