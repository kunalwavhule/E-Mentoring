package com.example.e_mentoringrait.mentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.UserAdapter;
import com.example.e_mentoringrait.model.DataMentee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MentorBatchOne extends AppCompatActivity {
    RecyclerView rv;

    UserAdapter userAdapter;
    FirebaseAuth auth;
    private DatabaseReference mMentor;
    String branch,year,division,batch;
    TextView branch1,year1,division1,batch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_batch_one);
        rv = findViewById(R.id.mbrc);
        rv.setLayoutManager(new LinearLayoutManager(this));
        auth = FirebaseAuth.getInstance();
        mMentor = FirebaseDatabase.getInstance().getReference();
        branch1 = findViewById(R.id.textView);
        year1 = findViewById(R.id.textView2);
        division1 = findViewById(R.id.textView3);
        batch1 = findViewById(R.id.textView4);


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                year  = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear1").getValue(String.class);
                batch = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch1").getValue(String.class);
                division = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division1").getValue(String.class);
                branch = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("branch").getValue(String.class);
                year1.setText(year);
                batch1.setText(batch);
                division1.setText(division);
                branch1.setText(branch);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };

        mMentor.addValueEventListener(postListener);
        mMentor = FirebaseDatabase.getInstance().getReference().child(branch1.getText().toString()).child(year1.getText().toString()).child(division1.getText().toString()).child(batch1.getText().toString());
        FirebaseRecyclerOptions<DataMentee> options =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mMentor, DataMentee.class)
                        .build();
        userAdapter = new UserAdapter(options);
        rv.setAdapter(userAdapter);




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