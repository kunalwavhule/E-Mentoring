package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.CalendarAdapter;
import com.example.e_mentoringrait.adapter.NoticeAdapter;
import com.example.e_mentoringrait.model.DataCalender;
import com.example.e_mentoringrait.model.DataNotice;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenteeNotice extends AppCompatActivity {
    RecyclerView rvNotice;
    NoticeAdapter noticeAdapter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_notice);
        rvNotice = findViewById(R.id.rvNotice);
        rvNotice.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        String branchs = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");



        mNotice = FirebaseDatabase.getInstance().getReference().child("Notice").child(branchs).child(accadmicYear).child(division).child(batch);
        FirebaseRecyclerOptions<DataNotice> options =
                new FirebaseRecyclerOptions.Builder<DataNotice>()
                        .setQuery(mNotice, DataNotice.class)
                        .build();
        noticeAdapter = new NoticeAdapter(options);
        rvNotice.setAdapter(noticeAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        noticeAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noticeAdapter.stopListening();
    }
}