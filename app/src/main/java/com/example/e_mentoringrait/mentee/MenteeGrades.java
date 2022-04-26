package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.SemAdapter;
import com.example.e_mentoringrait.model.DataSemSubject;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenteeGrades extends AppCompatActivity {

    RecyclerView rvSem;
    SemAdapter semAdapter;
    private DatabaseReference mSem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_grades);
        rvSem = findViewById(R.id.rvSems);
        rvSem.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        String branchs = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");


        mSem = FirebaseDatabase.getInstance().getReference().child("Grades").child(branchs).child(accadmicYear).child(division).child(batch).child(FirebaseAuth.getInstance().getUid());

        FirebaseRecyclerOptions<DataSemSubject> options =
                new FirebaseRecyclerOptions.Builder<DataSemSubject>()
                        .setQuery(mSem, DataSemSubject.class)
                        .build();
        semAdapter = new SemAdapter(options);
        rvSem.setAdapter(semAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        semAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        semAdapter.stopListening();
    }
}