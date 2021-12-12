package com.krishana.prosolverMpr.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.prosolverMpr.Model.custominputvarmodel;
import com.krishana.prosolverMpr.R;

import java.util.ArrayList;

public class custominputvaradapter extends RecyclerView.Adapter<custominputvaradapter.viewHolder> {
    ArrayList<custominputvarmodel> list;
    ArrayList<Character> variables;
    ArrayList<Integer> values;

    public ArrayList<Character> getVariables() {
        return variables;
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    private OnItemClickListener mListener;
    Context context;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemclicklistener(OnItemClickListener listener) {
        mListener = listener;
    }

    public custominputvaradapter(ArrayList<custominputvarmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custominputsample, parent, false);
        return new viewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        custominputvarmodel model = list.get(position);
        holder.value.setText(model.getValue());
        holder.variable.setText(model.getVariable());
        values =  new ArrayList<>();
        variables = new ArrayList<>();
        holder.value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                values.add(Integer.parseInt(holder.value.getText().toString()));
                variables.add(holder.variable.getText().toString().charAt(0));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        EditText value;
        EditText variable;

        public viewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            variable = itemView.findViewById(R.id.inputvariable);
            value = itemView.findViewById(R.id.inputvalue);




        }


    }
}




