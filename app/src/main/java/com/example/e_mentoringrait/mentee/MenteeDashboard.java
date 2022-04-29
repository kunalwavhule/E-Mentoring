package com.example.e_mentoringrait.mentee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_mentoringrait.AddMentor;
import com.example.e_mentoringrait.Login;
import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.Register;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenteeDashboard extends AppCompatActivity {
    FirebaseAuth  auth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase;
    TextView one,two,three,four,sname,sRollno,mentorUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_dashboard);
        getSupportActionBar().setTitle("Mentee Dashboard");
        one = findViewById(R.id.textView17);
        two = findViewById(R.id.textView18);
        three = findViewById(R.id.textView19);
        four = findViewById(R.id.textView20);
        sname = findViewById(R.id.sName);
        sRollno = findViewById(R.id.sRollno);
        mentorUid = findViewById(R.id.mentorUid);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String branch = snapshot.child("User").child(auth.getUid()).child("branch").getValue(String.class);
                String batch = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch").getValue(String.class);
                String accadmicYear = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear").getValue(String.class);
                String division = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division").getValue(String.class);
                String fullName = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("fullName").getValue(String.class);
                String rollNo = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("rollNo").getValue(String.class);
                String mentorid = snapshot.child("mentor").child(branch).child(accadmicYear).child(division).child(batch).child("uid").getValue(String.class);

                one.setText(branch);
                two.setText(accadmicYear);
                three.setText(division);
                four.setText(batch);
                sname.setText("Name  -  "+fullName);
                sRollno.setText(""+rollNo);
                mentorUid.setText(mentorid);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        mDatabase.addValueEventListener(postListener);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.notes:
                        Intent i = new Intent(getApplicationContext(), MenteeAttendence.class);
                        i.putExtra("branch", one.getText().toString());
                        i.putExtra("accadmicYear", two.getText().toString());
                        i.putExtra("division", three.getText().toString());
                        i.putExtra("batch", four.getText().toString());
                        startActivity(i);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.chat:
                        Intent myIntent = new Intent(getApplicationContext(), MenteeChat.class);
                        myIntent.putExtra("branch", one.getText().toString());
                        myIntent.putExtra("accadmicYear", two.getText().toString());
                        myIntent.putExtra("division", three.getText().toString());
                        myIntent.putExtra("batch", four.getText().toString());
                        myIntent.putExtra("mentorUid", mentorUid.getText().toString());
                        myIntent.putExtra("sname", sname.getText().toString());

                        startActivity(myIntent);

                        return true;

                    case R.id.notification:
                        Intent intentnotification = new Intent(getApplicationContext(), MenteeNotice.class);
                        intentnotification.putExtra("branch", one.getText().toString());
                        intentnotification.putExtra("accadmicYear", two.getText().toString());
                        intentnotification.putExtra("division", three.getText().toString());
                        intentnotification.putExtra("batch", four.getText().toString());
                        startActivity(intentnotification);
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
        MenuItem about = menu.findItem(R.id.about);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String branch = snapshot.child("User").child(auth.getUid()).child("branch").getValue(String.class);
                String batch = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch").getValue(String.class);
                String accadmicYear = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear").getValue(String.class);
                String division = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division").getValue(String.class);
                one.setText(branch);
                two.setText(accadmicYear);
                three.setText(division);
                four.setText(batch);
                //phoneno.setText(phone_no);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        };
        mDatabase.addValueEventListener(postListener);


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

    public void Calender(View view) {
        Intent myIntent = new Intent(this, MenteeCalendar.class);
        myIntent.putExtra("branch", one.getText().toString());
        myIntent.putExtra("accadmicYear", two.getText().toString());
        myIntent.putExtra("division", three.getText().toString());
        myIntent.putExtra("batch", four.getText().toString());
        startActivity(myIntent);
    }

    public void ExtraCirculam(View view) {
        Intent myIntent = new Intent(this, MenteeExtraCirculam.class);
        myIntent.putExtra("branch", one.getText().toString());
        myIntent.putExtra("accadmicYear", two.getText().toString());
        myIntent.putExtra("division", three.getText().toString());
        myIntent.putExtra("batch", four.getText().toString());
        startActivity(myIntent);

    }

    public void Grades(View view) {

        Intent myIntent = new Intent(this, MenteeGrades.class);
        myIntent.putExtra("branch", one.getText().toString());
        myIntent.putExtra("accadmicYear", two.getText().toString());
        myIntent.putExtra("division", three.getText().toString());
        myIntent.putExtra("batch", four.getText().toString());
        startActivity(myIntent);

    }

    public void Fees(View view) {
        Intent myIntent = new Intent(this, MenteeFees.class);
        myIntent.putExtra("branch", one.getText().toString());
        myIntent.putExtra("accadmicYear", two.getText().toString());
        myIntent.putExtra("division", three.getText().toString());
        myIntent.putExtra("batch", four.getText().toString());
        startActivity(myIntent);

    }
}