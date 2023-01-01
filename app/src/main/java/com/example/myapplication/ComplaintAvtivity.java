package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintAvtivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    UploadClass uploadClass;
    EditText roll,room,hos,complain;
    Button subbut;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        roll=findViewById(R.id.rolls);
        room=findViewById(R.id.roomnos);
        hos=findViewById(R.id.hostelname);
        complain=findViewById(R.id.compdet);
        uploadClass =new UploadClass();
        databaseReference=firebaseDatabase.getInstance().getReference().child("Complains");
        subbut=findViewById(R.id.compsub);
        subbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadClass.setRollno(roll.getText().toString());
                uploadClass.setHosteln(hos.getText().toString());
                uploadClass.setRoomno(room.getText().toString());
                uploadClass.setComplaint(complain.getText().toString());
                String id=databaseReference.push().getKey();
                databaseReference.child(id).setValue(uploadClass);
                Toast.makeText(ComplaintAvtivity.this, "Complaint Sent", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
