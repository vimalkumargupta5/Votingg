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

public class ResultTwoVidhan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Assembly> arrayList;
    private FirebaseRecyclerOptions<Assembly> options;
    private FirebaseRecyclerAdapter<Assembly, AssemblyViewHolder> adapter;
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
        setContentView(R.layout.activity_result_two_vidhan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.assembly_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Assembly>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("AResult");
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

        options = new FirebaseRecyclerOptions.Builder<Assembly>().setQuery(databaseReference, Assembly.class).build();
        adapter = new FirebaseRecyclerAdapter<Assembly, AssemblyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AssemblyViewHolder holder, int position, @NonNull final Assembly model) {
                holder.cm.setText(model.getCm());
                holder.rullingparty.setText(model.getRullingparty());
                holder.state.setText(model.getState());

                Picasso.get().load(model.getFlag()).into(holder.flag);




            }

            @NonNull
            @Override
            public AssemblyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new AssemblyViewHolder(LayoutInflater.from(ResultTwoVidhan.this).inflate(R.layout.assembly_result_layout,parent,false));
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
