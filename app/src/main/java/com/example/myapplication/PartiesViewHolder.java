package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class PartiesViewHolder extends RecyclerView.ViewHolder {
    public TextView partyname,founded,partychief;
    public CircleImageView politicalpartylogo;
    public PartiesViewHolder(@NonNull View itemView) {
        super(itemView);
        partyname = itemView.findViewById(R.id.indianpartyname);
        founded = itemView.findViewById(R.id.founded);
        partychief = itemView.findViewById(R.id.chief);
        politicalpartylogo = itemView.findViewById(R.id.indianpartylogo);
    }
}
