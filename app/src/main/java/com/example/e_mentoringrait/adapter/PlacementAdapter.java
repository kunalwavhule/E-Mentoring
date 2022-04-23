package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataPlacement;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PlacementAdapter extends FirebaseRecyclerAdapter<DataPlacement,PlacementAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PlacementAdapter(@NonNull FirebaseRecyclerOptions<DataPlacement> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataPlacement model) {
        holder.companyPosition.setText(model.getPosition());
        holder.companyName.setText(model.getCompanyName());
        holder.companyLoacation.setText(model.getLocation());
        holder.companyPackage.setText(model.getPackage());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addplacementitem,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView companyPosition,companyName,companyLoacation,companyPackage;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            companyPosition = itemView.findViewById(R.id.companyPosition);
            companyName = itemView.findViewById(R.id.companyName);
            companyLoacation = itemView.findViewById(R.id.companyLoacation);
            companyPackage = itemView.findViewById(R.id.companyPackage);

        }
    }

}
