package com.example.studentevaluationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Assignment extends AppCompatActivity {

    private TextView assignmentQuestion,assignmentLink,assignmentSubmit;
    private Button assignmentSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        this.setTitle("Assignment");

        assignmentQuestion=findViewById(R.id.assignmentQuestionTextId);
        assignmentLink=findViewById(R.id.assignmentLinkTextId);
        assignmentSubmit=findViewById(R.id.assignmentEditTextId);
        assignmentSubmitButton=findViewById(R.id.assignmentSubmitButtonId);
    }
}
