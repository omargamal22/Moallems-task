package com.example.moallems_task.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moallems_task.Model.Subject;

import java.util.ArrayList;

public class SubjectViewModel extends ViewModel {
    MutableLiveData<ArrayList<Subject>> userLiveData;
    ArrayList<Subject> userArrayList;

    public SubjectViewModel() {
        userLiveData = new MutableLiveData<>();

        init();
    }

    public MutableLiveData<ArrayList<Subject>> getSubjectsMutableLiveData() {
        return userLiveData;
    }

    public void init(){
        populateList();
        userLiveData.setValue(userArrayList);
    }

    public void populateList(){

        //in this function we could call Rest API or call a function in the model to get the needed data.
        //I made a dumy data.
        Subject subject = new Subject();
        subject.setSubjectName("Physics");
        userArrayList = new ArrayList<>();
        userArrayList.add(subject);
        subject = new Subject();
        subject.setSubjectName("Biology");
        userArrayList.add(subject);
        subject = new Subject();
        subject.setSubjectName("History");
        userArrayList.add(subject);
        subject = new Subject();
        subject.setSubjectName("Algebra");
        userArrayList.add(subject);
    }
}

