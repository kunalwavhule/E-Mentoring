package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataNotice;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class NoticeAdapter extends FirebaseRecyclerAdapter<DataNotice,NoticeAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NoticeAdapter(@NonNull FirebaseRecyclerOptions<DataNotice> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataNotice model) {
        holder.notice.setText(model.getNotice());
        holder.postedby.setText("Posted By : "+model.getPostedBy());
        holder.postedOn.setText("Posted On : "+model.getPostedOn());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticeitem,parent,false);
        return new myViewHolder(view);

    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView notice,postedby,postedOn;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            notice = itemView.findViewById(R.id.notice);
            postedby = itemView.findViewById(R.id.postedBy);
            postedOn = itemView.findViewById(R.id.postedOn);
        }
    }


}
