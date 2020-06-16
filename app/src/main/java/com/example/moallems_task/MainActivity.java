package com.example.moallems_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.moallems_task.Adapters.SubjectAdapter;
import com.example.moallems_task.Adapters.VideosAdapter;
import com.example.moallems_task.Model.Subject;
import com.example.moallems_task.ViewModels.SubjectViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView Subjects;
    RecyclerView Vedios;
    SubjectAdapter subjectAdapter;
    VideosAdapter videosAdapter;
    SubjectViewModel subjectViewModel;
    SubjectClick subjectClick;
    VedioClick vedioClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity context = this;
        Subjects = findViewById(R.id.subjects);
        Vedios = findViewById(R.id.videos);
        subjectClick = new SubjectClick() {
            @Override
            public void onClick(String SubjectName) {
                Intent i = new Intent(context,Main2Activity.class);
                i.putExtra("Name",SubjectName);
                startActivity(i);
            }
        };
        vedioClick = new VedioClick() {
            @Override
            public void onClick(VideoView videoView) {

                videoView.requestFocus();
                videoView.start();
            }
        };
        subjectViewModel = ViewModelProviders.of(context).get(SubjectViewModel.class);
        subjectViewModel.getSubjectsMutableLiveData().observe(this, new Observer<ArrayList<Subject>>() {
            @Override
            public void onChanged(ArrayList<Subject> subjects) {
                subjectAdapter = new SubjectAdapter(context,subjects,subjectClick);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                Subjects.setLayoutManager(linearLayoutManager);
                Subjects.setAdapter(subjectAdapter);
            }
        });

        videosAdapter = new VideosAdapter(context,vedioClick);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        Vedios.setLayoutManager(linearLayoutManager);
        Vedios.setAdapter(videosAdapter);
    }
}
