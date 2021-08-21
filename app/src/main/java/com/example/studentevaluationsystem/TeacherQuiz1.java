package com.example.studentevaluationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TeacherQuiz1 extends AppCompatActivity {

    String[] semester,first,second,third,forth,fifth;
    public Spinner spiner,spiner1;
    public TextView spinertextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_quiz1);

        semester = getResources().getStringArray(R.array.Semester);
        first = getResources().getStringArray(R.array.First);
        second = getResources().getStringArray(R.array.Second);
        third = getResources().getStringArray(R.array.Third);
        forth = getResources().getStringArray(R.array.Forth);
        fifth = getResources().getStringArray(R.array.Fifth);

        spiner = findViewById(R.id.spinerId);
        spiner1 = findViewById(R.id.spinerId1);
        spinertextView = findViewById(R.id.spinerTextviewId1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.samplespinerview, R.id.spinerSampleId1, semester);
        spiner.setAdapter(adapter);


        if (spiner1.getSelectedItem().toString().equals("First"))
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.samplespinerview, R.id.spinerSampleId1, first);
            spiner1.setAdapter(adapt);
        }
        if (spiner1.getSelectedItem().toString().equals("Second"))
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.samplespinerview, R.id.spinerSampleId1, second);
            spiner1.setAdapter(adapt);
        }
        if (spiner1.getSelectedItem().toString().equals("Third"))
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.samplespinerview, R.id.spinerSampleId1, third);
            spiner1.setAdapter(adapt);
        }
        if (spiner1.getSelectedItem().toString().equals("Forth"))
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.samplespinerview, R.id.spinerSampleId1, forth);
            spiner1.setAdapter(adapt);
        }
        if (spiner1.getSelectedItem().toString().equals("Fifth"))
        {
            ArrayAdapter<String> adapt = new ArrayAdapter<>(this, R.layout.samplespinerview, R.id.spinerSampleId1, fifth);
            spiner1.setAdapter(adapt);
        }

    }
}
