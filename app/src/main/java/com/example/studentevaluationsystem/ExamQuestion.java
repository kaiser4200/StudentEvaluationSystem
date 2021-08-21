package com.example.studentevaluationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class ExamQuestion extends AppCompatActivity {

    private TextView examQuestion,examAnswer;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_question);
        this.setTitle("Examination");

        examQuestion=findViewById(R.id.examQuestionTextId);
        examAnswer=findViewById(R.id.examQuestionEditTextId);
        submitButton=findViewById(R.id.submitButtonId);

        updateQuestion();
    }

    private void updateQuestion() {
    }
}
