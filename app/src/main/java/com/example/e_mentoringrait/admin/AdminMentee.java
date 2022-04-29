package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.Integer;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.AttendenceAdapter;
import com.example.e_mentoringrait.adapter.ChatAdapter;
import com.example.e_mentoringrait.adapter.EventAdapter;
import com.example.e_mentoringrait.adapter.FeesAdapter;
import com.example.e_mentoringrait.adapter.PlacementAdapter;
import com.example.e_mentoringrait.adapter.SemAdapter;
import com.example.e_mentoringrait.model.DataAttendence;
import com.example.e_mentoringrait.model.DataChat;
import com.example.e_mentoringrait.model.DataEvent;
import com.example.e_mentoringrait.model.DataFees;
import com.example.e_mentoringrait.model.DataPlacement;
import com.example.e_mentoringrait.model.DataSemSubject;
import com.example.e_mentoringrait.model.DataSemSubjectName;
import com.example.e_mentoringrait.model.DataSemUt1;
import com.example.e_mentoringrait.model.DataSemUt2;
import com.example.e_mentoringrait.model.DataSemfl;
import com.example.e_mentoringrait.model.DataTest;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdminMentee extends AppCompatActivity {
    TextView textView,afullname,amobileno,aemail,abranch,arollno,areligion,acaste;
    RecyclerView rvSem,rvAttend,rvFees,rvEvent,rvPlace;
    SemAdapter semAdapter;
    AttendenceAdapter attendenceAdapter;
    FeesAdapter feesAdapter;
    EventAdapter eventAdapter;
    PlacementAdapter placementAdapter;
    String castes[] = {"OPEN","OBC","SC","ST"};
    String Scholarship[] = {"Applied","Approve","Not Eligible"};
  /*  TextView sem1ut1,sem1ut2,semfl,
            sb1ut1,sb1ut2,sb1fl,
            sb2ut1,sb2ut2,sb2fl,
            sb3ut1,sb3ut2,sb3fl,
            sb4ut1,sb4ut2,sb4fl,
            sb5ut1,sb5ut2,sb5fl
            ,sb6ut1,sb6ut2,sb6fl;*/

    AlertDialog dialog,dialog1,dialog2,dialog4sem,dialogfees,dialogattend;
    ImageButton back,addevent,addPlacement,addsem,addfees,addattendence;
    LineChart lineChart;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDatabase.getReference();
    private DatabaseReference mSem,mAttend,mFees,mEvent,mPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mentee);
        addPlacement = findViewById(R.id.addplacement);
        rvSem = findViewById(R.id.rvSem);
        rvAttend = findViewById(R.id.rvattendencead);
        rvFees = findViewById(R.id.rvFeesad);
        rvEvent = findViewById(R.id.rvextracirculamad);
        rvPlace = findViewById(R.id.rvplacementad);
        getSupportActionBar().setTitle("Admin Student Detail");
        rvSem.setLayoutManager(new LinearLayoutManager(this));
        rvAttend.setLayoutManager(new LinearLayoutManager(this));
        rvFees.setLayoutManager(new LinearLayoutManager(this));
        rvEvent.setLayoutManager(new LinearLayoutManager(this));
        rvPlace.setLayoutManager(new LinearLayoutManager(this));
        addevent = findViewById(R.id.addevnt);
        addsem = findViewById(R.id.addsem);
        addfees = findViewById(R.id.addfees);
        addattendence = findViewById(R.id.addAttendence);
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
     /*   sem1ut1 = findViewById(R.id.sm1ut1);
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

*/
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

        mSem = FirebaseDatabase.getInstance().getReference().child("Grades").child(branch).child(accadmicyear).child(div).child(batch).child(uid);
        FirebaseRecyclerOptions<DataSemSubject> options =
                new FirebaseRecyclerOptions.Builder<DataSemSubject>()
                        .setQuery(mSem, DataSemSubject.class)
                        .build();
        semAdapter = new SemAdapter(options);
        rvSem.setAdapter(semAdapter);

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

        //AlerDialog box Sem
        AlertDialog.Builder builderSem = new AlertDialog.Builder(this);
        builderSem.setTitle("Enter the Details");
        View view4 = getLayoutInflater().inflate(R.layout.alertsemitem,null);
        EditText SemName,
                SN1, SN2,SN3,SN4, SN5, SN6,
                Sb1ut1 , Sb2ut1, Sb3ut1, Sb4ut1,Sb5ut1,Sb6ut1,
                Sb1ut2, Sb2ut2,Sb3ut2,Sb4ut2, Sb5ut2,Sb6ut2,
                Sb1fl, Sb2fl, Sb3fl, Sb4fl,Sb5fl,Sb6fl;

        SN1 = view4.findViewById(R.id.sN1sm);
        SN2 = view4.findViewById(R.id.sN2sm);
        SN3 = view4.findViewById(R.id.sN3sm);
        SN4 = view4.findViewById(R.id.sN4sm);
        SN5 = view4.findViewById(R.id.sN5sm);
        SN6 = view4.findViewById(R.id.sN6sm);

        Sb1ut1 = view4.findViewById(R.id.sb1ut1sm);
        Sb2ut1 = view4.findViewById(R.id.sb2ut1sm);
        Sb3ut1 = view4.findViewById(R.id.sb3ut1sm);
        Sb4ut1 = view4.findViewById(R.id.sb4ut1sm);
        Sb5ut1 = view4.findViewById(R.id.sb5ut1sm);
        Sb6ut1 = view4.findViewById(R.id.sb6ut1sm);

        Sb1ut2 = view4.findViewById(R.id.sb1ut2sm);
        Sb2ut2 = view4.findViewById(R.id.sb2ut2sm);
        Sb3ut2 = view4.findViewById(R.id.sb3ut2sm);
        Sb4ut2 = view4.findViewById(R.id.sb4ut2sm);
        Sb5ut2 = view4.findViewById(R.id.sb5ut2sm);
        Sb6ut2 = view4.findViewById(R.id.sb6ut2sm);

        Sb1fl = view4.findViewById(R.id.sb1flsm);
        Sb2fl = view4.findViewById(R.id.sb2flsm);
        Sb3fl = view4.findViewById(R.id.sb3flsm);
        Sb4fl = view4.findViewById(R.id.sb4flsm);
        Sb5fl = view4.findViewById(R.id.sb5flsm);
        Sb6fl = view4.findViewById(R.id.sb6flsm);

        SemName = view4.findViewById(R.id.semNamesm);
        Button semsubmit = view4.findViewById(R.id.btn_semsubmitsm);
        semsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sN1 = SN1.getText().toString();
                String sN2 = SN2.getText().toString();
                String sN3 = SN3.getText().toString();
                String sN4 = SN4.getText().toString();
                String sN5 = SN5.getText().toString();
                String sN6 = SN6.getText().toString();

                String sb1ut1 = Sb1ut1.getText().toString();
                String sb2ut1 = Sb2ut1.getText().toString();
                String sb3ut1 = Sb3ut1.getText().toString();
                String sb4ut1 = Sb4ut1.getText().toString();
                String sb5ut1 = Sb5ut1.getText().toString();
                String sb6ut1 = Sb6ut1.getText().toString();

                String sb1ut2 = Sb1ut2.getText().toString();
                String sb2ut2 = Sb2ut2.getText().toString();
                String sb3ut2 = Sb3ut2.getText().toString();
                String sb4ut2 = Sb4ut2.getText().toString();
                String sb5ut2 = Sb5ut2.getText().toString();
                String sb6ut2 = Sb6ut2.getText().toString();

                String sb1fl = Sb1fl.getText().toString();
                String sb2fl = Sb2fl.getText().toString();
                String sb3fl = Sb3fl.getText().toString();
                String sb4fl = Sb4fl.getText().toString();
                String sb5fl = Sb5fl.getText().toString();
                String sb6fl = Sb6fl.getText().toString();

                String semNames = SemName.getText().toString();

                if (!TextUtils.isEmpty(semNames)) {
                   DataSemSubject dataSemSubject = new DataSemSubject(semNames,sN1,sN2,sN3,sN4,sN5,sN6,sb1ut1,sb2ut1,sb3ut1,sb4ut1,sb5ut1,sb6ut1,sb1ut2,sb2ut2,sb3ut2,sb4ut2,sb5ut2,sb6ut2,sb1fl,sb2fl,sb3fl,sb4fl,sb5fl,sb6fl);
                    mRef.child("Grades").child(branch).child(accadmicyear).child(div).child(batch).child(uid).child(semNames).setValue(dataSemSubject);
                }
                dialog4sem.dismiss();
            }
        });
        builderSem.setView(view4);
        dialog4sem = builderSem.create();
        addsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4sem.show();
            }
        });


        //AlertDialog Box Fees
        AlertDialog.Builder builderFees = new AlertDialog.Builder(this);
        builderFees.setTitle("Enter the Fees Detail");
        View viewfees = getLayoutInflater().inflate(R.layout.alertfeesitem,null);
        EditText alertToatalfees,alertPaidfees,alertScholarshipfees,alertCategoryfees;
        alertToatalfees = viewfees.findViewById(R.id.alertToatalfees);
        alertPaidfees = viewfees.findViewById(R.id.alertPaidfees);
        alertScholarshipfees = viewfees.findViewById(R.id.alertScholarshipfees);
        alertCategoryfees = viewfees.findViewById(R.id.alertCategoryfees);
        Button submitfees = viewfees.findViewById(R.id.btnsubmitfees);
        submitfees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1= alertToatalfees.getText().toString();
                String value2= alertPaidfees.getText().toString();
                int Toatalfees = Integer.parseInt(String.valueOf(value1));
                int Paidfees = Integer.parseInt(String.valueOf(value2));
                String Scholarshipfees = alertScholarshipfees.getText().toString();
                String Categoryfees = alertCategoryfees.getText().toString();

                int balanceint = Toatalfees - Paidfees;
                String key = mRef.push().getKey();
                DataFees dataFees = new DataFees(Toatalfees,Paidfees,balanceint,Scholarshipfees,Categoryfees);
                mRef.child("Fees").child(branch).child(accadmicyear).child(div).child(batch).child(uid).child(key).setValue(dataFees);
                dialogfees.dismiss();
            }
        });
        builderFees.setView(viewfees);
        dialogfees = builderFees.create();
        addfees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogfees.show();
            }
        });



        //AlertDialog Box Extra Circular Activity
        AlertDialog.Builder builderEvent = new AlertDialog.Builder(this);
        builderEvent.setTitle("Enter the Event Detail");
        View view1 = getLayoutInflater().inflate(R.layout.addevent,null);
        EditText eventName,eventTypes,eventOrganizer,eventDiscription,eventDate;
        eventName = view1.findViewById(R.id.eventNameadd);
        eventTypes = view1.findViewById(R.id.eventTypesadd);
        eventOrganizer = view1.findViewById(R.id.eventOrganizeradd);
        eventDiscription = view1.findViewById(R.id.eventDiscriptionadd);
        eventDate = view1.findViewById(R.id.eventdateadd);
        Button submit1 = view1.findViewById(R.id.btnAddEvent);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventNames = eventName.getText().toString();
                String eventTypess = eventTypes.getText().toString();
                String eventOrganizers = eventOrganizer.getText().toString();
                String eventDiscriptions = eventDiscription.getText().toString();
                String eventDates = eventDate.getText().toString();
                String key = mRef.push().getKey();
                DataEvent dataEvent = new DataEvent(eventNames,eventOrganizers,eventTypess,eventDiscriptions,eventDates);
                mRef.child("Event").child(branch).child(accadmicyear).child(div).child(batch).child(uid).child(key).setValue(dataEvent);
                Toast.makeText(getApplicationContext(),"Add the Data Successfully",Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
            }
        });
        builderEvent.setView(view1);
        dialog1 = builderEvent.create();
        addevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.show();
            }
        });


        //AlertDialog Box For Placement
        AlertDialog.Builder builderPlacement = new AlertDialog.Builder(this);
        builderPlacement.setTitle("Enter the Company Detail");
        View view2 = getLayoutInflater().inflate(R.layout.alertplacementitem,null);
        EditText companyNameAlert,companyPositionAlert,companyLoacationAlert,companyPackageAlert;
        companyNameAlert = view2.findViewById(R.id.companyNameAlert);
        companyPositionAlert = view2.findViewById(R.id.companyPositionAlert);
        companyLoacationAlert = view2.findViewById(R.id.companyLoacationAlert);
        companyPackageAlert = view2.findViewById(R.id.companyPackageAlert);
        Button submit2 = view2.findViewById(R.id.btnplacementalert);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyNameAlerts = companyNameAlert.getText().toString();
                String companyPositionAlerts = companyPositionAlert.getText().toString();
                String companyLoacationAlerts = companyLoacationAlert.getText().toString();
                String companyPackageAlerts = companyPackageAlert.getText().toString();
                String key = mRef.push().getKey();

                DataPlacement dataPlacement = new DataPlacement(companyNameAlerts,companyPositionAlerts,companyLoacationAlerts,companyPackageAlerts);
                mRef.child("Placement").child(branch).child(accadmicyear).child(div).child(batch).child(uid).child(key).setValue(dataPlacement);
                Toast.makeText(getApplicationContext(),"Add the Data Successfully",Toast.LENGTH_SHORT).show();
                dialog2.dismiss();
            }
        });
        builderPlacement.setView(view2);
        dialog2 = builderPlacement.create();
        addPlacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });

/*

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
   */

    //AlertDialog Box For Attendence
    AlertDialog.Builder builderattend = new AlertDialog.Builder(this);
    builderattend.setTitle("Enter the Lecture Details");
    View viewattend = getLayoutInflater().inflate(R.layout.alertattendenceitem,null);
    EditText SubName,totalclass,prasentclass;
    SubName = viewattend.findViewById(R.id.alertSubjectName);
    totalclass = viewattend.findViewById(R.id.alertTotalClass);
    prasentclass = viewattend.findViewById(R.id.alertPrasentClass);
    Button attendsubmit = viewattend.findViewById(R.id.btnsubmitattendence);
    attendsubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String SubNameatt = SubName.getText().toString();
            String value4 = totalclass.getText().toString();
            String value6 = prasentclass.getText().toString();
            int totalclassatt = Integer.parseInt(String.valueOf(value4));

            int prasentclassatt = Integer.parseInt(String.valueOf(value6));
            int absent = totalclassatt - prasentclassatt;
            float a = totalclassatt;
            float b = prasentclassatt;
            float percent = b/a * 100;

            String key = mRef.push().getKey();
            DataAttendence dataAttendence = new DataAttendence(SubNameatt,percent,totalclassatt,prasentclassatt,absent);
            mRef.child("Attendence").child(branch).child(accadmicyear).child(div).child(batch).child(uid).child(SubNameatt).setValue(dataAttendence);
            dialogattend.dismiss();
        }
    });

    builderattend.setView(viewattend);
    dialogattend = builderattend.create();
    addattendence.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogattend.show();
        }
    });



    }

    @Override
    protected void onStart() {
        super.onStart();
        semAdapter.startListening();
        attendenceAdapter.startListening();
        feesAdapter.startListening();
        eventAdapter.startListening();
        placementAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        semAdapter.stopListening();
        attendenceAdapter.stopListening();
        feesAdapter.stopListening();
        eventAdapter.stopListening();
        placementAdapter.stopListening();
    }
}