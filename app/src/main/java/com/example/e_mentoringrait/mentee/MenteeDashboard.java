package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MenteeDashboard extends AppCompatActivity {
    FirebaseAuth  auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

    }
}