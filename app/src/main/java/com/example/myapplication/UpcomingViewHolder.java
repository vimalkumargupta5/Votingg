package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UpcomingViewHolder extends RecyclerView.ViewHolder {
    public TextView year,detail,electiontype,state;
    public ImageView map;
    public UpcomingViewHolder(@NonNull View itemView) {
        super(itemView);
        year = itemView.findViewById(R.id.electionyear);
        detail = itemView.findViewById(R.id.electiondetail);
        electiontype = itemView.findViewById(R.id.electiontype);
        state = itemView.findViewById(R.id.electionstate);
        map = itemView.findViewById(R.id.statemap);
    }
}
