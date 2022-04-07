package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_mentoringrait.R;

public class AdminYear extends AppCompatActivity {
    CardView Cfe,Cse,Cte,Cbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_year);
        Cfe = findViewById(R.id.Ayfe);
        Cse = findViewById(R.id.Ayse);
        Cte = findViewById(R.id.Ayte);
        Cbe = findViewById(R.id.Aybe);
        Intent intent = getIntent();
        final String value = intent.getStringExtra("adb");
        getSupportActionBar().setTitle(value);

        Cfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminDivision.class);
                iy.putExtra("ayy","FE");
                iy.putExtra("ayb",value);
                startActivity(iy);
            }
        });

        Cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminDivision.class);
                iy.putExtra("ayy","SE");
                iy.putExtra("ayb",value);
                startActivity(iy);
            }
        });

        Cte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminDivision.class);
                iy.putExtra("ayy","TE");
                iy.putExtra("ayb",value);
                startActivity(iy);
            }
        });

        Cbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminDivision.class);
                iy.putExtra("ayy","BE");
                iy.putExtra("ayb",value);
                startActivity(iy);
            }
        });


    }

}