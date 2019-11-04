package com.example.networkmarketing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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

public class LoginActivity extends AppCompatActivity {
    EditText phoneEt;
    Button loginBtn;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    TextView notRegisterTv;
    Boolean notregister=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneEt = findViewById(R.id.phoneEt);

        loginBtn = findViewById(R.id.loginBtn);


        notRegisterTv=findViewById(R.id.notRegisterTv);
        progressDialog = new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneEt.getText().toString().trim();
//                String password = passwordEt.getText().toString().trim();
                if (!Patterns.PHONE.matcher(phone).matches()) {
                    phoneEt.setError("Invalid Phone Number");
                    phoneEt.setFocusable(true);
                }
                else if(phone.length()!=10){
                    phoneEt.setError("rPhone number length must be of 10 digits");
                    phoneEt.setFocusable(true);
                }else {
                    final String phonenumber ="+91"+phone;
                    FirebaseDatabase mDatabase= FirebaseDatabase.getInstance();
                    DatabaseReference mReference =mDatabase.getReference("Users");
                    mReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds:dataSnapshot.getChildren()){
                                progressDialog.setMessage("Checking...");
                                progressDialog.show();
                                if(phonenumber.equals(ds.child("MobileNumber").getValue())){
                                    progressDialog.setMessage("Verified");
                                    progressDialog.dismiss();
                                    Intent intent = new Intent(LoginActivity.this,VerifyPhoneActivity.class);
                                    notregister=false;
                                    intent.putExtra("phonenumber",phonenumber);
                                    intent.putExtra("activity","1");
                                    Log.d("error---","login wala macha raha");
                                    startActivity(intent);
                                    finish();

                                }
                            }
                             if(notregister){
                                if( progressDialog.isShowing()){
                                    progressDialog.dismiss();
                                }
                                Toast.makeText(LoginActivity.this,"Please register your account",Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(LoginActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });


                }

            }


        });

        notRegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
