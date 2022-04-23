package com.example.e_mentoringrait.mentee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.adapter.ChatAdapter;
import com.example.e_mentoringrait.adapter.EventAdapter;
import com.example.e_mentoringrait.adapter.PlacementAdapter;
import com.example.e_mentoringrait.model.DataChat;
import com.example.e_mentoringrait.model.DataEvent;
import com.example.e_mentoringrait.model.DataPlacement;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenteeExtraCirculam extends AppCompatActivity {
    RecyclerView rvExtracirculam,rvPlacement;
    EventAdapter eventAdapter;
    PlacementAdapter placementAdapter;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference mEvent,mPlacement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_extra_circulam);
        rvExtracirculam = findViewById(R.id.rvextracirculam);
        rvExtracirculam.setLayoutManager(new LinearLayoutManager(this));

        rvPlacement = findViewById(R.id.rvplacement);
        rvPlacement.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        String branchs = intent.getStringExtra("branch");
        String accadmicYear = intent.getStringExtra("accadmicYear");
        String division = intent.getStringExtra("division");
        String batch = intent.getStringExtra("batch");


        mEvent = FirebaseDatabase.getInstance().getReference().child("Event").child(branchs).child(accadmicYear).child(division).child(batch).child(FirebaseAuth.getInstance().getUid());

        FirebaseRecyclerOptions<DataEvent> options =
                new FirebaseRecyclerOptions.Builder<DataEvent>()
                        .setQuery(mEvent, DataEvent.class)
                        .build();
        eventAdapter = new EventAdapter(options);
        rvExtracirculam.setAdapter(eventAdapter);

        mPlacement = FirebaseDatabase.getInstance().getReference().child("Placement").child(branchs).child(accadmicYear).child(division).child(batch).child(FirebaseAuth.getInstance().getUid());

        FirebaseRecyclerOptions<DataPlacement> options1 =
                new FirebaseRecyclerOptions.Builder<DataPlacement>()
                        .setQuery(mPlacement, DataPlacement.class)
                        .build();
        placementAdapter = new PlacementAdapter(options1);
        rvPlacement.setAdapter(placementAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        eventAdapter.startListening();
        placementAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventAdapter.stopListening();
        placementAdapter.stopListening();
    }
}