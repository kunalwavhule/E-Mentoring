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
import com.example.e_mentoringrait.model.DataMentor;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMentor extends AppCompatActivity {

    EditText Name, Email,Password;
    Button btn_add_mentor;

    String branches[] = {"CS","IT","EXT","EE","IE"};
    String AccadmicYear[] = {"FE","SE","TE","BE"};
    String divisiones[] = {"A","B","C"};
    String batches[] = {"1","2","3","4"};

    private FirebaseAuth mAuth;
// ...
// Initialize Firebase Auth

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDatabase.getReference();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentor);

        Name = findViewById(R.id.MentorName);
        Email = findViewById(R.id.MentorEmail);
        Password = findViewById(R.id.MentorPassword);

        mAuth = FirebaseAuth.getInstance();

        ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                branches
        );
        AutoCompleteTextView branchs = findViewById(R.id.spnBranch);
        branchs.setAdapter(branchAdapter);



        ArrayAdapter<String> yearAdapter1 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                AccadmicYear
        );
        AutoCompleteTextView accadmicYears1 = findViewById(R.id.spnAccadmicYear1);
        accadmicYears1.setAdapter(yearAdapter1);


        ArrayAdapter<String> divisionAdapter1 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                divisiones
        );
        AutoCompleteTextView divisions1 = findViewById(R.id.spnDivision1);
        divisions1.setAdapter(divisionAdapter1);


        ArrayAdapter<String> batchAdapter1 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                batches
        );
        AutoCompleteTextView batches1 = findViewById(R.id.spnBatch1);
        batches1.setAdapter(batchAdapter1);


        ArrayAdapter<String> yearAdapter2 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                AccadmicYear
        );
        AutoCompleteTextView accadmicYears2 = findViewById(R.id.spnAccadmicYear2);
        accadmicYears2.setAdapter(yearAdapter2);


        ArrayAdapter<String> divisionAdapter2 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                divisiones
        );
        AutoCompleteTextView divisions2 = findViewById(R.id.spnDivision2);
        divisions2.setAdapter(divisionAdapter2);


        ArrayAdapter<String> batchAdapter2 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                batches
        );
        AutoCompleteTextView batches2 = findViewById(R.id.spnBatch2);
        batches2.setAdapter(batchAdapter2);








        ArrayAdapter<String> yearAdapter3 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                AccadmicYear
        );
        AutoCompleteTextView accadmicYears3 = findViewById(R.id.spnAccadmicYear3);
        accadmicYears3.setAdapter(yearAdapter3);


        ArrayAdapter<String> divisionAdapter3 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                divisiones
        );
        AutoCompleteTextView divisions3 = findViewById(R.id.spnDivision3);
        divisions3.setAdapter(divisionAdapter3);


        ArrayAdapter<String> batchAdapter3 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                batches
        );
        AutoCompleteTextView batches3 = findViewById(R.id.spnBatch3);
        batches3.setAdapter(batchAdapter3);


        ArrayAdapter<String> yearAdapter4 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                AccadmicYear
        );
        AutoCompleteTextView accadmicYears4 = findViewById(R.id.spnAccadmicYear4);
        accadmicYears4.setAdapter(yearAdapter4);


        ArrayAdapter<String> divisionAdapter4 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                divisiones
        );
        AutoCompleteTextView divisions4 = findViewById(R.id.spnDivision4);
        divisions4.setAdapter(divisionAdapter4);


        ArrayAdapter<String> batchAdapter4 = new ArrayAdapter<>(
                this,
                R.layout.drop_down_item,
                batches
        );
        AutoCompleteTextView batches4 = findViewById(R.id.spnBatch4);
        batches4.setAdapter(batchAdapter4);

        btn_add_mentor = findViewById(R.id.btn_add_mentor);
        btn_add_mentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mentor_Name = Name.getText().toString().trim();
                String mentor_Email = Email.getText().toString().trim();
                String mentor_Password = Password.getText().toString().trim();


                String mentor_branch = branchs.getText().toString().trim();

                String mentee_accadmicYears1 = accadmicYears1.getText().toString().trim();
                String mentee_divisions1 = divisions1.getText().toString().trim();
                String mentee_batches1 = batches1.getText().toString().trim();

                String mentee_accadmicYears2 = accadmicYears2.getText().toString().trim();
                String mentee_divisions2 = divisions2.getText().toString().trim();
                String mentee_batches2 = batches2.getText().toString().trim();

                String mentee_accadmicYears3 = accadmicYears3.getText().toString().trim();
                String mentee_divisions3 = divisions3.getText().toString().trim();
                String mentee_batches3 = batches3.getText().toString().trim();

                String mentee_accadmicYears4 = accadmicYears4.getText().toString().trim();
                String mentee_divisions4 = divisions4.getText().toString().trim();
                String mentee_batches4 = batches4.getText().toString().trim();



                if (TextUtils.isEmpty(mentor_Name)){
                    Name.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentor_Email)){
                    Email.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentor_Password)){
                    Password.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentor_branch)){
                    branchs.setError("select the branch");
                    return;
                }
                 ////
                if (TextUtils.isEmpty(mentee_accadmicYears1)){
                    accadmicYears1.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_divisions1)){
                    divisions1.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_batches1)){
                    batches1.setError("select the branch");
                    return;
                }


                if (TextUtils.isEmpty(mentee_accadmicYears2)){
                    accadmicYears2.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_divisions2)){
                    divisions2.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_batches2)){
                    batches2.setError("select the branch");
                    return;
                }


                if (TextUtils.isEmpty(mentee_accadmicYears3)){
                    accadmicYears3.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_divisions3)){
                    divisions3.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_batches3)){
                    batches3.setError("select the branch");
                    return;
                }


                if (TextUtils.isEmpty(mentee_accadmicYears4)){
                    accadmicYears4.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_divisions4)){
                    divisions4.setError("select the branch");
                    return;
                }

                if (TextUtils.isEmpty(mentee_batches4)){
                    batches4.setError("select the branch");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(mentor_Email,mentor_Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        String id = authResult.getUser().getUid();
                        int UserTypes = 1;

                        DataMentor dataMentor1 = new DataMentor(id,1,mentor_Name,mentor_Email,mentor_branch);
                        DataMentor dataMentor = new DataMentor(id,1,mentor_Name,mentor_Email,mentor_Password,mentor_branch,mentee_accadmicYears1,mentee_divisions1,mentee_batches1,mentee_accadmicYears2,mentee_divisions2,mentee_batches2,mentee_accadmicYears3,mentee_divisions3,mentee_batches3,mentee_accadmicYears4,mentee_divisions4,mentee_batches4);
                        mRef.child("User").child(id).setValue(dataMentor);
                        mRef.child(mentor_branch).child(mentee_accadmicYears1).child(mentee_divisions1).child(mentee_batches1).child("mentor").child(id).setValue(dataMentor1);
                        mRef.child(mentor_branch).child(mentee_accadmicYears2).child(mentee_divisions2).child(mentee_batches2).child("mentor").child(id).setValue(dataMentor1);
                        mRef.child(mentor_branch).child(mentee_accadmicYears3).child(mentee_divisions3).child(mentee_batches3).child("mentor").child(id).setValue(dataMentor1);
                        mRef.child(mentor_branch).child(mentee_accadmicYears4).child(mentee_divisions4).child(mentee_batches4).child("mentor").child(id).setValue(dataMentor1);
                        Toast.makeText(getApplicationContext(),"Add Mentor Successfully",Toast.LENGTH_LONG).show();

                        startActivity(new Intent(getApplicationContext(), AdminDashboard.class));

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
}