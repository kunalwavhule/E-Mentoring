package com.example.e_mentoringrait.mentor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_mentoringrait.R;

public class MentorDashboard extends AppCompatActivity {
    CardView batch1,batch2,batch3,batch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_dashboard);
        batch1 = findViewById(R.id.batch1);

        batch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MentorBatchOne.class));
            }
        });
    }
}