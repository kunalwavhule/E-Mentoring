package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.AttendenceAdapter;
import com.example.e_mentoringrait.adapter.EventAdapter;
import com.example.e_mentoringrait.model.DataAttendence;
import com.example.e_mentoringrait.model.DataEvent;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenteeAttendence extends AppCompatActivity {
    RecyclerView rvAttend;
    AttendenceAdapter attendenceAdapter;
    private DatabaseReference mAttend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_attendence);
        rvAttend = findViewById(R.id.rvattentmentee);
        rvAttend.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        String branch = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");


        mAttend = FirebaseDatabase.getInstance().getReference().child("Attendence").child(branch).child(accadmicYear).child(division).child(batch).child(FirebaseAuth.getInstance().getUid());



        FirebaseRecyclerOptions<DataAttendence> options =
                new FirebaseRecyclerOptions.Builder<DataAttendence>()
                        .setQuery(mAttend, DataAttendence.class)
                        .build();
        attendenceAdapter = new AttendenceAdapter(options);
        rvAttend.setAdapter(attendenceAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        attendenceAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        attendenceAdapter.stopListening();
    }
}