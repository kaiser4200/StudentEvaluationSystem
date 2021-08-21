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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText signUpNameEditText,signUpEmailEditText,signUpPasswordEditText,signUpConfirmPasswordEditText;
    private TextView signUpGenderTextview,signUpTextView;
    private Button signUpButton;
    private RadioGroup signUpRadioGroup;
    private RadioButton signUpGenderButton;
    private FirebaseAuth mAuth;
    private ProgressBar signUpProgressbar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");

        mAuth = FirebaseAuth.getInstance();

        signUpNameEditText = findViewById(R.id.signUpNameId);
        signUpEmailEditText = findViewById(R.id.signUpEmailId);
        signUpPasswordEditText = findViewById(R.id.signUpPasswordId);
        signUpConfirmPasswordEditText = findViewById(R.id.signUpConfirmPasswordId);
        signUpGenderTextview = findViewById(R.id.signUpGenderId);
        signUpTextView = findViewById(R.id.signUptextviewId);
        signUpButton = findViewById(R.id.signUpButtonId);
        signUpRadioGroup = findViewById(R.id.signUpRadioGroupId);
        signUpProgressbar=findViewById(R.id.signUpProgressbarId);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.signUpButtonId:{
                userRegister();
                break;}

            case R.id.signUptextviewId:{
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;}


        }

    }

    private void userRegister() {

        String name = signUpNameEditText.getText().toString().trim();
        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();
        String confirmpassword = signUpConfirmPasswordEditText.getText().toString().trim();

        int radioselect = signUpRadioGroup.getCheckedRadioButtonId();
        signUpGenderButton = findViewById(radioselect);
        String radioGroup = signUpGenderButton.getText().toString();

        if(name.isEmpty())
        {
            signUpNameEditText.setError("Enter your name");
            signUpNameEditText.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter an valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signUpPasswordEditText.setError("At least 6 charecters password");
            signUpPasswordEditText.requestFocus();
            return;
        }
        if(!confirmpassword.equals(password))
        {
            signUpConfirmPasswordEditText.setError("password not matched");
            signUpConfirmPasswordEditText.requestFocus();
            return;
        }
        if(radioselect==-1)
        {
            signUpGenderButton.setError("please enter your gender");
            signUpGenderButton.requestFocus();
            return;
        }

        signUpProgressbar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                signUpProgressbar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();

                }
                else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                        Toast.makeText(getApplicationContext(),"User is already registered", Toast.LENGTH_SHORT).show();

                    else
                    Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
