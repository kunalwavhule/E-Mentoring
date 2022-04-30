package com.example.e_mentoringrait.mentor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.AttendenceAdapter;
import com.example.e_mentoringrait.adapter.EventAdapter;
import com.example.e_mentoringrait.adapter.FeesAdapter;
import com.example.e_mentoringrait.adapter.PlacementAdapter;
import com.example.e_mentoringrait.adapter.SemAdapter;
import com.example.e_mentoringrait.admin.AdminBatch;
import com.example.e_mentoringrait.admin.AdminYear;
import com.example.e_mentoringrait.mentee.MenteeChat;
import com.example.e_mentoringrait.model.DataAttendence;
import com.example.e_mentoringrait.model.DataEvent;
import com.example.e_mentoringrait.model.DataFees;
import com.example.e_mentoringrait.model.DataPlacement;
import com.example.e_mentoringrait.model.DataSemSubject;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MentorMentee extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    TextView textView,afullname,amobileno,aemail,abranch,arollno,areligion,acaste;

    TextView sem1ut1,sem1ut2,semfl,
            sb1ut1,sb1ut2,sb1fl,
            sb2ut1,sb2ut2,sb2fl,
            sb3ut1,sb3ut2,sb3fl,
            sb4ut1,sb4ut2,sb4fl,
            sb5ut1,sb5ut2,sb5fl
            ,sb6ut1,sb6ut2,sb6fl;

    AlertDialog dialog;
    ImageButton back;
    LineChart lineChart;
    RecyclerView rvSem,rvAttend,rvFees,rvEvent,rvPlace;

    AttendenceAdapter attendenceAdapter;
    SemAdapter semAdapter;
    FeesAdapter feesAdapter;
    EventAdapter eventAdapter;
    PlacementAdapter placementAdapter;


    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDatabase.getReference();
    private DatabaseReference mSem,mAttend,mFees,mEvent,mPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_mentee);
        getSupportActionBar().setTitle("Mentor Mentee");

        floatingActionButton = findViewById(R.id.chatmentor);
        rvAttend = findViewById(R.id.rvmmattend);
        rvFees = findViewById(R.id.rvmmfees);
        rvEvent = findViewById(R.id.rvmmextrac);
        rvPlace = findViewById(R.id.rvmmplacement);
        rvSem = findViewById(R.id.rvmmsem);

        rvAttend.setLayoutManager(new LinearLayoutManager(this));
        rvFees.setLayoutManager(new LinearLayoutManager(this));
        rvEvent.setLayoutManager(new LinearLayoutManager(this));
        rvPlace.setLayoutManager(new LinearLayoutManager(this));
        rvSem.setLayoutManager(new LinearLayoutManager(this));

        textView = findViewById(R.id.t1);
        afullname = findViewById(R.id.FullNameam);
        amobileno = findViewById(R.id.StudentNumberam);
        aemail = findViewById(R.id.Emailam);
        abranch = findViewById(R.id.Brancham);
        arollno = findViewById(R.id.RollNoam);
        areligion = findViewById(R.id.spnReligionam);
        acaste = findViewById(R.id.spnCasteam);
        back = findViewById(R.id.back);

        //sem 1 subject reference
        sem1ut1 = findViewById(R.id.sm1ut1);
        sem1ut2 = findViewById(R.id.sem1ut2);
        semfl = findViewById(R.id.sem1fl);

        sb1ut1 = findViewById(R.id.sb1ut1);
        sb1ut2 = findViewById(R.id.sb1ut2);
        sb1fl = findViewById(R.id.sb1fl);

        sb2ut1 = findViewById(R.id.sb2ut1);
        sb2ut2 = findViewById(R.id.sb2ut2);
        sb2fl = findViewById(R.id.sb2fl);

        sb3ut1 = findViewById(R.id.sb3ut1);
        sb3ut2 = findViewById(R.id.sb3ut2);
        sb3fl = findViewById(R.id.sb3fl);

        sb4ut1 = findViewById(R.id.sb4ut1);
        sb4ut2 = findViewById(R.id.sb4ut2);
        sb4fl = findViewById(R.id.sb4fl);

        sb5ut1 = findViewById(R.id.sb5ut1);
        sb5ut2 = findViewById(R.id.sb5ut2);
        sb5fl = findViewById(R.id.sb5fl);

        sb6ut1 = findViewById(R.id.sb6ut1);
        sb6ut2 = findViewById(R.id.sb6ut2);
        sb6fl = findViewById(R.id.sb6fl);


        String fullname = getIntent().getStringExtra("fullname");
        String mobileno = getIntent().getStringExtra("mobileno");
        String email = getIntent().getStringExtra("fullname");
        String branch = getIntent().getStringExtra("branch");
        String rollno = getIntent().getStringExtra("rollno");
        String religion = getIntent().getStringExtra("religion");
        String caste = getIntent().getStringExtra("caste");
        String accadmicyear = getIntent().getStringExtra("accadmicyear");
        String div = getIntent().getStringExtra("division");
        String batch = getIntent().getStringExtra("batch");
        String uid = getIntent().getStringExtra("uid");


        mAttend = FirebaseDatabase.getInstance().getReference().child("Attendence").child(branch).child(accadmicyear).child(div).child(batch).child(uid);

        FirebaseRecyclerOptions<DataAttendence> optionsattend =
                new FirebaseRecyclerOptions.Builder<DataAttendence>()
                        .setQuery(mAttend, DataAttendence.class)
                        .build();
        attendenceAdapter = new AttendenceAdapter(optionsattend);
        rvAttend.setAdapter(attendenceAdapter);


        mFees = FirebaseDatabase.getInstance().getReference().child("Fees").child(branch).child(accadmicyear).child(div).child(batch).child(uid);

        FirebaseRecyclerOptions<DataFees> optionsfees =
                new FirebaseRecyclerOptions.Builder<DataFees>()
                        .setQuery(mFees, DataFees.class)
                        .build();
        feesAdapter = new FeesAdapter(optionsfees);
        rvFees.setAdapter(feesAdapter);

        mEvent = FirebaseDatabase.getInstance().getReference().child("Event").child(branch).child(accadmicyear).child(div).child(batch).child(uid);

        FirebaseRecyclerOptions<DataEvent> optionsevent =
                new FirebaseRecyclerOptions.Builder<DataEvent>()
                        .setQuery(mEvent, DataEvent.class)
                        .build();
        eventAdapter = new EventAdapter(optionsevent);
        rvEvent.setAdapter(eventAdapter);

        mPlace = FirebaseDatabase.getInstance().getReference().child("Placement").child(branch).child(accadmicyear).child(div).child(batch).child(uid);

        FirebaseRecyclerOptions<DataPlacement> optionsplace =
                new FirebaseRecyclerOptions.Builder<DataPlacement>()
                        .setQuery(mPlace, DataPlacement.class)
                        .build();
        placementAdapter = new PlacementAdapter(optionsplace);
        rvPlace.setAdapter(placementAdapter);

        mSem = FirebaseDatabase.getInstance().getReference().child("Grades").child(branch).child(accadmicyear).child(div).child(batch).child(uid);
        FirebaseRecyclerOptions<DataSemSubject> options =
                new FirebaseRecyclerOptions.Builder<DataSemSubject>()
                        .setQuery(mSem, DataSemSubject.class)
                        .build();
        semAdapter = new SemAdapter(options);
        rvSem.setAdapter(semAdapter);




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentorChat.class);
                i.putExtra("branch",branch);
                i.putExtra("accadmicyear",accadmicyear);
                i.putExtra("div",div);
                i.putExtra("batch",batch);
                i.putExtra("mentorUid", FirebaseAuth.getInstance().getUid());
                i.putExtra("menteeUid",uid);
                startActivity(i);

            }
        });
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
                Intent iy = new Intent(getApplicationContext(), MentorBatchOne.class);

                Intent i = new Intent(getApplicationContext(), MentorBatchOne.class);
                i.putExtra("branch",branch);
                i.putExtra("year",accadmicyear);
                i.putExtra("division",div);
                i.putExtra("batch",batch);
                startActivity(i);

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter the Mark");

        View view = getLayoutInflater().inflate(R.layout.sem1_ut1,null);
        EditText eSub1,eSub2,eSub3,eSub4,eSub5,eSub6;
        eSub1 = view.findViewById(R.id.subName1);
        eSub2 = view.findViewById(R.id.subName2);
        eSub3 = view.findViewById(R.id.subName3);
        eSub4 = view.findViewById(R.id.subName4);
        eSub5 = view.findViewById(R.id.subName5);
        eSub6 = view.findViewById(R.id.subName6);
        Button Submit = view.findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sb1ut1.setText(eSub1.getText().toString());
                sb2ut1.setText(eSub2.getText().toString());
                sb3ut1.setText(eSub3.getText().toString());
                sb4ut1.setText(eSub4.getText().toString());
                sb5ut1.setText(eSub5.getText().toString());
                sb6ut1.setText(eSub6.getText().toString());

                int num1 =  Integer.parseInt(sb1ut1.getText().toString());
                int num2 =  Integer.parseInt(sb2ut1.getText().toString());
                int num3 =  Integer.parseInt(sb3ut1.getText().toString());
                int num4 =  Integer.parseInt(sb4ut1.getText().toString());
                int num5 =  Integer.parseInt(sb5ut1.getText().toString());
                int num6 =  Integer.parseInt(sb6ut1.getText().toString());
                lineChart=(LineChart)findViewById(R.id.linechart);
                ArrayList<Entry> information=new ArrayList<>();
                information.add(new Entry(20,num1));
                information.add(new Entry(40,num2));
                information.add(new Entry(60,num3));
                information.add(new Entry(80,num4));
                information.add(new Entry(100,num5));
                information.add(new Entry(120,num6));
                LineDataSet lineDataSet=new LineDataSet(information,"Information");
                lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                lineDataSet.setValueTextColor(Color.BLACK);
                lineDataSet.setValueTextSize(20f);
                LineData lineData=new LineData(lineDataSet);
                lineChart.setData(lineData);
                lineChart.animateY(2000);
                dialog.dismiss();

            }
        });

        builder.setView(view);

        dialog = builder.create();

        sem1ut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        int num1 =  Integer.parseInt(sb1ut1.getText().toString());
        int num2 =  Integer.parseInt(sb2ut1.getText().toString());
        int num3 =  Integer.parseInt(sb3ut1.getText().toString());
        int num4 =  Integer.parseInt(sb4ut1.getText().toString());
        int num5 =  Integer.parseInt(sb5ut1.getText().toString());
        int num6 =  Integer.parseInt(sb6ut1.getText().toString());
        lineChart=(LineChart)findViewById(R.id.linechart);
        ArrayList<Entry> information=new ArrayList<>();
        information.add(new Entry(20,num1));
        information.add(new Entry(40,num2));
        information.add(new Entry(60,num3));
        information.add(new Entry(80,num4));
        information.add(new Entry(100,num5));
        information.add(new Entry(120,num6));
        LineDataSet lineDataSet=new LineDataSet(information,"Information");
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(20f);
        LineData lineData=new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.animateY(2000);

    }

    @Override
    protected void onStart() {
        super.onStart();
        attendenceAdapter.startListening();
        feesAdapter.startListening();
        eventAdapter.startListening();
        placementAdapter.stopListening();
        semAdapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        attendenceAdapter.stopListening();
        feesAdapter.stopListening();
        eventAdapter.stopListening();
        placementAdapter.stopListening();
        semAdapter.stopListening();

    }
}