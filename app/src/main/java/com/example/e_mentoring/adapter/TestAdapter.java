package com.example.e_mentoring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoring.R;
import com.example.e_mentoring.model.TestModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TestAdapter extends FirebaseRecyclerAdapter<TestModel,TestAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public TestAdapter(@NonNull FirebaseRecyclerOptions<TestModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull TestModel model) {
        holder.name.setText(model.getName());


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.testitem,parent,false);
        return new TestAdapter.myViewHolder(view);

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name;

    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);

    }
}
}
