package com.krishana.petfinderapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.krishana.petfinderapp.Activity_homepage;
import com.krishana.petfinderapp.Model.mathsmodel;
import com.krishana.petfinderapp.R;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder> {
    Context context;
   ArrayList<mathsmodel> chapternamesList;
    ArrayList<mathsmodel> filteredchapterlist;

    public RecyclerviewAdapter(Context context, ArrayList<mathsmodel> chapternamesList) {
        this.context = context;
        this.chapternamesList = chapternamesList;
        this.filteredchapterlist = chapternamesList;

    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mathsrv,parent,false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.chaptertitle.setText(filteredchapterlist.get(position).getChaptername());
        holder.chapterdescription.setText(filteredchapterlist.get(position).getDescription());
        holder.chapterimage.setImageResource(filteredchapterlist.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item clicked " + filteredchapterlist.get(holder.getAdapterPosition()).getChaptername(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Activity_homepage.class);
                context.startActivity(intent);

            }
        });
        holder.chapterimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "chapter image selected", Toast.LENGTH_SHORT).show();
                // prajwal;
            }
        });



    }

    @Override
    public int getItemCount() {
        return filteredchapterlist.size();
    }


    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder{
        ImageView chapterimage;
        TextView chaptertitle , chapterdescription;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            chapterimage = itemView.findViewById(R.id.profile_image);
            chaptertitle = itemView.findViewById(R.id.chaptertitle);
            chapterdescription = itemView.findViewById(R.id.chapterdesc);
        }
    }

    public Filter getfilter(){
     return new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence charSequence) {
             String key = charSequence.toString();
             if(key.isEmpty()){
                 filteredchapterlist = chapternamesList;
             }
             else{
                 ArrayList<mathsmodel> isfiltered = new ArrayList<>();
                 for(mathsmodel row : chapternamesList){
                     if(row.getChaptername().toLowerCase().contains(key.toLowerCase())){
                        isfiltered.add(row);
                     }
                 }
                 filteredchapterlist = isfiltered;
             }
             FilterResults filterResults = new FilterResults();
             filterResults.values = filteredchapterlist;
             return filterResults;
         }

         @Override
         protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
             filteredchapterlist = (ArrayList<mathsmodel>)filterResults.values;
             notifyDataSetChanged();

         }
     };


    }

}
