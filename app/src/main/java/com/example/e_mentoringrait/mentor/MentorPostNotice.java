package com.example.e_mentoringrait.mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataNotice;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.DateFormat;
import java.util.Date;

public class MentorPostNotice extends AppCompatActivity {
    EditText post;
    Button btnpost;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_post_notice);
        post = findViewById(R.id.post);
        btnpost = findViewById(R.id.btnpost);
        Intent intent = getIntent();
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


   }
}