package com.krishana.petfinderapp.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krishana.petfinderapp.Model.custominputvarmodel;
import com.krishana.petfinderapp.R;

import java.util.ArrayList;

public class custominputvaradapter extends RecyclerView.Adapter<custominputvaradapter.viewHolder> {
     ArrayList<custominputvarmodel> list;
    static  String valuestr,variablestr;
    private OnItemClickListener mListener;
     Context context;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemclicklistener(OnItemClickListener listener){
        mListener = listener;
    }

    public custominputvaradapter(ArrayList<custominputvarmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custominputsample,parent,false);
        return new viewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        custominputvarmodel model = list.get(position);
        holder.value.setText(model.getValue());
        holder.variable.setText(model.getVariable());


        






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        EditText value;
       EditText variable;
        public viewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            variable = itemView.findViewById(R.id.inputvariable);
            value = itemView.findViewById(R.id.inputvalue);
            value.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    valuestr = value.getText().toString();
                     variablestr = variable.getText().toString();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

           

        }


    }


   public  static String getValuestr(){
        return valuestr;
    }
        public  static String getVariablestr(){
        return variablestr;
    }


}
