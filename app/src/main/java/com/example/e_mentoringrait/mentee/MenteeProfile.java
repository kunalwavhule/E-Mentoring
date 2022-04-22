package com.example.e_mentoringrait.mentee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_mentoringrait.Login;
import com.example.e_mentoringrait.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class MenteeProfile extends AppCompatActivity {
    FirebaseAuth auth = FirebaseAuth.getInstance();

    private DatabaseReference mDatabase;
    TextView FullName,MotherName,Email,StudentNumber,ParentNumber,Branch,Address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_profile);
        FullName = findViewById(R.id.FullName);
        MotherName = findViewById(R.id.MotherName);
        Email = findViewById(R.id.Email);
        StudentNumber = findViewById(R.id.StudentNumber);
        ParentNumber = findViewById(R.id.ParentNumber);
        Branch = findViewById(R.id.Branch);
        Address = findViewById(R.id.Address);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String FullName1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("fullName").getValue(String.class);
                String MotherName1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("motherName").getValue(String.class);
                String Email1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("email").getValue(String.class);
                String StudentNumber1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("studentNumber").getValue(String.class);
                String ParentNumber1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("parentNumber").getValue(String.class);
                String Branch1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("branch").getValue(String.class);
                String Address1 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("address").getValue(String.class);
                FullName.setText(FullName1);
                MotherName.setText(MotherName1);
                Email.setText(Email1);
                StudentNumber.setText(StudentNumber1);
                ParentNumber.setText(ParentNumber1);
                Branch.setText(Branch1);
                Address.setText(Address1);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        mDatabase.addValueEventListener(postListener);

        //Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.notes:
                        Toast.makeText(getApplicationContext(),"Its the Notes",Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        return true;
                    case R.id.chat:
                        Toast.makeText(getApplicationContext(),"Its the Chat",Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.notification:
                        Toast.makeText(getApplicationContext(),"Its the Notification",Toast.LENGTH_SHORT).show();                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MenteeDashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    //Upper Menu
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