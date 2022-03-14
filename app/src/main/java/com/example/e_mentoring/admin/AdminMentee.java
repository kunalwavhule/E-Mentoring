package com.example.e_mentoring.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.e_mentoring.Login;
import com.example.e_mentoring.R;
import com.google.firebase.auth.FirebaseAuth;

public class AdminMentee extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mentee);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation,menu);
        MenuItem logout = menu.findItem(R.id.lagout);
        MenuItem add = menu.findItem(R.id.add);
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