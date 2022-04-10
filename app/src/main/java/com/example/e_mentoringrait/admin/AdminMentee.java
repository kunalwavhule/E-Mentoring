package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.e_mentoringrait.R;

public class AdminMentee extends AppCompatActivity {
    TextView textView,afullname,amobileno,aemail,abranch,arollno,areligion,acaste;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mentee);
        textView = findViewById(R.id.t1);
        afullname = findViewById(R.id.FullNameam);
        amobileno = findViewById(R.id.StudentNumberam);
        aemail = findViewById(R.id.Emailam);
        abranch = findViewById(R.id.Brancham);
        arollno = findViewById(R.id.RollNoam);
        areligion = findViewById(R.id.spnReligionam);
        acaste = findViewById(R.id.spnCasteam);
        back = findViewById(R.id.back);

        String fullname = getIntent().getStringExtra("fullname");
        String mobileno = getIntent().getStringExtra("mobileno");
        String email = getIntent().getStringExtra("fullname");
        String branch = getIntent().getStringExtra("branch");
        String rollno = getIntent().getStringExtra("rollno");
        String religion = getIntent().getStringExtra("religion");
        String caste = getIntent().getStringExtra("caste");
        String accadmicyear = getIntent().getStringExtra("accadmicyear");
        String div = getIntent().getStringExtra("division");


        textView.setText(fullname);
        afullname.setText("Name \t\t:"+fullname);
        amobileno.setText(mobileno);
        aemail.setText(email);
        abranch.setText(branch);
        arollno.setText("Roll Number \t\t:"+rollno);
        areligion.setText("Religion \t\t:"+religion);
        acaste.setText("Category \t\t:"+caste);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iy = new Intent(getApplicationContext(),AdminBatch.class);
                iy.putExtra("year",accadmicyear);
                iy.putExtra("branch",branch);
                iy.putExtra("division",div);
                startActivity(iy);
                finish();

            }
        });

    }
}