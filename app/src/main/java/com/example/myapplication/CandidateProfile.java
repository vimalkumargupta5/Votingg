package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CandidateProfile extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Candidates> arrayList;
    private FirebaseRecyclerOptions<Candidates> options;
    private FirebaseRecyclerAdapter<Candidates, CandidatesViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Candidates>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Candidates");
        databaseReference.keepSynced(true);
        if(!isConnected()){
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Internet Connection")
                    .setMessage("Please Chek Internet Connectivity.")
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();

        }

        options = new FirebaseRecyclerOptions.Builder<Candidates>().setQuery(databaseReference, Candidates.class).build();
        adapter = new FirebaseRecyclerAdapter<Candidates, CandidatesViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CandidatesViewHolder holder, int position, @NonNull final Candidates model) {
                holder.age.setText(model.getAge());
                holder.name.setText(model.getName());
                holder.domain.setText(model.getDomain());
                holder.place.setText(model.getPlace());
                holder.status.setText(model.getStatus());
                holder.candidateuid.setText(model.getCandidateuid());
                Picasso.get().load(model.getImage()).into(holder.image);
                Picasso.get().load(model.getPartylogo()).into(holder.partylogo);
                Picasso.get().load(model.getCandidateqr()).into(holder.candidateqr);



            }

            @NonNull
            @Override
            public CandidatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new CandidatesViewHolder(LayoutInflater.from(CandidateProfile.this).inflate(R.layout.list_layout,parent,false));
            }
        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void search(String editable) {
        Query query = databaseReference.orderByChild("name").startAt(editable).endAt(editable + "\uf8ff");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    arrayList.clear();
                    for(DataSnapshot dss: dataSnapshot.getChildren()){
                        final Candidates candidates = dss.getValue(Candidates.class);
                        arrayList.add(candidates);

                    }
                    CandidateAdapter candidateAdapter = new CandidateAdapter(getApplicationContext(),arrayList);
                    recyclerView.setAdapter(candidateAdapter);
                    candidateAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}
