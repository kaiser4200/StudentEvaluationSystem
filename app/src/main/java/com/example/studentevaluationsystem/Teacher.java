package com.example.studentevaluationsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Teacher extends AppCompatActivity implements View.OnClickListener {

    private EditText teacherEmailEditText,teacherPasswordEditText;
    private Button teachersigninButton;
    private TextView teachersigninTextView;
    private FirebaseAuth mAuth;
    ProgressBar teachersigninProgressbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        this.setTitle("Teacher Sign in");

        mAuth = FirebaseAuth.getInstance();


        teacherEmailEditText = findViewById(R.id.teacheremailId);
        teacherPasswordEditText =findViewById(R.id.teacherpasswordId);
        teachersigninButton = findViewById(R.id.teachersigninbuttonId);
        teachersigninTextView=findViewById(R.id.teachersigninTextviewId);
        teachersigninProgressbar=findViewById(R.id.teachersigninProgressbarId);

        teachersigninButton.setOnClickListener(this);
        teachersigninTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {

            case R.id.teachersigninbuttonId:
                teacherSignIn();
                break;

            case R.id.teachersigninTextviewId:
                Intent intent = new Intent(getApplicationContext(),TeacherSignUp.class);
                startActivity(intent);
                break;
        }

    }

    private void teacherSignIn() {

        String email = teacherEmailEditText.getText().toString().trim();
        String password = teacherPasswordEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            teacherEmailEditText.setError("Enter an email address");
            teacherEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            teacherEmailEditText.setError("Enter an valid email address");
            teacherEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            teacherPasswordEditText.setError("Enter a password");
            teacherPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            teacherPasswordEditText.setError("At least 6 charecters password");
            teacherPasswordEditText.requestFocus();
            return;
        }

        teachersigninProgressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                teachersigninProgressbar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    finish();
                    Intent intent = new Intent(getApplicationContext(),TeacherPanel.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sign In Unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
