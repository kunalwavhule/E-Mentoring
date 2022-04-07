package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.e_mentoringrait.R;

public class AdminBatch extends AppCompatActivity {
    RecyclerView rv1,rv2,rv3,rv4;
    TextView t1,t2,t3,t4;

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
        t2.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"1");
        t3.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"1");
        t4.setText("Year"+year+" Branch "+branch+"\nDivision : "+division+" "+division+"1");

    }
}