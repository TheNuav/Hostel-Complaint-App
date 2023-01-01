package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button signinbtn;
    TextView regishere;
    FirebaseAuth mauth;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.loginemail);
        password=findViewById(R.id.loginpassword);
        signinbtn=findViewById(R.id.signinbttn);
        regishere=findViewById(R.id.signupp);
        mauth=FirebaseAuth.getInstance();
        signinbtn.setOnClickListener(view ->{
            loginuser();
        });
        regishere.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this,regiteracc.class));
            finish();
        });
    }
    private void loginuser()
    {
        String inemail= email.getText().toString();
        String inpass=password.getText().toString();
        if(TextUtils.isEmpty(inemail)){
            email.setError("Email Cannot be empty");
            email.requestFocus();
        }
        else if(TextUtils.isEmpty(inpass)){
            password.setError("Password Cannot be empty");
            password.requestFocus();
        }
        else{
            mauth.signInWithEmailAndPassword(inemail,inpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"User Loggged in Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Log in Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}