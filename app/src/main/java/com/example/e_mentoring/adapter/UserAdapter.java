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

public class UserAdapter extends FirebaseRecyclerAdapter<DataMentee,UserAdapter.myViewHolder>{


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UserAdapter(@NonNull FirebaseRecyclerOptions<DataMentee> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataMentee model) {

        holder.fullname.setText(model.getFullName());
        holder.rollno.setText(model.getRollNo());
        holder.email.setText(model.getEmail());
        holder.address.setText(model.getAddress());
        holder.religion.setText(model.getReligion());
        holder.caste.setText(model.getCaste());
        holder.ssc.setText(model.getSsc());
        holder.hsc.setText(model.getHsc());
        holder.branch.setText(model.getBranch());


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.csitem,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView fullname,rollno,email,address,religion,caste,ssc,hsc,branch;
        // Button delete;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.fullname);
            rollno = itemView.findViewById(R.id.rollno);

            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);
            religion = itemView.findViewById(R.id.religion);
            caste = itemView.findViewById(R.id.caste);
            ssc = itemView.findViewById(R.id.ssc);
            hsc = itemView.findViewById(R.id.hsc);
            branch = itemView.findViewById(R.id.branch);
        }
    }


}
