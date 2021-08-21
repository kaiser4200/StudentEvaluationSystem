package com.example.studentevaluationsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText signinEmailEditText,signinPasswordEditText;
    public Button signinButton;
    public TextView signinTextView;
    ProgressBar signinProgressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");

        mAuth = FirebaseAuth.getInstance();

        signinEmailEditText = findViewById(R.id.emailId);
        signinPasswordEditText = findViewById(R.id.passwordId);
        signinButton = findViewById(R.id.signinbuttonId);
        signinTextView = findViewById(R.id.signinTextviewId);
        signinProgressbar = findViewById(R.id.signinProgressbarId);

        signinButton.setOnClickListener(this);
        signinTextView.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.manu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.teacherId)
        {
            Intent intent = new Intent(getApplicationContext(),Teacher.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {

            case R.id.signinbuttonId:
                userSignIn();
                break;

            case R.id.signinTextviewId:
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
                break;
        }

    }

    private void userSignIn() {

        String email = signinEmailEditText.getText().toString().trim();
        String password = signinPasswordEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            signinEmailEditText.setError("Enter an email address");
            signinEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signinEmailEditText.setError("Enter an valid email address");
            signinEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            signinPasswordEditText.setError("Enter a password");
            signinPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signinPasswordEditText.setError("At least 6 charecters password");
            signinPasswordEditText.requestFocus();
            return;
        }

        signinProgressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                signinProgressbar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    finish();
                    Intent intent = new Intent(getApplicationContext(),HomePage.class);
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
