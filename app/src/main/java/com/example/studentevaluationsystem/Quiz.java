package com.example.studentevaluationsystem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Quiz extends AppCompatActivity {

    Button quizButton1,quizButton2,quizButton3,quizButton4;
    TextView quizText,timerText;
    int total=0,correct=0,wrong=0;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setTitle("Quiz");

        quizButton1 = findViewById(R.id.quizButton1Id);
        quizButton2 = findViewById(R.id.quizButton2Id);
        quizButton3 = findViewById(R.id.quizButton3Id);
        quizButton4 = findViewById(R.id.quizButton4Id);

        quizText = findViewById(R.id.quizTextId);
        timerText = findViewById(R.id.timerTextId);

        updateQuestion();
        reverseTimer(30,timerText);

    }

    private void updateQuestion() {

        total++;

        if(total>4)
        {

            Intent i = new Intent(Quiz.this,QuizResult.class);
            i.putExtra("Total",String.valueOf(total));
            i.putExtra("Correct",String.valueOf(correct));
            i.putExtra("Incorrect",String.valueOf(wrong));
            startActivity(i);

        }
        else
        {
            reference = FirebaseDatabase.getInstance().getReference().child("QuizQuestion").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final QuizQuestion quizQuestion = dataSnapshot.getValue(QuizQuestion.class);
                    quizText.setText(quizQuestion.getQuestion());
                    quizButton1.setText(quizQuestion.getOption1());
                    quizButton2.setText(quizQuestion.getOption2());
                    quizButton3.setText(quizQuestion.getOption3());
                    quizButton4.setText(quizQuestion.getOption4());


                    quizButton1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            quizButton1.setBackgroundColor(Color.GREEN);
                            if(quizButton1.getText().toString().equals(quizQuestion.getAnswer()))
                            {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        quizButton1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                            else
                            {
                                wrong++;
                                quizButton1.setBackgroundColor(Color.RED);
                                if(quizButton2.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton2.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton3.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton3.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton4.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        quizButton1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                        }
                    });



                    quizButton2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            quizButton2.setBackgroundColor(Color.GREEN);
                            if(quizButton2.getText().toString().equals(quizQuestion.getAnswer()))
                            {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        quizButton2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                            else
                            {
                                wrong++;
                                quizButton2.setBackgroundColor(Color.RED);

                                if(quizButton1.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton1.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton3.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton3.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton4.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        quizButton1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                        }
                    });



                    quizButton3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            quizButton3.setBackgroundColor(Color.GREEN);
                            if(quizButton3.getText().toString().equals(quizQuestion.getAnswer()))
                            {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        quizButton3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                            else
                            {
                                wrong++;
                                quizButton3.setBackgroundColor(Color.RED);

                                if(quizButton1.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton1.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton2.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton2.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton4.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton4.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        quizButton1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                        }
                    });


                    quizButton4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            quizButton4.setBackgroundColor(Color.GREEN);
                            if(quizButton4.getText().toString().equals(quizQuestion.getAnswer()))
                            {
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        quizButton4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                            else
                            {
                                wrong++;
                                quizButton4.setBackgroundColor(Color.RED);

                                if(quizButton1.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton1.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton2.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton2.setBackgroundColor(Color.GREEN);
                                }
                                else if(quizButton3.getText().toString().equals(quizQuestion.getAnswer()))
                                {
                                    quizButton3.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        quizButton1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        quizButton4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);

                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    public void reverseTimer(int seconds, final TextView tv)
    {
        new CountDownTimer(seconds* 1000+1000,1000){
            public void onTick(long milliUntilFinished){

                int seconds = (int)(milliUntilFinished/1000);
                int minutes = seconds/60;
                seconds = seconds%60;
                tv.setText(String.format("%02d",minutes) +":"+String.format("%02d", seconds));

            }

            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent intent = new Intent(Quiz.this,QuizResult.class);
                intent.putExtra("Total",String.valueOf(total));
                intent.putExtra("Correct",String.valueOf(correct));
                intent.putExtra("Incorrect",String.valueOf(wrong));
                startActivity(intent);

            }

        }.start();
    }
}
