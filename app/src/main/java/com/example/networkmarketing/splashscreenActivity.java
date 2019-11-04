package com.example.networkmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class splashscreenActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    ArrayList<String> ownerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        mAuth =FirebaseAuth.getInstance();
        ownerlist=new ArrayList<>();
        ownerlist.add("+919466789950");
        ownerlist.add("+919996565391");
        ownerlist.add("+919034026218");
        ownerlist.add("+919817449356");
        ownerlist.add("+917988351336");
        ownerlist.add("+919812425119");
        ownerlist.add("+919872600129");
        ownerlist.add("+918307971265");
        ownerlist.add("+918708584525");
    }
    protected void onStart() {
        super.onStart();
        checkUser();

    }

    private void checkUser(){
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    FirebaseUser user = mAuth.getCurrentUser();
                    final String phonenumber =user.getPhoneNumber();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds:dataSnapshot.getChildren()){
                                if(phonenumber.equals(ds.child("MobileNumber").getValue())){
                                    if("success".equals(ds.child("payment").getValue())){
                                        if(ownerlist.contains(phonenumber)){
                                            startActivity(new Intent(splashscreenActivity.this,OwnerDashboardActivity.class));
                                            finish();
                                        }
                                        else{
                                            startActivity(new Intent(splashscreenActivity.this,Dashboard.class));
                                            finish();
                                        }
                                    }
                                    else{
                                        Toast.makeText(splashscreenActivity.this,"Your payment of registration fee is pending",Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(splashscreenActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });


                    // Firebase working code
//                    FirebaseDatabase databse= FirebaseDatabase.getInstance();
//                    DatabaseReference referenceStudent=databse.getReference("Students");
//                    DatabaseReference referenceTeacher=databse.getReference("Teachers");
//                    referenceStudent.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            for(DataSnapshot ds:dataSnapshot.getChildren()) {
//                                try {
//                                    if (uid.equals(ds.child("uid").getValue())) {
//
//                                        Intent intent = new Intent(SplashScreen.this, studentDashboard.class);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                } catch (Exception e) {
//
//                                    e.printStackTrace();
//                                }
//                            }}
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });
//
//
//                    // for teachers
//                    referenceTeacher.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            for(DataSnapshot ds:dataSnapshot.getChildren()){
//                                try{
//                                    if(uid.equals(ds.child("uid").getValue())){
//
//                                        Intent intent = new Intent(SplashScreen.this,teacherDashboard.class);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                }catch (Exception e){
//
//                                    e.printStackTrace();}
//                            }
//
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });


                }
            },100);

        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(splashscreenActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            },1000);
        }

    }
}
