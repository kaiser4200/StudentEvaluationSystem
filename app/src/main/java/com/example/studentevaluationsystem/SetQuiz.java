package com.example.studentevaluationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SetQuiz extends AppCompatActivity {

    EditText question,option1,option2,option3,option4,answer;
    Button nextButton,doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_quiz);

        question = findViewById(R.id.setQuestionId);
        option1 = findViewById(R.id.setOption1Id);
        option2 = findViewById(R.id.setOption2Id);
        option3 = findViewById(R.id.setOption3Id);
        option4 = findViewById(R.id.setOption4Id);
        answer = findViewById(R.id.setAnswerId);

        nextButton = findViewById(R.id.setNextButtonId);
        doneButton = findViewById(R.id.setDoneButtonId);

    }
}
