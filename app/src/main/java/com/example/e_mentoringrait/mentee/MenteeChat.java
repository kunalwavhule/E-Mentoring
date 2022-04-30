package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.ChatAdapter;
import com.example.e_mentoringrait.adapter.NoticeAdapter;
import com.example.e_mentoringrait.model.DataChat;
import com.example.e_mentoringrait.model.DataNotice;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MenteeChat extends AppCompatActivity {
    RecyclerView rvChat;
    ChatAdapter chatAdapter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mChat;
    ImageButton send;
    EditText esmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_chat);
        rvChat = findViewById(R.id.rvChat);
        getSupportActionBar().setTitle("Mentee Chat");
        rvChat.setLayoutManager(new LinearLayoutManager(this));
        esmsg = findViewById(R.id.esmsg);
        send = findViewById(R.id.isbtn);
        Intent intent = getIntent();
        String branchs = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");
        String mentorUid = intent.getStringExtra("mentorUid");
        String sname = intent.getStringExtra("sname");


        mChat = FirebaseDatabase.getInstance().getReference().child("Chat").child(branchs).child(accadmicYear).child(division).child(batch).child(mentorUid).child(batch).child(FirebaseAuth.getInstance().getUid());

        FirebaseRecyclerOptions<DataChat> options =
                new FirebaseRecyclerOptions.Builder<DataChat>()
                        .setQuery(mChat, DataChat.class)
                        .build();
        chatAdapter = new ChatAdapter(options);
        rvChat.setAdapter(chatAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String msg = esmsg.getText().toString();
                    String key = mChat.push().getKey();
                if (TextUtils.isEmpty(msg)) {
                    return;
                }else {

                    String currentTimes = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                    DataChat dataChat = new DataChat(msg, sname, currentTimes);
                    mChat.child(key).setValue(dataChat);
                    esmsg.setText("");
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        chatAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        chatAdapter.stopListening();
    }
}

