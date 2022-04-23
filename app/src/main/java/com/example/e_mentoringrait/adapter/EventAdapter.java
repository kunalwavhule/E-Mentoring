package com.example.e_mentoringrait.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_mentoringrait.R;
import com.example.e_mentoringrait.model.DataEvent;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EventAdapter extends FirebaseRecyclerAdapter<DataEvent,EventAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EventAdapter(@NonNull FirebaseRecyclerOptions<DataEvent> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DataEvent model) {
        holder.eventName.setText(model.getEventName());
        holder.eventTypes.setText(model.getEventTypes());
        holder.eventOrganizer.setText(model.getEventOragnizer());
        holder.eventDiscription.setText(model.getEventDiscription());
        holder.eventDate.setText(model.getEventDate());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.circulamitem,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView eventName,eventTypes,eventOrganizer,eventDiscription,eventDate;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventTypes = itemView.findViewById(R.id.eventTypes);
            eventOrganizer = itemView.findViewById(R.id.eventOrganizer);
            eventDiscription = itemView.findViewById(R.id.eventDiscription);
            eventDate = itemView.findViewById(R.id.eventdate);

         }
    }

}
