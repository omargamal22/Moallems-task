package com.example.moallems_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        StringBuilder stringBuilder = new StringBuilder("Subject");
        stringBuilder.append(getIntent().getStringExtra("Name"));
        stringBuilder.append("clicked");
        ((TextView)findViewById(R.id.Clicked)).setText(stringBuilder.toString());
    }
}
