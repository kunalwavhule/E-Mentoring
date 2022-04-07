package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_mentoringrait.R;

public class AdminDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }


    public void Admincs(View view) {
        Intent i = new Intent(getApplicationContext(),AdminYear.class);
        i.putExtra("adb","CS");
          startActivity(i);
    }

    public void Adminit(View view) {
        Intent i = new Intent(getApplicationContext(),AdminYear.class);
        i.putExtra("adb","IT");
        startActivity(i);

    }

    public void Adminee(View view) {
        Intent i = new Intent(getApplicationContext(),AdminYear.class);
        i.putExtra("adb","EE");
        startActivity(i);

    }

    public void Adminie(View view) {
        Intent i = new Intent(getApplicationContext(),AdminYear.class);
        i.putExtra("adb","IE");
        startActivity(i);

    }

    public void Adminete(View view) {
        Intent i = new Intent(getApplicationContext(),AdminYear.class);
        i.putExtra("adb","ETE");
        startActivity(i);

    }
}