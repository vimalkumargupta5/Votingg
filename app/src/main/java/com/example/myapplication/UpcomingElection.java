package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UpcomingElection extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Upcoming_election> arrayList;
    private FirebaseRecyclerOptions<Upcoming_election> options;
    private FirebaseRecyclerAdapter<Upcoming_election, UpcomingViewHolder> adapter;
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
        setContentView(R.layout.activity_upcoming_election);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Upcoming_election>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("UpcomingElection");
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
        options = new FirebaseRecyclerOptions.Builder<Upcoming_election>().setQuery(databaseReference, Upcoming_election.class).build();
        adapter = new FirebaseRecyclerAdapter<Upcoming_election, UpcomingViewHolder>(options) {
            @NonNull
            @Override
            public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new UpcomingViewHolder(LayoutInflater.from(UpcomingElection.this).inflate(R.layout.upcoming_election_list,parent,false));

            }

            @Override
            protected void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position, @NonNull final Upcoming_election model) {
                holder.detail.setText(model.getDetail());
                holder.year.setText(model.getYear());
                holder.electiontype.setText(model.getElectiontype());
                holder.state.setText(model.getState());
                Picasso.get().load(model.getMap()).into(holder.map);
            }

        };
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
