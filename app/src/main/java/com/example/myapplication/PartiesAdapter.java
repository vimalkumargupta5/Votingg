package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PartiesAdapter extends RecyclerView.Adapter<PartiesAdapter.PartiesAdapterViewHolder> {
    public Context c;
    public ArrayList<PoliticalParties> arrayList;
    public PartiesAdapter(Context c, ArrayList<PoliticalParties> arrayList){
        this.c=c;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public PartiesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.party_list_layout,parent,false);
        return new PartiesAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PartiesAdapterViewHolder holder, int position) {
       PoliticalParties politicalParties = arrayList.get(position);
        holder.t1.setText(politicalParties.getPartyname());
        holder.t2.setText(politicalParties.getFounded());
        holder.t3.setText(politicalParties.getPartychief());
        Picasso.get().load(politicalParties.getPoliticalpartylogo()).into(holder.i1);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    public class PartiesAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView t1;
        public CircleImageView i1;
        public TextView t2;
        public TextView t3;

        public PartiesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.indianpartyname);
            i1 = (CircleImageView) itemView.findViewById(R.id.indianpartylogo);
            t2 = (TextView) itemView.findViewById(R.id.founded);
            t3 = (TextView) itemView.findViewById(R.id.chief);
        }
    }
}
