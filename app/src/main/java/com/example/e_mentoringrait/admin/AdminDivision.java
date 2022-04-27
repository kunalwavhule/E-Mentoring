package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e_mentoringrait.R;

public class AdminDivision extends AppCompatActivity {
    CardView Adone,Adtwo,Adthree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_division);


        getSupportActionBar().setTitle("Admin Division");
        Adone = findViewById(R.id.Adione);
        Adtwo = findViewById(R.id.Aditwo);
        Adthree = findViewById(R.id.Adithree);

        Intent intent = getIntent();
        final String vy = intent.getStringExtra("ayy");
        final String vb = intent.getStringExtra("ayb");

        Adone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminBatch.class);
                iy.putExtra("year",vy);
                iy.putExtra("branch",vb);
                iy.putExtra("division","A");
                startActivity(iy);
            }
        });

        Adtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminBatch.class);
                iy.putExtra("year",vy);
                iy.putExtra("branch",vb);
                iy.putExtra("division","B");
                startActivity(iy);


            }
        });

        Adthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iy = new Intent(getApplicationContext(),AdminBatch.class);
                iy.putExtra("year",vy);
                iy.putExtra("branch",vb);
                iy.putExtra("division","C");
                startActivity(iy);
            }
        });
    }
}