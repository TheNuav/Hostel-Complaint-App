package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {
EditText em,pass;
Button l;
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_adminlogin);
    em=findViewById(R.id.aloginemail);
    pass=findViewById(R.id.aloginpassword);
    l=findViewById(R.id.asigninbttn);
    l.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String e="",p="";
            e=em.getText().toString();
            p=pass.getText().toString();
            if(e.equals("admin")&&p.equals("0000"))
            {
                startActivity(new Intent(AdminLoginActivity.this,AdminActivity.class));
            }
            else
            {
                Toast.makeText(AdminLoginActivity.this, "Check Username or Password", Toast.LENGTH_SHORT).show();
            }
        }
    });
}

}
