package com.example.studentevaluationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherPanel extends AppCompatActivity {
    private Button quizButton,examButton,assignmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_panel);
        this.setTitle("Teacher's Panel");

        quizButton = findViewById(R.id.teacherquizButtonId);
        examButton = findViewById(R.id.teacherexamButtonId);
        assignmentButton = findViewById(R.id.teacherassignmentButtonId);


        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherPanel.this,TeacherQuiz1.class);
                startActivity(intent);
            }
        });
        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherPanel.this,ExamQuestion.class);
                startActivity(intent);
            }
        });
        assignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherPanel.this,Assignment.class);
                startActivity(intent);
            }
        });
    }
}
