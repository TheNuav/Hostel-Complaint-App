package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RefffmessActivity extends AppCompatActivity {
    TextView text;
    TextView day;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reffmess);
        day=findViewById(R.id.ldays);
        text=findViewById(R.id.refc);
        btn=findViewById(R.id.calcbtn);
        btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    int n=Integer.parseInt(day.getText().toString());
                    int k=n*140;
                    text.setText("The Refund is Rs"+k);

                }
        });
    }
}
