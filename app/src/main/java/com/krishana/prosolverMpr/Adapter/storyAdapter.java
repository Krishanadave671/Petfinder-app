package com.krishana.prosolverMpr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.prosolverMpr.Model.storyModel;
import com.krishana.prosolverMpr.R;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.viewHolder> {
    ArrayList<storyModel> list ;
    Context context;

    public storyAdapter(ArrayList<storyModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.storydesignrv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        storyModel model =  list.get(holder.getAdapterPosition());
        holder.StoryImg.setImageResource(model.getStory());
        holder.profile.setImageResource(model.getProfile());
        holder.storytype.setImageResource(model.getStorytype());
        holder.name.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView StoryImg, profile , storytype;
        TextView name ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            StoryImg = itemView.findViewById(R.id.Story);
            profile  = itemView.findViewById(R.id.profile_image);
            storytype = itemView.findViewById(R.id.storytype);
            name = itemView.findViewById(R.id.Name);



        }
    }
}
