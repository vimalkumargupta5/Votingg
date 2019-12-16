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

public class Political_parties extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<PoliticalParties> arrayList;
    private FirebaseRecyclerOptions<PoliticalParties> options;
    private FirebaseRecyclerAdapter<PoliticalParties, PartiesViewHolder> adapter;
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
        setContentView(R.layout.activity_political_parties);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<PoliticalParties>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("PoliticalParties");
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
        options = new FirebaseRecyclerOptions.Builder<PoliticalParties>().setQuery(databaseReference, PoliticalParties.class).build();
        adapter = new FirebaseRecyclerAdapter<PoliticalParties, PartiesViewHolder>(options) {
            @NonNull
            @Override
            public PartiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new PartiesViewHolder(LayoutInflater.from(Political_parties.this).inflate(R.layout.party_list_layout,parent,false));

            }

            @Override
            protected void onBindViewHolder(@NonNull PartiesViewHolder holder, int position, @NonNull final PoliticalParties model) {
                holder.partyname.setText(model.getPartyname());
                holder.founded.setText(model.getFounded());
                holder.partychief.setText(model.getPartychief());
                Picasso.get().load(model.getPoliticalpartylogo()).into(holder.politicalpartylogo);
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
