package com.example.e_mentoring.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.e_mentoring.Login;
import com.example.e_mentoring.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AdminDashboard extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();
    String addyeares[] = {"2015","2016","2017","2018","2019","2020","2021","2022"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        ArrayAdapter<String> addyearsAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                addyeares
        );
        AutoCompleteTextView addyear = findViewById(R.id.spnsem);
        addyear.setAdapter(addyearsAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout,menu);
        MenuItem logout = menu.findItem(R.id.lagout);
        MenuItem addmentee = menu.findItem(R.id.add);
        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                auth.signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return false;
            }
        });
        addmentee.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplicationContext(),AddMentee.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void admincs(View view) {
        startActivity(new Intent(getApplicationContext(),AdminMentee.class));

    }

    public void adminit(View view) {
        startActivity(new Intent(getApplicationContext(),AdminTest.class));
    }
}