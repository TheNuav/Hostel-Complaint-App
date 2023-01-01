package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ComplainBoxActivity extends AppCompatActivity {
    Button btns;
    ListView list;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compladmin);
        btns=findViewById(R.id.buttonc2);
        list=findViewById(R.id.listcomp);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> c=new ArrayList<>();
                ArrayAdapter adapter=new ArrayAdapter<String>(ComplainBoxActivity.this,R.layout.activity_complaintbox2,c);
                list.setAdapter(adapter);
                FirebaseDatabase.getInstance().getReference().child("Complains").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists())
                        {
                            c.clear();
                            for(DataSnapshot snapshot1:snapshot.getChildren()){
                                Complain ob=snapshot1.getValue(Complain.class);
                                String t="Roll Number: "+ob.getRollno()+"\n"+"Hostel: "+ob.getHosteln()+"\n"+"Room Number: "+ob.getRoomno()+"\n"+"Complaint: "+ob.getComplaint();
                                c.add(t);

                            }
                            adapter.notifyDataSetChanged();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }

}