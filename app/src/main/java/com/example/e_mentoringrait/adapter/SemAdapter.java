package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataSemSubject;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SemAdapter extends FirebaseRecyclerAdapter<DataSemSubject,SemAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SemAdapter(@NonNull FirebaseRecyclerOptions<DataSemSubject> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataSemSubject model) {
        holder.semName.setText("Sem"+model.getSemName());

        holder.SN1.setText(model.getSN1());
        holder.SN2.setText(model.getSN2());
        holder.SN3.setText(model.getSN3());
        holder.SN4.setText(model.getSN4());
        holder.SN5.setText(model.getSN5());
        holder.SN6.setText(model.getSN6());

        holder.Sb1ut1.setText(model.getSb1ut1());
        holder.Sb2ut1.setText(model.getSb2ut1());
        holder.Sb3ut1.setText(model.getSb3ut1());
        holder.Sb4ut1.setText(model.getSb4ut1());
        holder.Sb5ut1.setText(model.getSb5ut1());
        holder.Sb6ut1.setText(model.getSb6ut1());

        holder.Sb1ut2.setText(model.getSb1ut2());
        holder.Sb2ut2.setText(model.getSb2ut2());
        holder.Sb3ut2.setText(model.getSb3ut2());
        holder.Sb4ut2.setText(model.getSb4ut2());
        holder.Sb5ut2.setText(model.getSb5ut2());
        holder.Sb6ut2.setText(model.getSb6ut2());

        holder.Sb1fl.setText(model.getSb1fl());
        holder.Sb2fl.setText(model.getSb2fl());
        holder.Sb3fl.setText(model.getSb3fl());
        holder.Sb4fl.setText(model.getSb4fl());
        holder.Sb5fl.setText(model.getSb5fl());
        holder.Sb6fl.setText(model.getSb6fl());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
                TextView
                SN1, SN2,SN3,SN4, SN5, SN6,
                Sb1ut1 , Sb2ut1, Sb3ut1, Sb4ut1,Sb5ut1,Sb6ut1,
                Sb1ut2, Sb2ut2,Sb3ut2,Sb4ut2, Sb5ut2,Sb6ut2,
                Sb1fl, Sb2fl, Sb3fl, Sb4fl,Sb5fl,Sb6fl,semName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            semName = itemView.findViewById(R.id.semNamets);


            SN1 = itemView.findViewById(R.id.sN1ts);
            SN2 = itemView.findViewById(R.id.sN2ts);
            SN3 = itemView.findViewById(R.id.sN3ts);
            SN4 = itemView.findViewById(R.id.sN4ts);
            SN5 = itemView.findViewById(R.id.sN5ts);
            SN6 = itemView.findViewById(R.id.sN6ts);

            Sb1ut1 = itemView.findViewById(R.id.sb1ut1ts);
            Sb2ut1 = itemView.findViewById(R.id.sb2ut1ts);
            Sb3ut1 = itemView.findViewById(R.id.sb3ut1ts);
            Sb4ut1 = itemView.findViewById(R.id.sb4ut1ts);
            Sb5ut1 = itemView.findViewById(R.id.sb5ut1ts);
            Sb6ut1 = itemView.findViewById(R.id.sb6ut1ts);

            Sb1ut2 = itemView.findViewById(R.id.sb1ut2ts);
            Sb2ut2 = itemView.findViewById(R.id.sb2ut2ts);
            Sb3ut2 = itemView.findViewById(R.id.sb3ut2ts);
            Sb4ut2 = itemView.findViewById(R.id.sb4ut2ts);
            Sb5ut2 = itemView.findViewById(R.id.sb5ut2ts);
            Sb6ut2 = itemView.findViewById(R.id.sb6ut2ts);

            Sb1fl = itemView.findViewById(R.id.sb1flts);
            Sb2fl = itemView.findViewById(R.id.sb2flts);
            Sb3fl = itemView.findViewById(R.id.sb3flts);
            Sb4fl = itemView.findViewById(R.id.sb4flts);
            Sb5fl = itemView.findViewById(R.id.sb5flts);
            Sb6fl = itemView.findViewById(R.id.sb6flts);


        }
    }

}

