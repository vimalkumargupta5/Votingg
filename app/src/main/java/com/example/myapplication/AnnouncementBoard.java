package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

public class AnnouncementBoard extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Announcement> arrayList;
    private FirebaseRecyclerOptions<Announcement> options;
    private FirebaseRecyclerAdapter<Announcement, AnnouncementViewHolder> adapter;
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
        setContentView(R.layout.activity_announcement_board);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.announcement_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Announcement>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Announcement");
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

        options = new FirebaseRecyclerOptions.Builder<Announcement>().setQuery(databaseReference, Announcement.class).build();
        adapter = new FirebaseRecyclerAdapter<Announcement, AnnouncementViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position, @NonNull Announcement model) {
                holder.subject.setText(model.getSubject());
                holder.contents.setText(model.getContents());
            }
            @NonNull
            @Override
            public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new AnnouncementViewHolder(LayoutInflater.from(AnnouncementBoard.this).inflate(R.layout.announcement_layout,parent,false));
            }
        };
        recyclerView.setAdapter(adapter);
    }
    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
