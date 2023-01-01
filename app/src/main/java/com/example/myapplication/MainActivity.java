package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mauth;
    Button messref;
    Button logout;
    Button comp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);
        mauth = FirebaseAuth.getInstance();
        logout=findViewById(R.id.button);
        messref=findViewById(R.id.mess);
        comp=findViewById(R.id.compla);
        comp.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,ComplaintAvtivity.class));
        });
        messref.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,RefffmessActivity.class));
        });
        logout.setOnClickListener(view ->{
            mauth.signOut();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mauth.getCurrentUser();
        if(user==null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }

}

}