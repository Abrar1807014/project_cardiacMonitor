package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Adapter Class for converting ArrayList of objects into View
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Model> arrayList;
    Context context;

    private final for_update for_update;

    /**
     *
     * @param arrayList
     * @param context
     * @param for_update
     *
     */
    public Adapter(ArrayList<Model> arrayList, Context context, for_update for_update) {
        this.arrayList = arrayList;
        this.context = context;
        this.for_update = for_update;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     * ViewHolder describes an Item View about it's position in Recycler View
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new  ViewHolder(view);
    }


    /**
     *
     * @param holder
     * @param position
     *  BindViewHolder generates a binding class for each XML layout 'layout' file
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = arrayList.get(position);
        holder.date.setText(model.getDate());
        holder.time.setText(model.getTime());
        holder.sys.setText(model.getSystolic());
        holder.dias.setText(model.getDiastolic());
        holder.hr.setText(model.getBpm());
        holder.com.setText(model.getComment());
        holder.user_com.setText(model.getUser_comment());

    }

    /**
     * getIteCount returns the number total inputs
     * @return
     */
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * ViewHolder describes an Item View about it's position in Recycler View
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date, time, sys, dias, hr, com, user_com;
        public LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.date_of_submission);
            time=itemView.findViewById(R.id.time);
            sys=itemView.findViewById(R.id.systolic_bp);
            dias = itemView.findViewById(R.id.diastolic_bp);
            hr=itemView.findViewById(R.id.heart_rate);
            com=itemView.findViewById(R.id.comment);
            user_com=itemView.findViewById(R.id.userComment);
            llrow=itemView.findViewById(R.id.main);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(for_update!=null){
                        int pos = getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            for_update.onTouch(pos);
                        }
                    }
                }
            });
        }
    }
}
