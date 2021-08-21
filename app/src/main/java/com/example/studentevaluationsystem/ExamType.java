package com.example.studentevaluationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ExamType extends AppCompatActivity {

    public Button quizButton,examButton,assignmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_type);
        this.setTitle("Exam Type");


        quizButton = findViewById(R.id.quizButtonId);
        examButton = findViewById(R.id.examButtonId);
        assignmentButton = findViewById(R.id.assignmentButtonId);


        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamType.this,Quiz.class);
                startActivity(intent);
            }
        });
        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamType.this,ExamQuestion.class);
                startActivity(intent);
            }
        });
        assignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamType.this,Assignment.class);
                startActivity(intent);
            }
        });
    }
}
