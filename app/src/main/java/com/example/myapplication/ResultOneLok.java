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

public class ResultOneLok extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Loksabha> arrayList;
    private FirebaseRecyclerOptions<Loksabha> options;
    private FirebaseRecyclerAdapter<Loksabha, LoksabhaViewHolder> adapter;
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
        setContentView(R.layout.activity_result_one_lok);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.loksabha_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Loksabha>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Results");
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

        options = new FirebaseRecyclerOptions.Builder<Loksabha>().setQuery(databaseReference, Loksabha.class).build();
        adapter = new FirebaseRecyclerAdapter<Loksabha, LoksabhaViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull LoksabhaViewHolder holder, int position, @NonNull final Loksabha model) {
                holder.partyname.setText(model.getPartyname());
                holder.status.setText(model.getStatus());
                holder.recievedseats.setText(model.getRecievedseats());
                holder.recievedvote.setText(model.getRecievedvote());
                holder.totalvotes.setText(model.getTotalvotes());
                holder.voteshare.setText(model.getVoteshare());

                Picasso.get().load(model.getPartylogo()).into(holder.partylogo);




            }

            @NonNull
            @Override
            public LoksabhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new LoksabhaViewHolder(LayoutInflater.from(ResultOneLok.this).inflate(R.layout.result_party_layout,parent,false));
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
