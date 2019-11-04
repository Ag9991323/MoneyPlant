package com.example.networkmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChildActivity extends AppCompatActivity {

     FirebaseAuth mAuth;
     FirebaseDatabase mDatabase;
     DatabaseReference reference;
     FirebaseUser mUser;
     String phonenumber;
     Button Group1,Group2,Group3,Group4,Group5,Group6,Group7,Group8,Group9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Group1=findViewById(R.id.group1);
        Group2=findViewById(R.id.group2);
        Group3=findViewById(R.id.group3);
        Group4=findViewById(R.id.group4);
        Group5=findViewById(R.id.group5);
        Group6=findViewById(R.id.group6);
        Group7=findViewById(R.id.group7);
        Group8=findViewById(R.id.group8);
        Group9 = findViewById(R.id.group9);


        mAuth = FirebaseAuth.getInstance();
        mUser =mAuth.getCurrentUser();
        phonenumber =mUser.getPhoneNumber();

        mDatabase = FirebaseDatabase.getInstance();

        Group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","myChild");
                startActivity(intent);
            }
        });

        Group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child2");
                startActivity(intent);
            }
        });
        Group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child3");
                startActivity(intent);
            }
        });
        Group4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child4");
                startActivity(intent);
            }
        });
        Group5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child5");
                startActivity(intent);
            }
        });

        Group6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child6");
                startActivity(intent);
            }
        });
        Group7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child7");
                startActivity(intent);
            }
        });
        Group8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child8");
                startActivity(intent);
            }
        });
        Group9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildActivity.this,childShowActivity.class);
                intent.putExtra("groupnumber","Child9");
                startActivity(intent);
            }
        });


    }
}
