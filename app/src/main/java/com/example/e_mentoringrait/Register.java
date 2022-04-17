package com.example.e_mentoringrait;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_mentoringrait.admin.AdminDashboard;
import com.example.e_mentoringrait.model.DataMentee;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText rollNo, fullName, email,password,motherName,  address, studentNumber,parentNumber,admissionYear, ssc, hsc, paidFee;
    Button btn_add_mentee;
    String branches[] = {"CS","IT","EXT","EE","IE"};
    String AccadmicYear[] = {"FE","SE","TE","BE"};
    String divisiones[] = {"A","B","C"};
    String batches[] = {"1","2","3","4"};
    String religions[] = {"Buddhist","Cristen","Hindu","Jain","Muslim","Sikh","Other"};
    String castes[] = {"OPEN","OBC","SC","ST"};
    String admissiontypes[] = {"CAP1","CAP2","CAP3","MANAGEMENT KOTA"};
    //firebase
    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDatabase.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

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


        ArrayAdapter<String> religionAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                religions
        );
        AutoCompleteTextView religions = findViewById(R.id.spnReligion);
        religions.setAdapter(religionAdapter);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                castes
        );
        AutoCompleteTextView caste = findViewById(R.id.spnCaste);
        caste.setAdapter(adapter);


        ArrayAdapter<String> admissiontypeAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                admissiontypes
        );
        AutoCompleteTextView admissiontype = findViewById(R.id.spnAdmissionType);
        admissiontype.setAdapter(admissiontypeAdapter);










        rollNo = findViewById(R.id.RollNo);
        fullName = findViewById(R.id.FullName);
        motherName = findViewById(R.id.MotherName);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        address = findViewById(R.id.Address);
        ssc = findViewById(R.id.Ssc);
        hsc = findViewById(R.id.Hsc);
        paidFee = findViewById(R.id.PaidFee);
        studentNumber = findViewById(R.id.StudentNumber);
        parentNumber = findViewById(R.id.ParentNumber);
        admissionYear = findViewById(R.id.AdmissionYear);

        btn_add_mentee = findViewById(R.id.btn_add_mentee);
        btn_add_mentee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String mentee_rollNo = rollNo.getText().toString().trim();
                String mentee_fullName = fullName.getText().toString().trim();
                String mentee_motherName = motherName.getText().toString().trim();
                String mentee_email = email.getText().toString().trim();
                String mentee_password = password.getText().toString().trim();
                String mentee_address = address.getText().toString().trim();
                String mentee_ssc = ssc.getText().toString().trim();
                String mentee_hsc = hsc.getText().toString().trim();
                String mentee_fee = paidFee.getText().toString().trim();
                String mentee_studentNumber = studentNumber.getText().toString().trim();
                String mentee_parentNumber = parentNumber.getText().toString().trim();
                String mentee_admissionYear = admissionYear.getText().toString().trim();




                String mentee_admissionType = admissiontype.getText().toString().trim();
                String mentee_year = accadmicYears.getText().toString().trim();
                String mentee_branch = branchs.getText().toString().trim();
                String mentee_division = divisions.getText().toString().trim();
                String mentee_batch = batches.getText().toString().trim();
                String mentee_caste = caste.getText().toString();
                String mentee_religions = religions.getText().toString();


                if (TextUtils.isEmpty(mentee_branch)){
                    branchs.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_year)){
                    accadmicYears.setError("select the accadmic Years");
                    return;
                }

                if (TextUtils.isEmpty(mentee_division)){
                    divisions.setError("select the divisions");
                    return;
                }

                if (TextUtils.isEmpty(mentee_batch)){
                    batches.setError("select the batch");
                    return;
                }




                if (TextUtils.isEmpty(mentee_fullName)){
                    fullName.setError("mentee_fullName  is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_rollNo)){
                    rollNo.setError("mentee_rollNo  is required");
                    return;
                }

                if (TextUtils.isEmpty(mentee_email)){
                    email.setError("mentee_email  is required");
                    return;
                }

                if (TextUtils.isEmpty(mentee_password)){
                    password.setError("mentee_password  is required");
                    return;
                }


                if (TextUtils.isEmpty(mentee_motherName)){
                    motherName.setError("mentee_motherName is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_address)){
                    address.setError("mentee_address  is required");
                    return;
                }

                if (TextUtils.isEmpty(mentee_studentNumber)){
                    studentNumber.setError("mentee_studentNumber  is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_parentNumber)){
                    parentNumber.setError("mentee_parentNumber  is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_admissionYear)){
                    admissionYear.setError("mentee_admissionYear is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_ssc)){
                    ssc.setError("mentee_ssc  is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_hsc)){
                    hsc.setError("mentee_hsc  is required");
                    return;
                }
                if (TextUtils.isEmpty(mentee_fee)){
                    paidFee.setError("mentee_fee  is required");
                    return;
                }

                if (TextUtils.isEmpty(mentee_religions)){
                    religions.setError("select the religions");
                    return;
                }

                if (TextUtils.isEmpty(mentee_caste)){
                    caste.setError("select the caste");
                    return;
                }

                if (TextUtils.isEmpty(mentee_admissionType)){
                    admissiontype.setError("select the admissiontype");
                    return;
                }


                mAuth.createUserWithEmailAndPassword(mentee_email,mentee_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        String id = authResult.getUser().getUid();
                        int userTypes = 0;

                        DataMentee dataMentee = new DataMentee(id,0,mentee_branch,mentee_year,
                                mentee_division, mentee_batch,
                                mentee_rollNo,mentee_fullName,mentee_email,
                                mentee_password,mentee_motherName,mentee_address,mentee_studentNumber,mentee_parentNumber,mentee_admissionYear,
                                mentee_ssc,mentee_hsc,mentee_fee,mentee_religions,mentee_caste,mentee_admissionType);
                        DataMentee dataMentee1 = new DataMentee(id,0,mentee_branch,mentee_year,
                                mentee_division, mentee_batch,
                                mentee_rollNo,mentee_fullName,mentee_email);

                        mRef.child("User").child(id).setValue(dataMentee1);
                        mRef.child(mentee_branch).child(mentee_year).child(mentee_division).child(mentee_batch).child(id).setValue(dataMentee);


                       Toast.makeText(getApplicationContext(),"Add Mentee Successfully",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), AdminDashboard.class));
                        finish();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }

    public void Register(View view) {
    }
}