package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnnouncementViewHolder  extends RecyclerView.ViewHolder {
    public TextView subject,contents;

    public AnnouncementViewHolder(@NonNull View itemView) {
        super(itemView);
        subject = itemView.findViewById(R.id.subject_text);
       contents = itemView.findViewById(R.id.content_text);
    }
}
