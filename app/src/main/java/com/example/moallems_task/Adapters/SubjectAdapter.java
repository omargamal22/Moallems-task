package com.example.moallems_task.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moallems_task.Model.Subject;
import com.example.moallems_task.R;
import com.example.moallems_task.SubjectClick;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<Subject> subjectArrayList;
    SubjectClick subjectClick;

    public SubjectAdapter(Activity context, ArrayList<Subject> subjectArrayList , SubjectClick click) {
        this.context = context;
        this.subjectArrayList = subjectArrayList;
        this.subjectClick = click;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.subject_item,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final Subject subject = subjectArrayList.get(position);
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;

        viewHolder.txtView_Name.setText(subject.getSubjectName());
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectClick.onClick(subject.getSubjectName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjectArrayList.size();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView txtView_Name;
        RelativeLayout relativeLayout;
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView_Name = itemView.findViewById(R.id.SubjectName);
            relativeLayout = itemView.findViewById(R.id.holder);


        }
    }
}
