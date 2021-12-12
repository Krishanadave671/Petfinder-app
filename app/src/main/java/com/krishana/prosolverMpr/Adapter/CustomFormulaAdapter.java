package com.krishana.prosolverMpr.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.prosolverMpr.Model.customformulamodel;
import com.krishana.prosolverMpr.R;
import com.krishana.prosolverMpr.customlayout;

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
        String str = holder.Formula.getText().toString();
        String tit = holder.title.getText().toString();

        holder.Formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "The Formula is " + holder.Formula.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, customlayout.class);
                intent.putExtra("message_str",str);
                intent.putExtra("title", tit);
                context.startActivity(intent);
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
            Formula = itemView.findViewById(R.id.Formula);
            like = itemView.findViewById(R.id.like);
            share = itemView.findViewById(R.id.share);
            comment = itemView.findViewById(R.id.comment);
            bookmark = itemView.findViewById(R.id.bookmark);
            profileImage  = itemView.findViewById(R.id.profile_image);


        }
    }
}
