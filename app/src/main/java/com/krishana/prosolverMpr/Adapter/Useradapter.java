package com.krishana.prosolverMpr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.krishana.prosolverMpr.Model.UserModel;
import com.krishana.prosolverMpr.R;
import com.krishana.prosolverMpr.databinding.SearchSampleBinding;

import java.util.ArrayList;

public class Useradapter extends RecyclerView.Adapter<Useradapter.viewHolder> {
    Context context;
    ArrayList<UserModel> list;

    public Useradapter(Context context, ArrayList<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        UserModel user = list.get(position);
        Glide.with(context)
                .load(user.getProfile_photo())
                .placeholder(R.drawable.image)
                .into(holder.binding.profileImage);
        holder.binding.name.setText(user.getName());
        holder.binding.profession.setText(user.getProffession());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
            SearchSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SearchSampleBinding.bind(itemView);


        }
    }
}
