package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    Button compbot,lo;
    @Override
    protected void onCreate(Bundle savedInstancceState){
        super.onCreate(savedInstancceState);
        setContentView(R.layout.activity_admin);
        compbot=findViewById(R.id.shc);
        lo=findViewById(R.id.algbutton);
        lo.setOnClickListener(view -> {
            startActivity(new Intent(AdminActivity.this,AdminLoginActivity.class));
        });
        compbot.setOnClickListener(view -> {
            startActivity(new Intent(AdminActivity.this,ComplainBoxActivity.class));
        });
    }
}
