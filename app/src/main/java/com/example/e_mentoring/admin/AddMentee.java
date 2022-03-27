package com.example.e_mentoring.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_mentoring.R;
import com.example.e_mentoring.model.DataMentee;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class AddMentee extends AppCompatActivity {
    TextInputEditText rollNo, fullName, motherName,email,password,  address,  religion, caste, ssc, hsc, fee, admissionType,year,branch,division,  batch,  serialno;
    Button btn_add_mentee;
    //firebase
    FirebaseAuth auth;
    private DatabaseReference mAddmentee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentee);

        auth = FirebaseAuth.getInstance();
        FirebaseUser mUser = auth.getCurrentUser();
        String uid = mUser.getUid();


        mAddmentee = FirebaseDatabase.getInstance().getReference();

        InsertMentee();

    }
    public void InsertMentee(){

        serialno = findViewById(R.id.serialno);
        rollNo = findViewById(R.id.rollno);
        fullName = findViewById(R.id.fullname);
        motherName = findViewById(R.id.mothername);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        religion = findViewById(R.id.religion);
        caste = findViewById(R.id.caste);
        ssc = findViewById(R.id.ssc);
        hsc = findViewById(R.id.hsc);
        fee = findViewById(R.id.fee);
        admissionType = findViewById(R.id.admissiontype);
        year = findViewById(R.id.year);
        branch = findViewById(R.id.branch);
        division = findViewById(R.id.division);
        batch = findViewById(R.id.batch);

        btn_add_mentee = findViewById(R.id.btn_add_mentee);
        btn_add_mentee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mentee_serialno = serialno.getText().toString().trim();
                String mentee_rollNo = rollNo.getText().toString().trim();
                String mentee_fullName = fullName.getText().toString().trim();
                String mentee_motherName = motherName.getText().toString().trim();
                String mentee_email = email.getText().toString().trim();
                String mentee_password = password.getText().toString().trim();
                String mentee_address = address.getText().toString().trim();
                String mentee_religion = religion.getText().toString().trim();
                String mentee_caste = caste.getText().toString().trim();
                String mentee_ssc = ssc.getText().toString().trim();

                String mentee_hsc = hsc.getText().toString().trim();
                String mentee_fee = fee.getText().toString().trim();
                String mentee_admissionType = admissionType.getText().toString().trim();
                String mentee_year = year.getText().toString().trim();
                String mentee_branch = branch.getText().toString().trim();
                String mentee_division = division.getText().toString().trim();
                String mentee_batch = batch.getText().toString().trim();


                auth.createUserWithEmailAndPassword(mentee_email,mentee_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {


                        DataMentee dataMentee = new DataMentee(mentee_serialno,mentee_rollNo,mentee_fullName,mentee_email,mentee_password,mentee_motherName,
                                mentee_address,mentee_religion,mentee_caste,mentee_ssc,mentee_hsc,
                                mentee_fee,mentee_admissionType,mentee_year,mentee_branch,mentee_division,mentee_batch);


                        mAddmentee.child(mentee_branch).child(mentee_year).child(mentee_division).child(mentee_batch).child(mentee_rollNo).setValue(dataMentee);
                        Toast.makeText(AddMentee.this,"Add mentee successfully",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),AdminDashboard.class));
                        finish();



                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddMentee.this,e.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });


            }





        });

    }
}