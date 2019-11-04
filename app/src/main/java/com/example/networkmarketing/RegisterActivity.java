package com.example.networkmarketing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    EditText nameEt,mobileNoEt,passwordEt,referID,AccountNumber,IFSCCODE;
    Button registerBtn,verifyBtn;
    ProgressDialog progressDialog;
    TextView alreadyRegisteredTv;
    private FirebaseAuth mAuth;
    Boolean  referidflag=false;
    String level1,level2,level3,level4,level5,level6,level7,level8,level9,TotalCount;
    String account1,account2,account3,account4,account5,account6,account7,account8,account9;
    String ifsc1,ifsc2,ifsc3,ifsc4,ifsc5,ifsc6,ifsc7,ifsc8,ifsc9;
    String name1,name2,name3,name4,name5,name6,name7,name8,name9;
    String ownerid;
    long individualCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //init
        nameEt = findViewById(R.id.nameET);
        mobileNoEt = findViewById(R.id.mobileNoEt);
        passwordEt = findViewById(R.id.passwordEt);
        referID = findViewById(R.id.referIdEt);
        AccountNumber = findViewById(R.id.bankAccountEt);
        IFSCCODE = findViewById(R.id.IFSCCodeEt);
        verifyBtn = findViewById(R.id.verifyBtn);


        registerBtn = findViewById(R.id.registerBtn);
        alreadyRegisteredTv=findViewById(R.id.alreadyRegisteredTv);


        //Progress Bar
        progressDialog = new ProgressDialog(this);

        //Firebase
        mAuth = FirebaseAuth.getInstance();

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Verifying.....");
                progressDialog.show();
                final String referid= "+91"+referID.getText().toString().trim();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference =database.getReference("Teams");


                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds :dataSnapshot.getChildren()){

                            try{
                                if(referid.equals(ds.child("MobileNumber").getValue())){
                                    referidflag=true;
                                    progressDialog.dismiss();
                                    Toast.makeText(RegisterActivity.this,"Refer id  is connected",Toast.LENGTH_SHORT).show();
                                     level1=""+ds.child("level2").getValue();
                                     level2=""+ds.child("level3").getValue();
                                     level3=""+ds.child("level4").getValue();
                                     level4=""+ds.child("level5").getValue();
                                     level5=""+ds.child("level6").getValue();
                                     level6=""+ds.child("level7").getValue();
                                     level7=""+ds.child("level8").getValue();
                                     level8=""+ds.child("level9").getValue();
                                     account1=""+ds.child("account2").getValue();
                                     account2=""+ds.child("account3").getValue();
                                    account3=""+ds.child("account4").getValue();
                                    account4=""+ds.child("account5").getValue();
                                    account5=""+ds.child("account6").getValue();
                                    account6=""+ds.child("account7").getValue();
                                    account7=""+ds.child("account8").getValue();
                                    account8=""+ds.child("account9").getValue();

                                    ifsc1=""+ds.child("ifsc2").getValue();
                                    ifsc2=""+ds.child("ifsc3").getValue();
                                    ifsc3=""+ds.child("ifsc4").getValue();
                                    ifsc4=""+ds.child("ifsc5").getValue();
                                    ifsc5=""+ds.child("ifsc6").getValue();
                                    ifsc6=""+ds.child("ifsc7").getValue();
                                    ifsc7=""+ds.child("ifsc8").getValue();
                                    ifsc8=""+ds.child("ifsc9").getValue();

                                    name1=""+ds.child("name2").getValue();
                                    name2=""+ds.child("name3").getValue();
                                    name3=""+ds.child("name4").getValue();
                                    name4=""+ds.child("name5").getValue();
                                    name5=""+ds.child("name6").getValue();
                                    name6=""+ds.child("name7").getValue();
                                    name7=""+ds.child("name8").getValue();
                                    name8=""+ds.child("name9").getValue();




                                    ownerid=""+ds.child("ownerid").getValue();
                                    individualCount=ds.child("myChild").getChildrenCount();


                                    TotalCount=""+ds.child("count").getValue();
                                     level9= referid;
                                     account9=""+ds.child("myaccount").getValue();
                                     ifsc9=""+ds.child("myifsc").getValue();
                                     name9=""+ds.child("name").getValue();



                                }
                            }
                            catch (Exception e) {
                                progressDialog.dismiss();
                                e.printStackTrace();
                            }


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        progressDialog.dismiss();
                        referID.setError("Enter correct Refer Id");
                        referID.setFocusable(true);
                    }
                });

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name=nameEt.getText().toString().trim();
                final String mobileNo=mobileNoEt.getText().toString().trim();

                String password = passwordEt.getText().toString().trim();
               final String referid= referID.getText().toString().trim();
                final String accountNumber = AccountNumber.getText().toString().trim();
                final String ifsccode =IFSCCODE.getText().toString().toUpperCase().trim();

                if(TextUtils.isEmpty(name)){
                    nameEt.setError("Please Enter Your Name");
                    nameEt.setFocusable(true);
                }
                else if(TextUtils.isEmpty(mobileNo)){
                    mobileNoEt.setError("Please enter your Mobile Number");
                    mobileNoEt.setFocusable(true);
                }
                else if(TextUtils.isEmpty(accountNumber)){
                    mobileNoEt.setError("Please enter your Account Number");
                    mobileNoEt.setFocusable(true);
                }
                else if(TextUtils.isEmpty(ifsccode)){
                    mobileNoEt.setError("Please enter your Account Number");
                    mobileNoEt.setFocusable(true);
                }
                else if(mobileNo.length()!=10){
                    mobileNoEt.setError("please Enter Correct Mobile Number");
                    mobileNoEt.setFocusable(true);
                }

                else if (individualCount>3) {
                    referID.setError(" Refer Id already full");
                    referID.setFocusable(true);
                }
                else if(!referidflag) {
                    referID.setError("Enter correct Refer Id");
                    referID.setFocusable(true);
                }
                 else
                if (password.length() < 8) {
                    passwordEt.setError("Password Length must be of 8 character");
                    passwordEt.setFocusable(true);
                }
                else{
                    String phonenumber ="+91"+mobileNo;
                    Intent intent = new Intent(RegisterActivity.this,VerifyPhoneActivity.class);
                    intent.putExtra("phonenumber",phonenumber);
                    intent.putExtra("name",name);
                    intent.putExtra("bankaccount",accountNumber);
                    intent.putExtra("ifsccode",ifsccode);
                    intent.putExtra("referid",referid);
                    intent.putExtra("activity","0");
                    intent.putExtra("level1",level1);
                    intent.putExtra("level2",level2);
                    intent.putExtra("level3",level3);
                    intent.putExtra("level4",level4);
                    intent.putExtra("level5",level5);
                    intent.putExtra("level6",level6);
                    intent.putExtra("level7",level7);
                    intent.putExtra("level8",level8);
                    intent.putExtra("account1",account1);
                    intent.putExtra("account2",account2);
                    intent.putExtra("account3",account3);
                    intent.putExtra("account4",account4);
                    intent.putExtra("account5",account5);
                    intent.putExtra("account6",account6);
                    intent.putExtra("account7",account7);
                    intent.putExtra("account8",account8);
                    intent.putExtra("account9",account9);
                    intent.putExtra("ifsc1",ifsc1);
                    intent.putExtra("ifsc2",ifsc2);
                    intent.putExtra("ifsc3",ifsc3);
                    intent.putExtra("ifsc4",ifsc4);
                    intent.putExtra("ifsc5",ifsc5);
                    intent.putExtra("ifsc6",ifsc6);
                    intent.putExtra("ifsc7",ifsc7);
                    intent.putExtra("ifsc8",ifsc8);
                    intent.putExtra("ifsc9",ifsc9);
                   // intent.putExtra("count",TotalCount);

                    intent.putExtra("name1",name1);
                    intent.putExtra("name2",name2);
                    intent.putExtra("name3",name3);
                    intent.putExtra("name4",name4);
                    intent.putExtra("name5",name5);
                    intent.putExtra("name6",name6);
                    intent.putExtra("name7",name7);
                    intent.putExtra("name8",name8);
                    intent.putExtra("name9",name9);

                    intent.putExtra("ownerid",ownerid);

                    startActivity(intent);

                }
            }
        });


    }
}
