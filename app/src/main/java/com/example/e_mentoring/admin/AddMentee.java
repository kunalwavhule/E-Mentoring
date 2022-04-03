package com.example.e_mentoring.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
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
    TextInputEditText rollNo, fullName, motherName,email,password,  address,  religion, ssc, hsc, fee, admissionType,year,branch,division,  batch,  serialno;
    Button btn_add_mentee;
    String castes[] = {"OPEN","OBC","SC","ST"};
    String religions[] = {"Buddhist","Cristen","Hindu","Jain","Muslim","Sikh","Other"};
    String clases[] = {"FE","SE","TE","BE"};
    String branches[] = {"CS","IT","EXT","EE","IE"};
    String divisiones[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
    String batches[] = {"1","2","3","4"};
    String admissiontypes[] = {"CAP1","CAP2","CAP3","MANAGEMENT KOTA"};
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
        //dropdown menu for case
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                castes
        );
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.fill_exposed);
        autoCompleteTextView.setAdapter(adapter);

        //dropdown menu for batch
        ArrayAdapter<String> batchAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                batches
        );
        AutoCompleteTextView batches = findViewById(R.id.spnbatch);
        batches.setAdapter(batchAdapter);

        //dropdown menu for admissiontypes
        ArrayAdapter<String> admissiontypeAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                admissiontypes
        );
        AutoCompleteTextView admissiontype = findViewById(R.id.spnadmisiontype);
        admissiontype.setAdapter(admissiontypeAdapter);


        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                clases
        );
        AutoCompleteTextView years = findViewById(R.id.spnyear);
        years.setAdapter(yearAdapter);


        ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                branches
        );
        AutoCompleteTextView branchs = findViewById(R.id.spnbranch);
        branchs.setAdapter(branchAdapter);


        ArrayAdapter<String> divisionAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                divisiones
        );
        AutoCompleteTextView divisions = findViewById(R.id.spndivision);
        divisions.setAdapter(divisionAdapter);

        ArrayAdapter<String> religionAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                religions
        );
        AutoCompleteTextView religions = findViewById(R.id.spnreligion);
        religions.setAdapter(religionAdapter);



        serialno = findViewById(R.id.serialno);
        rollNo = findViewById(R.id.rollno);
        fullName = findViewById(R.id.fullname);
        motherName = findViewById(R.id.mothername);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        ssc = findViewById(R.id.ssc);
        hsc = findViewById(R.id.hsc);
        fee = findViewById(R.id.fee);

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
                String mentee_religion = religions.getText().toString().trim();
                String mentee_ssc = ssc.getText().toString().trim();

                String mentee_hsc = hsc.getText().toString().trim();
                String mentee_fee = fee.getText().toString().trim();
                String mentee_admissionType = admissiontype.getText().toString().trim();
                String mentee_year = years.getText().toString().trim();
                String mentee_branch = branchs.getText().toString().trim();
                String mentee_division = divisions.getText().toString().trim();
                String mentee_batch = batches.getText().toString().trim();
                String mentee_caste = autoCompleteTextView.getText().toString();




                auth.createUserWithEmailAndPassword(mentee_email,mentee_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {


                        DataMentee dataMentee = new DataMentee(mentee_serialno,mentee_rollNo,mentee_fullName,mentee_email,mentee_password,mentee_motherName,
                                mentee_address,mentee_religion, mentee_caste,mentee_ssc,mentee_hsc,
                                mentee_fee,mentee_admissionType,mentee_year,mentee_branch,mentee_division,mentee_division+mentee_batch);



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
    public void InsertMentee(){
    }
}