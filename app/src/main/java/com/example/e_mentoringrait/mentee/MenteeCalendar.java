package com.example.e_mentoringrait.mentee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.CalendarAdapter;
import com.example.e_mentoringrait.model.DataCalender;
import com.example.e_mentoringrait.model.DataMentee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;

public class MenteeCalendar extends AppCompatActivity {
    TextView day;
    RecyclerView rvMonday,rvtuesday,rvwed,rvthursday,rvfriday;
    CalendarAdapter calendarAdapter,calendarAdapter2,calendarAdapter3,calendarAdapter4,calendarAdapter5;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mMentor,mMentor2,mMentor3,mMentor4,mMentor5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_calendar);
        rvMonday = findViewById(R.id.rvmonday);
        rvtuesday = findViewById(R.id.rvtuesday);
        rvwed = findViewById(R.id.rvwed);
        rvthursday = findViewById(R.id.rvthursday);
        rvfriday = findViewById(R.id.rvfriday);
        day = findViewById(R.id.cday);

        Intent intent = getIntent();

        String branchs = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");

        rvMonday.setLayoutManager(new LinearLayoutManager(this));

         mMentor = FirebaseDatabase.getInstance().getReference().child("Calendar").child(branchs).child(accadmicYear).child(division).child(batch).child("Monday");
         FirebaseRecyclerOptions<DataCalender> options =
                 new FirebaseRecyclerOptions.Builder<DataCalender>()
                         .setQuery(mMentor, DataCalender.class)
                         .build();
         calendarAdapter = new CalendarAdapter(options);
         rvMonday.setAdapter(calendarAdapter);


        rvtuesday.setLayoutManager(new LinearLayoutManager(this));

        mMentor2 = FirebaseDatabase.getInstance().getReference().child("Calendar").child(branchs).child(accadmicYear).child(division).child(batch).child("Tuesday");
        FirebaseRecyclerOptions<DataCalender> options2 =
                new FirebaseRecyclerOptions.Builder<DataCalender>()
                        .setQuery(mMentor2, DataCalender.class)
                        .build();
        calendarAdapter2 = new CalendarAdapter(options2);
        rvtuesday.setAdapter(calendarAdapter2);


        rvwed.setLayoutManager(new LinearLayoutManager(this));

        mMentor3 = FirebaseDatabase.getInstance().getReference().child("Calendar").child(branchs).child(accadmicYear).child(division).child(batch).child("Wednesday");
        FirebaseRecyclerOptions<DataCalender> options3 =
                new FirebaseRecyclerOptions.Builder<DataCalender>()
                        .setQuery(mMentor3, DataCalender.class)
                        .build();
        calendarAdapter3 = new CalendarAdapter(options3);
        rvwed.setAdapter(calendarAdapter3);


        rvthursday.setLayoutManager(new LinearLayoutManager(this));

        mMentor4 = FirebaseDatabase.getInstance().getReference().child("Calendar").child(branchs).child(accadmicYear).child(division).child(batch).child("Thursday");
        FirebaseRecyclerOptions<DataCalender> options4 =
                new FirebaseRecyclerOptions.Builder<DataCalender>()
                        .setQuery(mMentor4, DataCalender.class)
                        .build();
        calendarAdapter4 = new CalendarAdapter(options4);
        rvthursday.setAdapter(calendarAdapter4);


        rvfriday.setLayoutManager(new LinearLayoutManager(this));

        mMentor5 = FirebaseDatabase.getInstance().getReference().child("Calendar").child(branchs).child(accadmicYear).child(division).child(batch).child("Friday");
        FirebaseRecyclerOptions<DataCalender> options5 =
                new FirebaseRecyclerOptions.Builder<DataCalender>()
                        .setQuery(mMentor5, DataCalender.class)
                        .build();
        calendarAdapter5 = new CalendarAdapter(options5);
        rvfriday.setAdapter(calendarAdapter5);



    }


    @Override
    protected void onStart() {
        super.onStart();
        calendarAdapter.startListening();
        calendarAdapter2.startListening();
        calendarAdapter3.startListening();
        calendarAdapter4.startListening();
        calendarAdapter5.startListening();

    }
    @Override
    protected void onStop() {
        super.onStop();
        calendarAdapter.stopListening();
        calendarAdapter2.stopListening();
        calendarAdapter3.stopListening();
        calendarAdapter4.stopListening();
        calendarAdapter5.stopListening();
    }

}