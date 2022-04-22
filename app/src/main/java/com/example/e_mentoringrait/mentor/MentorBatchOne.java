package com.example.e_mentoringrait.mentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.e_mentoringrait.Login;
import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.MentorBatchOneAdapter;
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

    MentorBatchOneAdapter mentorBatchOneAdapter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mMentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_batch_one);
        rv = findViewById(R.id.mbrc);
        rv.setLayoutManager(new LinearLayoutManager(this));
        mMentor = FirebaseDatabase.getInstance().getReference();

        Intent intent = getIntent();
        final String branch = intent.getStringExtra("branch");
        final String year = intent.getStringExtra("year");
        final String division = intent.getStringExtra("division");
        final String batch = intent.getStringExtra("batch");

        mMentor = FirebaseDatabase.getInstance().getReference().child(branch).child(year).child(division).child(batch);
        FirebaseRecyclerOptions<DataMentee> options =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mMentor, DataMentee.class)
                        .build();
        mentorBatchOneAdapter = new MentorBatchOneAdapter(options);
        rv.setAdapter(mentorBatchOneAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        mentorBatchOneAdapter.startListening();
            }
    @Override
    protected void onStop() {
        super.onStop();
        mentorBatchOneAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menteemenu,menu);
        MenuItem logout = menu.findItem(R.id.logout);

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                auth.signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}