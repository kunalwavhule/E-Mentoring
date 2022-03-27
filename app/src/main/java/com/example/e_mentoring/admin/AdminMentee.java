package com.example.e_mentoring.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.e_mentoring.Login;
import com.example.e_mentoring.R;
import com.example.e_mentoring.adapter.UserAdapter;
import com.example.e_mentoring.model.Data;
import com.example.e_mentoring.model.DataMentee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminMentee extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    FirebaseAuth auth;
    private DatabaseReference mJobPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mentee);
        recyclerView = findViewById(R.id.rvcs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        auth = FirebaseAuth.getInstance();
        FirebaseUser mUser = auth.getCurrentUser();
        String uid = mUser.getUid();
        mJobPost = FirebaseDatabase.getInstance().getReference().child("CS").child("FE").child("B").child("B1");
        FirebaseRecyclerOptions<DataMentee> options =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mJobPost, DataMentee.class)
                        .build();
      userAdapter = new UserAdapter(options);
        recyclerView.setAdapter(userAdapter);


    }
    @Override
    protected void onStart() {
        super.onStart();
        userAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        userAdapter.stopListening();
    }

}
