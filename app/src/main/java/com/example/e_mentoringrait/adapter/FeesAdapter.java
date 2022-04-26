package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataFees;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class FeesAdapter extends FirebaseRecyclerAdapter<DataFees,FeesAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FeesAdapter(@NonNull FirebaseRecyclerOptions<DataFees> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataFees model) {
        holder.totalfees.setText("Total Fee : "+model.getTotalfees());
        holder.paidfees.setText("Paid Fee : "+model.getPaidfees());
        holder.balancefees.setText("Balance fee : "+model.getBalancefees());
        holder.Scholarshipfees.setText("Scholarship Types : "+model.getScholarship());
        holder.Categoryfees.setText("Category : "+model.getCategory());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feesitem,parent,false);
        return new myViewHolder(view) ;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView totalfees,paidfees,balancefees,Scholarshipfees,Categoryfees;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            totalfees = itemView.findViewById(R.id.totalfees);
            paidfees = itemView.findViewById(R.id.paidfees);
            balancefees = itemView.findViewById(R.id.balancefees);
            Scholarshipfees = itemView.findViewById(R.id.Scholarshipfees);
            Categoryfees = itemView.findViewById(R.id.Categoryfees);

        }
    }

}
