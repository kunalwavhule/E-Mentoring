package com.example.e_mentoringrait.mentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_mentoringrait.Login;
import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.admin.AdminYear;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MentorDashboard extends AppCompatActivity {
    CardView batch1,batch2,batch3,batch4;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase = database.getReference();
    TextView branch1,year1,division1,batch01,branch2,year2,division2,batch02,
            branch3,year3,division3,batch03,
            branch4,year4,division4,batch04,MentorName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_dashboard);
        batch1 = findViewById(R.id.batch1);
        batch2 = findViewById(R.id.batch2);
        batch3 = findViewById(R.id.batch3);
        getSupportActionBar().setTitle("Mentor Dashboard");
        batch4 = findViewById(R.id.batch4);
        MentorName = findViewById(R.id.MentorName);

        getSupportActionBar().setTitle("Mentor DashBoard");

        branch1 = findViewById(R.id.textView);
        year1 = findViewById(R.id.textView2);
        division1 = findViewById(R.id.textView3);
        batch01 = findViewById(R.id.textView4);

        branch2 = findViewById(R.id.textView5);
        year2 = findViewById(R.id.textView6);
        division2 = findViewById(R.id.textView7);
        batch02 = findViewById(R.id.textView8);

        branch3 = findViewById(R.id.textView9);
        year3 = findViewById(R.id.textView10);
        division3 = findViewById(R.id.textView11);
        batch03 = findViewById(R.id.textView12);

        branch4 = findViewById(R.id.textView13);
        year4 = findViewById(R.id.textView14);
        division4 = findViewById(R.id.textView15);
        batch04 = findViewById(R.id.textView16);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

              String branch = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("branch").getValue(String.class);
              String year = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear1").getValue(String.class);
              String division = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division1").getValue(String.class);
              String batch = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch1").getValue(String.class);

                String sbranch2 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("branch").getValue(String.class);
                String syear2 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear2").getValue(String.class);
                String sdivision2 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division2").getValue(String.class);
                String sbatch2 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch2").getValue(String.class);

                String sbranch3 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("branch").getValue(String.class);
                String syear3 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear3").getValue(String.class);
                String sdivision3 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division3").getValue(String.class);
                String sbatch3 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch3").getValue(String.class);

                String sbranch4 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("branch").getValue(String.class);
                String syear4 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("accadmicYear4").getValue(String.class);
                String sdivision4 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("division4").getValue(String.class);
                String sbatch4 = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("batch4").getValue(String.class);
                String mentorName = snapshot.child("User").child(FirebaseAuth.getInstance().getUid()).child("mentorName").getValue(String.class);


                branch1.setText(branch);
                year1.setText(year);
                division1.setText(division);
                batch01.setText(batch);

                branch2.setText(sbranch2);
                year2.setText(syear2);
                division2.setText(sdivision2);
                batch02.setText(sbatch2);

                branch3.setText(sbranch3);
                year3.setText(syear3);
                division3.setText(sdivision3);
                batch03.setText(sbatch3);

                branch4.setText(sbranch4);
                year4.setText(syear4);
                division4.setText(sdivision4);
                batch04.setText(sbatch4);
                MentorName.setText(mentorName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        mDatabase.addValueEventListener(valueEventListener);


        batch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentorBatchOne.class);
                i.putExtra("branch",branch1.getText().toString());
                i.putExtra("year",year1.getText().toString());
                i.putExtra("division",division1.getText().toString());
                i.putExtra("batch",batch01.getText().toString());
                i.putExtra("name",MentorName.getText().toString());
                startActivity(i);
            }
        });
        batch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentorBatchOne.class);
                i.putExtra("branch",branch2.getText().toString());
                i.putExtra("year",year2.getText().toString());
                i.putExtra("division",division2.getText().toString());
                i.putExtra("batch",batch02.getText().toString());
                i.putExtra("name",MentorName.getText().toString());
                startActivity(i);
            }
        });
        batch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentorBatchOne.class);
                i.putExtra("branch",branch3.getText().toString());
                i.putExtra("year",year3.getText().toString());
                i.putExtra("division",division3.getText().toString());
                i.putExtra("batch",batch03.getText().toString());
                i.putExtra("name",MentorName.getText().toString());
                startActivity(i);
            }
        });
        batch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentorBatchOne.class);
                i.putExtra("branch",branch4.getText().toString());
                i.putExtra("year",year4.getText().toString());
                i.putExtra("division",division4.getText().toString());
                i.putExtra("batch",batch04.getText().toString());
                i.putExtra("name",MentorName.getText().toString());
                startActivity(i);
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