package com.example.e_mentoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoring.R;
import com.example.e_mentoring.model.DataMentee;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RegisterMenteeAdapter extends FirebaseRecyclerAdapter<DataMentee,RegisterMenteeAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RegisterMenteeAdapter(@NonNull FirebaseRecyclerOptions<DataMentee> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataMentee model) {

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.csitem,parent,false);
        return new RegisterMenteeAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView rollNo, fullName,motherName,address,religion, caste, ssc, hsc, fee, admissionType;
        // Button delete;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
