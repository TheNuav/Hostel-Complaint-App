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

public class regiteracc extends AppCompatActivity {
    EditText registeremail;
    EditText password;
    Button rebttn;
    TextView login;
    FirebaseAuth mauth;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registeremail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        rebttn=findViewById(R.id.signupbttn);
        mauth=FirebaseAuth.getInstance();
        rebttn.setOnClickListener(view ->{
            createuser();
        });
        login.setOnClickListener(view ->{
            startActivity(new Intent(regiteracc.this,LoginActivity.class));
            finish();
        });

    }
    private void createuser()
    {
        String email=registeremail.getText().toString();
        String pass=password.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            registeremail.setError("Email Cannot be empty");
            registeremail.requestFocus();
        }
        else if(TextUtils.isEmpty(pass))
        {
            password.setError("Email Cannot be empty");
            password.requestFocus();
        }
        else
        {
            mauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(regiteracc.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(regiteracc.this,"Registration Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
