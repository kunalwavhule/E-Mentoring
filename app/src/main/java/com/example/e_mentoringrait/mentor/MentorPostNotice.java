package com.example.e_mentoringrait.mentor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.NoticeAdapter;
import com.example.e_mentoringrait.model.DataNotice;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.DateFormat;
import java.util.Date;

public class MentorPostNotice extends AppCompatActivity {
    EditText post;
    Button btnpost;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    RecyclerView rvPost;
    NoticeAdapter noticeAdapter;
    private DatabaseReference mNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_post_notice);
        post = findViewById(R.id.post);
        getSupportActionBar().setTitle("Mentor post notice");
        btnpost = findViewById(R.id.btnpost);
        Intent intent = getIntent();
        rvPost = findViewById(R.id.rvpost);
        rvPost.setLayoutManager(new LinearLayoutManager(this));

        final String branch = intent.getStringExtra("branch");
        final String year = intent.getStringExtra("year");
        final String division = intent.getStringExtra("division");
        final String batch = intent.getStringExtra("batch");
        final String name = intent.getStringExtra("name");


        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = myRef.push().getKey();


                String date = DateFormat.getDateInstance().format(new Date());
                DataNotice dataNotice = new DataNotice(name,date,post.getText().toString());
                myRef.child("Notice").child(branch).child(year).child(division).child(batch).child(key).setValue(dataNotice);
                post.setText("");
            }
        });

        mNotice = FirebaseDatabase.getInstance().getReference().child("Notice").child(branch).child(year).child(division).child(batch);
        FirebaseRecyclerOptions<DataNotice> options =
                new FirebaseRecyclerOptions.Builder<DataNotice>()
                        .setQuery(mNotice, DataNotice.class)
                        .build();
        noticeAdapter = new NoticeAdapter(options);
        rvPost.setAdapter(noticeAdapter);


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