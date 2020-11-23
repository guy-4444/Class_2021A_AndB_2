package com.classy.class_2021a_andb_2;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Capsule extends RecyclerView.Adapter<Adapter_Capsule.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<String> capsuleList;
    // Constructor of the class
    public Adapter_Capsule(int layoutId, ArrayList<String> capsuleList) {
        listItemLayout = layoutId;
        this.capsuleList = capsuleList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return capsuleList == null ? 0 : capsuleList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {

        holder.capsule_LBL_name.setText(capsuleList.get(listPosition));
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView capsule_LBL_name;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            capsule_LBL_name = (TextView) itemView.findViewById(R.id.item_LBL_name);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + capsule_LBL_name.getText());
        }
    }
}
