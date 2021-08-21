package com.example.studentevaluationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Semester extends AppCompatActivity {

    Button first,second,third,forth,fifth,sixth,seven,eighth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        first=findViewById(R.id.firstsemesterbuttonId);
        second=findViewById(R.id.secondsemesterbuttonId);
        third=findViewById(R.id.thirdsemesterbuttonId);
        forth=findViewById(R.id.forthsemesterbuttonId);
        fifth=findViewById(R.id.fifthsemesterbuttonId);
        sixth=findViewById(R.id.sixthsemesterbuttonId);
        seven=findViewById(R.id.seventhsemesterbuttonId);
        eighth=findViewById(R.id.eighthsemesterbuttonId);
    }
}
