package com.example.e_mentoringrait.adapter;

import android.companion.CompanionDeviceService;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.admin.AdminDivision;
import com.example.e_mentoringrait.admin.AdminMentee;
import com.example.e_mentoringrait.model.DataMentee;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class UserAdapter extends FirebaseRecyclerAdapter<DataMentee,UserAdapter.myViewHolder> {
    private Context context;

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

        holder.fullname.setText("Name : "+model.getFullName());
        holder.rollno.setText(model.getRollNo());
        holder.branch.setText("Branch : "+model.getBranch());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AdminMentee.class);
                intent.putExtra("fullname",model.getFullName());
                intent.putExtra("mobileno",model.getStudentNumber());
                intent.putExtra("email",model.getEmail());
                intent.putExtra("branch",model.getBranch());
                intent.putExtra("rollno",model.getRollNo());
                intent.putExtra("religion",model.getReligion());
                intent.putExtra("caste",model.getCaste());
                intent.putExtra("accadmicyear",model.getAccadmicYear());
                intent.putExtra("division",model.getDivision());
                intent.putExtra("batch",model.getBatch());
                intent.putExtra("uid",model.getUid());


                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.batchitem,parent,false);
        context = parent.getContext();
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView fullname,rollno,branch;
        RelativeLayout relativeLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.fullname);
            rollno = itemView.findViewById(R.id.rollno);
            branch = itemView.findViewById(R.id.branch);
            relativeLayout = itemView.findViewById(R.id.rl);
        }
    }

}
