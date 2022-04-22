package com.example.e_mentoringrait.mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_mentoringrait.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        //myRef.child("Notice").child()


   }
}