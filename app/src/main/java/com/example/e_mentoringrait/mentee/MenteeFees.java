package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.FeesAdapter;
import com.example.e_mentoringrait.adapter.SemAdapter;
import com.example.e_mentoringrait.model.DataFees;
import com.example.e_mentoringrait.model.DataSemSubject;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenteeFees extends AppCompatActivity {
    RecyclerView recyclerView;
    FeesAdapter feesAdapter;
    private DatabaseReference mFees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_fees);
        recyclerView = findViewById(R.id.rvmenteefees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();

        String branchs = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");
        mFees = FirebaseDatabase.getInstance().getReference().child("Fees").child(branchs).child(accadmicYear).child(division).child(batch);

        FirebaseRecyclerOptions<DataFees> options =
                new FirebaseRecyclerOptions.Builder<DataFees>()
                        .setQuery(mFees, DataFees.class)
                        .build();
        feesAdapter = new FeesAdapter(options);
        recyclerView.setAdapter(feesAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        feesAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        feesAdapter.stopListening();
    }

}