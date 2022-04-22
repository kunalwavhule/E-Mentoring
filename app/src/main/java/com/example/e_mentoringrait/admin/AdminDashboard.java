package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.e_mentoringrait.AddMentor;
import com.example.e_mentoringrait.Login;
import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.Register;
import com.google.firebase.auth.FirebaseAuth;

public class AdminDashboard extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adminmenu,menu);
        MenuItem logout = menu.findItem(R.id.logout);
        MenuItem addmentee = menu.findItem(R.id.addmentee);
        MenuItem addmentor = menu.findItem(R.id.addmentor);
        MenuItem addlecture = menu.findItem(R.id.addlecture);

        addmentee.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(), Register.class));
                return false;
            }
        });
        addmentor.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(), AddMentor.class));
                return false;
            }
        });
        addlecture.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(), AdminCalendar.class));
                return false;
            }
        });

        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                auth.signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}