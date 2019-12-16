package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AssemblyViewHolder extends RecyclerView.ViewHolder {
    public TextView cm, rullingparty, state;
    public ImageView flag;
    public AssemblyViewHolder(@NonNull View itemView) {
        super(itemView);
        cm = itemView.findViewById(R.id.cmname_text);
        rullingparty = itemView.findViewById(R.id.rullingparty_text);
        state = itemView.findViewById(R.id.statename_text);
        flag = itemView.findViewById(R.id.flag_text);
    }
}
