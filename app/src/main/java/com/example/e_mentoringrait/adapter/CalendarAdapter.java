package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataCalender;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CalendarAdapter extends FirebaseRecyclerAdapter<DataCalender,CalendarAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CalendarAdapter(@NonNull FirebaseRecyclerOptions<DataCalender> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataCalender model) {

        holder.StartTime.setText(model.getStartTime());
        holder.EndTime.setText(model.getEndTime());
        holder.ClassName.setText(model.getClassName());
        holder.ClassRoom.setText(model.getClassRoom());
        holder.ClassType.setText(model.getClassType());
        holder.InstructerName.setText(model.getInstructerName());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendaritem,parent,false);
        return new CalendarAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView StartTime,EndTime,ClassName,ClassRoom,ClassType,InstructerName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            StartTime = itemView.findViewById(R.id.StartTime);
            EndTime = itemView.findViewById(R.id.EndTime);
            ClassName = itemView.findViewById(R.id.ClassName);
            ClassRoom = itemView.findViewById(R.id.ClassRoom);
            ClassType = itemView.findViewById(R.id.ClassType);
            InstructerName = itemView.findViewById(R.id.InstructerName);
        }
    }

}
