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

public class VotersAdapter extends RecyclerView.Adapter<VotersAdapter.VotersAdapterViewHolder> {
    public Context c;
    public ArrayList<VotersViews> arrayList;
    public VotersAdapter(Context c, ArrayList<VotersViews> arrayList){
        this.c=c;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public VotersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.voters_list,parent,false);
        return new VotersAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VotersAdapterViewHolder holder, int position) {
        VotersViews votersViews = arrayList.get(position);
        holder.t1.setText(votersViews.getUid());
        holder.t2.setText(votersViews.getVotername());
        holder.t3.setText(votersViews.getVoteraddress());
        holder.t4.setText(votersViews.getVoterdob());
        holder.t5.setText(votersViews.getVotergender());
        holder.t6.setText(votersViews.getVotercontact());
        Picasso.get().load(votersViews.getVoterprofile()).into(holder.i1);
        Picasso.get().load(votersViews.getVoterbarcode()).into(holder.i2);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public class VotersAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView t1;
        public TextView t2;
        public TextView t3;
        public TextView t4;
        public TextView t5;
        public TextView t6;
        public CircleImageView i1;
        public ImageView i2;
        public VotersAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.uid);
            t2 = (TextView) itemView.findViewById(R.id.votername);
            t3 = (TextView) itemView.findViewById(R.id.voteraddress);
            t4 = (TextView) itemView.findViewById(R.id.voterdob);
            t5 = (TextView) itemView.findViewById(R.id.votergender);
            t6 = (TextView) itemView.findViewById(R.id.votercontact);
            i1 = (CircleImageView) itemView.findViewById(R.id.voterprofile);
            i2 = (ImageView) itemView.findViewById(R.id.voterbarcode);
        }
    }
}
