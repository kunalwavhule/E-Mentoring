package com.example.e_mentoringrait.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataCalender;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminCalendar extends AppCompatActivity {

    String branches[] = {"CS","IT","EXT","EE","IE"};
    String AccadmicYear[] = {"FE","SE","TE","BE"};
    String divisiones[] = {"A","B","C"};
    String batches[] = {"1","2","3","4"};
    String days[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    TextView startTime,endTime,className,classRoom,classType,instructerName;
    Button btn_assign_lecture;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDatabase.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_calendar);
        startTime = findViewById(R.id.startTime);
        endTime = findViewById(R.id.endTime);
        className = findViewById(R.id.className);
        getSupportActionBar().setTitle("Admin TimeTable");
        classRoom = findViewById(R.id.classRoom);
        classType = findViewById(R.id.classType);
        instructerName = findViewById(R.id.instructerName);
        btn_assign_lecture = findViewById(R.id.btn_assign_lecture);
        ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                branches
        );
        AutoCompleteTextView branchs = findViewById(R.id.spnBranch);
        branchs.setAdapter(branchAdapter);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                AccadmicYear
        );
        AutoCompleteTextView accadmicYears = findViewById(R.id.spnAccadmicYear);
        accadmicYears.setAdapter(yearAdapter);


        ArrayAdapter<String> divisionAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                divisiones
        );
        AutoCompleteTextView divisions = findViewById(R.id.spnDivision);
        divisions.setAdapter(divisionAdapter);


        ArrayAdapter<String> batchAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                batches
        );
        AutoCompleteTextView batches = findViewById(R.id.spnBatch);
        batches.setAdapter(batchAdapter);

        ArrayAdapter<String> daysAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                days
        );
        AutoCompleteTextView days = findViewById(R.id.spnDays);
        days.setAdapter(daysAdapter);

        btn_assign_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startTimec = startTime.getText().toString().trim();
                String endTimec = endTime.getText().toString().trim();
                String classNamec = className.getText().toString().trim();
                String classRoomc = classRoom.getText().toString().trim();
                String classTypec = classType.getText().toString().trim();
                String instructerNamec = instructerName.getText().toString().trim();

                String accadmicYearsc = accadmicYears.getText().toString().trim();
                String branchsc = branchs.getText().toString().trim();
                String divisionsc = divisions.getText().toString().trim();
                String batchesc = batches.getText().toString().trim();
                String daysc = days.getText().toString().trim();

                if (TextUtils.isEmpty(startTimec)){
                    startTime.setError("Its Required");
                    return;
                }

                if (TextUtils.isEmpty(endTimec)){
                    endTime.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(classNamec)){
                    className.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(classRoomc)){
                    classRoom.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(classTypec)){
                    classType.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(instructerNamec)){
                    instructerName.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(accadmicYearsc)){
                    accadmicYears.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(branchsc)){
                    branchs.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(divisionsc)){
                    divisions.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(batchesc)){
                    batches.setError("Its Required");
                    return;
                }
                if (TextUtils.isEmpty(daysc)){
                    days.setError("Its Required");
                    return;
                }
                String key = mRef.push().getKey();

                DataCalender dataCalender = new DataCalender(startTimec,endTimec,classNamec,
                        classRoomc,classTypec,instructerNamec);

                mRef.child("Calendar").child(branchsc).child(accadmicYearsc).child(divisionsc).child(batchesc).child(daysc).child(key).setValue(dataCalender);
                Toast.makeText(getApplicationContext(),"Assign Lecture Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), AdminDashboard.class));
                finish();

            }
        });

    }
}