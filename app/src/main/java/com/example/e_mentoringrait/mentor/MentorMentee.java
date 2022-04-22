package com.example.e_mentoringrait.mentor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.admin.AdminBatch;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MentorMentee extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_mentee);
        getSupportActionBar().setTitle("Mentor Mentee");

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
}