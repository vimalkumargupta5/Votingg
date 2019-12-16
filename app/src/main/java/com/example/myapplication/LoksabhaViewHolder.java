package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LoksabhaViewHolder extends RecyclerView.ViewHolder {
    public TextView partyname, recievedseats, recievedvote, status, totalvotes, voteshare;
    public ImageView partylogo;

    public LoksabhaViewHolder(@NonNull View itemView) {
        super(itemView);
        partyname = itemView.findViewById(R.id.partyname_text);
        status = itemView.findViewById(R.id.result_status);
        partylogo = itemView.findViewById(R.id.partylogo_text);
        recievedseats = itemView.findViewById(R.id.seats_text);
        recievedvote = itemView.findViewById(R.id.obtainedvotes_text);
        voteshare = itemView.findViewById(R.id.voteshare_text);
        totalvotes = itemView.findViewById(R.id.totalvotes_text);
    }
}
