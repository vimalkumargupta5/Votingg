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

import de.hdodenhof.circleimageview.CircleImageView;

public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.CandidateAdapterViewHolder> {
    public Context c;
    public ArrayList<Candidates> arrayList;
    public CandidateAdapter(Context c, ArrayList<Candidates> arrayList){
        this.c=c;
        this.arrayList=arrayList;

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public CandidateAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new CandidateAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateAdapterViewHolder holder, int position) {
        Candidates candidates = arrayList.get(position);
        holder.t1.setText(candidates.getName());
        holder.t2.setText(candidates.getAge());
        holder.t3.setText(candidates.getDomain());
        holder.t4.setText(candidates.getPlace());
        holder.t5.setText(candidates.getStatus());
        holder.t6.setText(candidates.getCandidateuid());
        Picasso.get().load(candidates.getImage()).into(holder.i1);
        Picasso.get().load(candidates.getPartylogo()).into(holder.i2);
        Picasso.get().load(candidates.getCandidateqr()).into(holder.i3);

    }

    public class CandidateAdapterViewHolder extends RecyclerView.ViewHolder{
        public TextView t1;
        public CircleImageView i1;
        public TextView t2;
        public TextView t3;
        public TextView t4;
        public TextView t5;
        public TextView t6;
        public ImageView i3;
        public CircleImageView i2;
        public CandidateAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.name_text);
            i1 = (CircleImageView) itemView.findViewById(R.id.profile_img);
            i2 = (CircleImageView) itemView.findViewById(R.id.party_logo);
            t2 = (TextView) itemView.findViewById(R.id.age_text);
            t3 = (TextView) itemView.findViewById(R.id.party_nametext);
            t4 = (TextView) itemView.findViewById(R.id.place_text);
            t5 = (TextView) itemView.findViewById(R.id.status_text);
            t6 = (TextView) itemView.findViewById(R.id.candidateuid);
            i3 = (ImageView) itemView.findViewById(R.id.candidateqr);
        }
    }
}
