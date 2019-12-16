package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

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

public class VotersList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<VotersViews> arrayList;
    private FirebaseRecyclerOptions<VotersViews> options;
    private FirebaseRecyclerAdapter<VotersViews, VotersViewHolder> adapter;
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
        setContentView(R.layout.activity_voters_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<VotersViews>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Voters");
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
        options = new FirebaseRecyclerOptions.Builder<VotersViews>().setQuery(databaseReference, VotersViews.class).build();
        adapter = new FirebaseRecyclerAdapter<VotersViews, VotersViewHolder>(options) {
            @NonNull
            @Override
            public VotersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new VotersViewHolder(LayoutInflater.from(VotersList.this).inflate(R.layout.voters_list,parent,false));

            }

            @Override
            protected void onBindViewHolder(@NonNull VotersViewHolder holder, int position, @NonNull final VotersViews model) {
                holder.uid.setText(model.getUid());
                holder.votername.setText(model.getVotername());
                holder.voteraddress.setText(model.getVoteraddress());
                holder.voterdob.setText(model.getVoterdob());
                holder.votergender.setText(model.getVotergender());
                holder.votercontact.setText(model.getVotercontact());
                Picasso.get().load(model.getVoterprofile()).into(holder.voterprofile);
                Picasso.get().load(model.getVoterbarcode()).into(holder.voterbarcode);
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
                        final VotersViews votersViews = dss.getValue(VotersViews.class);
                        arrayList.add(votersViews);

                    }
                    VotersAdapter votersAdapter = new VotersAdapter(getApplicationContext(),arrayList);
                    recyclerView.setAdapter(votersAdapter);
                    votersAdapter.notifyDataSetChanged();
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
