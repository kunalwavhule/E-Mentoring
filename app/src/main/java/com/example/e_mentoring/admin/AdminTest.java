package com.example.e_mentoring.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_mentoring.R;
import com.example.e_mentoring.adapter.TestAdapter;
import com.example.e_mentoring.model.TestModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminTest extends AppCompatActivity {

    RecyclerView recyclerView;
    TestAdapter testAdapter;
    DatabaseReference mTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_test);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTest = FirebaseDatabase.getInstance().getReference().child("CS");

        FirebaseRecyclerOptions<TestModel> options =
                new FirebaseRecyclerOptions.Builder<TestModel>()
                .setQuery(mTest,TestModel.class)
                .build();
        testAdapter = new TestAdapter(options);
        recyclerView.setAdapter(testAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        testAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        testAdapter.stopListening();
    }
}