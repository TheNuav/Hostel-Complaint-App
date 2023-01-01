package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UseroptActivity extends AppCompatActivity {
    Button admin1;
    Button student1;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ueropt);
        admin1=findViewById(R.id.adminlog);
        student1=findViewById(R.id.studentlog);
        student1.setOnClickListener(view -> {
            startActivity(new Intent(UseroptActivity.this,MainActivity.class));
            finish();
        });
        admin1.setOnClickListener(view -> {
            startActivity(new Intent(UseroptActivity.this,AdminLoginActivity.class));
        });

    }

}
