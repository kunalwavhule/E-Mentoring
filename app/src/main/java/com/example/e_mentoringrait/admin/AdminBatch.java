package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.UserAdapter;
import com.example.e_mentoringrait.model.DataMentee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminBatch extends AppCompatActivity {
    RecyclerView rv1,rv2,rv3,rv4;
    TextView t1,t2,t3,t4;

    UserAdapter userAdapter1,userAdapter2,userAdapter3,userAdapter4;
    FirebaseAuth auth;
    private DatabaseReference mMentee1,mMentee2,mMentee3,mMentee4,mJobPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_batch);
        rv1 = findViewById(R.id.rv1);
        rv2 = findViewById(R.id.rv2);
        rv3 = findViewById(R.id.rv3);
        rv4 = findViewById(R.id.rv4);

        t1 = findViewById(R.id.tv1);
        t2 = findViewById(R.id.tv2);
        t3 = findViewById(R.id.tv3);
        t4 = findViewById(R.id.tv4);

        Intent intent = getIntent();
        final String year = intent.getStringExtra("year");
        final String branch = intent.getStringExtra("branch");
        final String division = intent.getStringExtra("division");

        t1.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"1");
        t2.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"2");
        t3.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"3");
        t4.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"4");

        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv3.setLayoutManager(new LinearLayoutManager(this));
        rv4.setLayoutManager(new LinearLayoutManager(this));

        auth = FirebaseAuth.getInstance();


        mMentee1 = FirebaseDatabase.getInstance().getReference().child(branch).child(year).child(division).child("1");
        FirebaseRecyclerOptions<DataMentee> options =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mMentee1, DataMentee.class)
                        .build();
        userAdapter1 = new UserAdapter(options);
        rv1.setAdapter(userAdapter1);


        mMentee2 = FirebaseDatabase.getInstance().getReference().child(branch).child(year).child(division).child("2");
        FirebaseRecyclerOptions<DataMentee> options2 =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mMentee2, DataMentee.class)
                        .build();
        userAdapter2 = new UserAdapter(options2);
        rv2.setAdapter(userAdapter2);

        mMentee3 = FirebaseDatabase.getInstance().getReference().child(branch).child(year).child(division).child("3");
        FirebaseRecyclerOptions<DataMentee> options3 =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mMentee3, DataMentee.class)
                        .build();
        userAdapter3 = new UserAdapter(options3);
        rv3.setAdapter(userAdapter3);


        mMentee4 = FirebaseDatabase.getInstance().getReference().child(branch).child(year).child(division).child("3");
        FirebaseRecyclerOptions<DataMentee> options4 =
                new FirebaseRecyclerOptions.Builder<DataMentee>()
                        .setQuery(mMentee4, DataMentee.class)
                        .build();
        userAdapter4 = new UserAdapter(options4);
        rv4.setAdapter(userAdapter4);





    }

    @Override
    protected void onStart() {
        super.onStart();
        userAdapter1.startListening();
        userAdapter2.startListening();
        userAdapter3.startListening();
        userAdapter4.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        userAdapter1.stopListening();
        userAdapter2.stopListening();
        userAdapter3.stopListening();
        userAdapter4.stopListening();
    }

}