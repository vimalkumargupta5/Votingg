package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CandidatesViewHolder extends RecyclerView.ViewHolder {
    public TextView name,age,domain,place,status,candidateuid;
    public CircleImageView image,partylogo;
    public ImageView candidateqr;
    public CandidatesViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name_text);
        age = itemView.findViewById(R.id.age_text);
       domain = itemView.findViewById(R.id.party_nametext);
        place = itemView.findViewById(R.id.place_text);
       status = itemView.findViewById(R.id.status_text);
       image = itemView.findViewById(R.id.profile_img);
        partylogo = itemView.findViewById(R.id.party_logo);
        candidateqr = itemView.findViewById(R.id.candidateqr);
        candidateuid = itemView.findViewById(R.id.candidateuid);

    }
}
