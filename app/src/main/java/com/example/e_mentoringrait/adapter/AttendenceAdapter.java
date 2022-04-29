package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataAttendence;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AttendenceAdapter extends FirebaseRecyclerAdapter<DataAttendence,AttendenceAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AttendenceAdapter(@NonNull FirebaseRecyclerOptions<DataAttendence> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataAttendence model) {
        holder.SubjectName.setText("Subject Name : "+model.getSubjectName());
        holder.Percentage.setText("Percentage : "+String.valueOf(model.getPercentage())+"%");
        holder.TotalClass.setText("Total Class : "+String.valueOf(model.getTotalClass()));
        holder.PrasentClass.setText("Prasent Class : "+String.valueOf(model.getPrasentClass()));
        holder.AbsentClass.setText("Absent Class : "+String.valueOf(model.getAbsentClass()));
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendenceitem,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView SubjectName,Percentage,TotalClass,PrasentClass,AbsentClass;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            SubjectName = itemView.findViewById(R.id.SubjectName);
            Percentage = itemView.findViewById(R.id.Percentage);
            TotalClass = itemView.findViewById(R.id.TotalClass);
            PrasentClass = itemView.findViewById(R.id.PrasentClass);
            AbsentClass = itemView.findViewById(R.id.AbsentClass);

        }
    }

}
