package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingAdapterViewHolder>{
    public Context c;
    public ArrayList<Upcoming_election> arrayList;
    public UpcomingAdapter(Context c, ArrayList<Upcoming_election> arrayList){
        this.c=c;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public UpcomingAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_election_list,parent,false);
        return new UpcomingAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingAdapterViewHolder holder, int position) {
        Upcoming_election upcoming_election = arrayList.get(position);
        holder.t1.setText(upcoming_election.getDetail());
        holder.t2.setText(upcoming_election.getElectiontype());
        holder.t3.setText(upcoming_election.getState());
        holder.t4.setText(upcoming_election.getYear());

        Picasso.get().load(upcoming_election.getMap()).into(holder.i1);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public class UpcomingAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView t1;
        public TextView t2;
        public TextView t3;
        public TextView t4;
        public ImageView i1;
        public UpcomingAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.electiondetail);
            t2 = (TextView) itemView.findViewById(R.id.electiontype);
            t3 = (TextView) itemView.findViewById(R.id.electionstate);
            t4 = (TextView) itemView.findViewById(R.id.electionyear);
            i1 = (ImageView) itemView.findViewById(R.id.statemap);
        }
    }
}
