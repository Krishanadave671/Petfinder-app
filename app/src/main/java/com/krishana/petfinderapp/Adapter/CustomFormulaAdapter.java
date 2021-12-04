package com.krishana.petfinderapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.petfinderapp.Model.customformulamodel;
import com.krishana.petfinderapp.R;

import java.util.ArrayList;

public class CustomFormulaAdapter extends RecyclerView.Adapter<CustomFormulaAdapter.viewHolder> {
     ArrayList<customformulamodel> list;

     Context context;

    public CustomFormulaAdapter(ArrayList<customformulamodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customformularv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        customformulamodel model = list.get(position);
        holder.profileImage.setImageResource(model.getProfileImage());
        holder.bookmark.setImageResource(model.getBookmark());
        holder.Username.setText(model.getUsername());
        holder.proffession.setText(model.getProffession());
        holder.Formula.setText(model.getFormula());
        holder.title.setText(model.getTitle());
        holder.like.setText(model.getLike());
        holder.share.setText(model.getShare());
        holder.comment.setText(model.getComment());

        holder.Formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "The Formula is " + holder.Formula.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView profileImage, bookmark;
        TextView Username,proffession, title,Formula, like , share, comment;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            proffession = itemView.findViewById(R.id.about);
            Username  = itemView.findViewById(R.id.username);
            title = itemView.findViewById(R.id.Title);
            Formula = itemView.findViewById(R.id.Formulas);
            like = itemView.findViewById(R.id.like);
            share = itemView.findViewById(R.id.share);
            comment = itemView.findViewById(R.id.comment);
            bookmark = itemView.findViewById(R.id.bookmark);
            profileImage  = itemView.findViewById(R.id.profile_image);


        }
    }
}
