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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherSignUp extends AppCompatActivity {

    private EditText teachersignUpNameEditText,teachersignUpEmailEditText,teachersignUpPasswordEditText,teachersignUpConfirmPasswordEditText;
    private TextView teachersignUpTextView;
    private Button teachersignUpButton;
    private ProgressBar teachersignUpProgressbar;

    DatabaseReference databaseReference;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);
        this.setTitle("Teacher's Sign Up");

        teachersignUpNameEditText = findViewById(R.id.teachersignUpNameId);
        teachersignUpEmailEditText = findViewById(R.id.teachersignUpEmailId);
        teachersignUpPasswordEditText = findViewById(R.id.teachersignUpPasswordId);
        teachersignUpConfirmPasswordEditText = findViewById(R.id.teachersignUpConfirmPasswordId);
        teachersignUpTextView = findViewById(R.id.teachersignUptextviewId);
        teachersignUpButton = findViewById(R.id.teachersignUpButtonId);
        teachersignUpProgressbar=findViewById(R.id.teachersignUpProgressbarId);

        databaseReference= FirebaseDatabase.getInstance().getReference("Teacher");
        firebaseAuth = FirebaseAuth.getInstance();

        teachersignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = teachersignUpNameEditText.getText().toString();
                final String email = teachersignUpEmailEditText.getText().toString();
                final String password = teachersignUpPasswordEditText.getText().toString();
                final String confirmPassword = teachersignUpConfirmPasswordEditText.getText().toString();



                if(name.isEmpty())
                {
                    teachersignUpNameEditText.setError("Enter your name");
                    teachersignUpNameEditText.requestFocus();
                    return;
                }
                if(email.isEmpty())
                {
                    teachersignUpEmailEditText.setError("Enter an email address");
                    teachersignUpEmailEditText.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    teachersignUpEmailEditText.setError("Enter an valid email address");
                    teachersignUpEmailEditText.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    teachersignUpPasswordEditText.setError("Enter a password");
                    teachersignUpPasswordEditText.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    teachersignUpPasswordEditText.setError("At least 6 charecters password");
                    teachersignUpPasswordEditText.requestFocus();
                    return;
                }
                if(!confirmPassword.equals(password))
                {
                    teachersignUpConfirmPasswordEditText.setError("password not matched");
                    teachersignUpConfirmPasswordEditText.requestFocus();
                    return;
                }


                teachersignUpProgressbar.setVisibility(View.VISIBLE);



                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(TeacherSignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                teachersignUpProgressbar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    TeacherSign information = new TeacherSign(
                                            name,
                                            email,
                                            password,
                                            confirmPassword
                                    );

                                    FirebaseDatabase.getInstance().getReference("Teacher")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            Toast.makeText(TeacherSignUp.this,"SIgn UP Complete" ,Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),TeacherPanel.class));

                                        }
                                    });


                                } else {

                                }

                                // ...
                            }
                        });
            }
        });
    }
}
