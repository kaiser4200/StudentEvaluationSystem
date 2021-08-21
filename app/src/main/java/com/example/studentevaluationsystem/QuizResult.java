package com.example.studentevaluationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizResult extends AppCompatActivity {

    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Result");
        setContentView(R.layout.activity_quiz_result);
        t1 = findViewById(R.id.textView8);
        t2 = findViewById(R.id.textView9);
        t3 = findViewById(R.id.textView10);

        Intent i = getIntent();
        String questions = i.getStringExtra("Total");
        String correct = i.getStringExtra("Correct");
        String wrong = i.getStringExtra("Incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);
    }
}
