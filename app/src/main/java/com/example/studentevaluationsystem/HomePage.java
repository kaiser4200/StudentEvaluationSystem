package com.example.studentevaluationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {



    public TextView homePageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        this.setTitle("Home Page");


        homePageText=findViewById(R.id.homePageTextId);


        homePageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,ExamType.class);
                startActivity(intent);
            }
        });

    }
}
