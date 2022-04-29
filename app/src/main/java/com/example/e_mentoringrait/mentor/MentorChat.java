package com.example.e_mentoringrait.mentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.ChatAdapter;
import com.example.e_mentoringrait.model.DataChat;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class MentorChat extends AppCompatActivity {

    RecyclerView rvChat;
    ChatAdapter chatAdapter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mChat,mDatabase;
    ImageButton send;
    EditText esmsg;
    TextView mentorname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_chat);
        getSupportActionBar().setTitle("Mentor Chat");

        rvChat = findViewById(R.id.rvChats);
        rvChat.setLayoutManager(new LinearLayoutManager(this));
        esmsg = findViewById(R.id.editTextchat);
        send = findViewById(R.id.btnChat);

        mentorname = findViewById(R.id.mnamechat);

        String branch = getIntent().getStringExtra("branch");
        String accadmicyear = getIntent().getStringExtra("accadmicyear");
        String div = getIntent().getStringExtra("div");
        String batch = getIntent().getStringExtra("batch");
        String suid = getIntent().getStringExtra("menteeUid");
        String tuid = getIntent().getStringExtra("mentorUid");
        getSupportActionBar().setTitle("Mentor Chat");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String fullName = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("mentorName").getValue(String.class);
                mentorname.setText(fullName);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        mDatabase.addValueEventListener(postListener);



        mChat = FirebaseDatabase.getInstance().getReference().child("Chat").child(branch).child(accadmicyear).child(div).child(batch).child(FirebaseAuth.getInstance().getUid()).child(batch).child(suid);

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
                    Date currentTime = Calendar.getInstance().getTime();


                    String d1 = currentTime.toString();
                    String mentorName = mentorname.getText().toString();
                    DataChat dataChat = new DataChat(msg, mentorName, d1);
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