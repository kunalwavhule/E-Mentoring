package com.example.e_mentoringrait.mentee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.e_mentoringrait.AddMentor;
import com.example.e_mentoringrait.Login;
import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.Register;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MenteeDashboard extends AppCompatActivity {
    FirebaseAuth  auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.notes:
                        Toast.makeText(getApplicationContext(),"Its the Notes",Toast.LENGTH_LONG).show();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.chat:
                        Toast.makeText(getApplicationContext(),"Its the Chat",Toast.LENGTH_LONG).show();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.notification:
                        Toast.makeText(getApplicationContext(),"Its the Notification",Toast.LENGTH_LONG).show();                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),MenteeProfile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menteemenu,menu);
        MenuItem logout = menu.findItem(R.id.logout);

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