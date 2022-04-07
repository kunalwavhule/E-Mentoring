package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.e_mentoringrait.R;

public class AdminMentee extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mentee);
        textView = findViewById(R.id.t1);

        String qty = getIntent().getStringExtra("abc");
        textView.setText(qty);
    }
}