package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.ChatAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MenteeChat extends AppCompatActivity {
    RecyclerView rvChat;
    ChatAdapter chatAdapter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_chat);
        rvChat = findViewById(R.id.rvChat);
    }
}