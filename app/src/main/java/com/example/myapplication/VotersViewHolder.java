package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class VotersViewHolder extends RecyclerView.ViewHolder {
    public TextView uid, votername, voteraddress, voterdob, votergender, votercontact;
    public CircleImageView voterprofile;
    public ImageView voterbarcode;

    public VotersViewHolder(@NonNull View itemView) {
        super(itemView);
        uid = itemView.findViewById(R.id.uid);
        votername = itemView.findViewById(R.id.votername);
        voteraddress = itemView.findViewById(R.id.voteraddress);
        voterdob = itemView.findViewById(R.id.voterdob);
        votergender = itemView.findViewById(R.id.votergender);
        votercontact = itemView.findViewById(R.id.votercontact);
        voterprofile = itemView.findViewById(R.id.voterprofile);
        voterbarcode = itemView.findViewById(R.id.voterbarcode);
    }
}
