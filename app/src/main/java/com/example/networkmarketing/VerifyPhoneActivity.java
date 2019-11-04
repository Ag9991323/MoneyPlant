package com.example.networkmarketing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class VerifyPhoneActivity extends AppCompatActivity {

    private String VerificationId;
    Button submitBtn;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private EditText  codes;
    String phonenumber;
    String name;
    String bankaccount;
    String ifsccode;
    String referid;
    String isLogin;
    String ownerid;
    boolean check=true;
    FirebaseUser user;
    String level1,level2,level3,level4,level5,level6,level7,level8;
    String account1,account2,account3,account4,account5,account6,account7,account8,account9;
    String ifsc1,ifsc2,ifsc3,ifsc4,ifsc5,ifsc6,ifsc7,ifsc8,ifsc9,TotalCount;
    String name1,name2,name3,name4,name5,name6,name7,name8,name9;
    ArrayList<String> ownerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);
        submitBtn = findViewById(R.id.submitBtn);
        mAuth = FirebaseAuth.getInstance();
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


        progressDialog = new ProgressDialog(this);
        codes = findViewById(R.id.CodeEt);

        Log.d("error","again1");

       isLogin = getIntent().getStringExtra("activity");
       if(isLogin.equals("0")){
           Log.d("error--","again3");
           phonenumber =getIntent().getStringExtra("phonenumber");
           name =getIntent().getStringExtra("name");

           bankaccount =getIntent().getStringExtra("bankaccount");
           referid ="+91"+getIntent().getStringExtra("referid");
           ifsccode =getIntent().getStringExtra("ifsccode");
           level1 = getIntent().getStringExtra("level1");
           level2 = getIntent().getStringExtra("level2");
           level3 = getIntent().getStringExtra("level3");
           level4 = getIntent().getStringExtra("level4");
           level5 = getIntent().getStringExtra("level5");
           level6 = getIntent().getStringExtra("level6");
           level7 = getIntent().getStringExtra("level7");
           level8 = getIntent().getStringExtra("level8");

           account1 = getIntent().getStringExtra("account1");
           account2 = getIntent().getStringExtra("account2");
           account3 = getIntent().getStringExtra("account3");
           account4 = getIntent().getStringExtra("account4");
           account5 = getIntent().getStringExtra("account5");
           account6 = getIntent().getStringExtra("account6");
           account7 = getIntent().getStringExtra("account7");
           account8 = getIntent().getStringExtra("account8");
           account9 = getIntent().getStringExtra("account9");

           ifsc1 = getIntent().getStringExtra("ifsc1");
           ifsc2 = getIntent().getStringExtra("ifsc2");
           ifsc3 = getIntent().getStringExtra("ifsc3");
           ifsc4 = getIntent().getStringExtra("ifsc4");
           ifsc5 = getIntent().getStringExtra("ifsc5");
           ifsc6 = getIntent().getStringExtra("ifsc6");
           ifsc7 = getIntent().getStringExtra("ifsc7");
           ifsc8 = getIntent().getStringExtra("ifsc8");
           ifsc9 = getIntent().getStringExtra("ifsc9");

           name1 = getIntent().getStringExtra("name1");
           name2 = getIntent().getStringExtra("name2");
           name3 = getIntent().getStringExtra("name3");
           name4 = getIntent().getStringExtra("name4");
           name5 = getIntent().getStringExtra("name5");
           name6 = getIntent().getStringExtra("name6");
           name7 = getIntent().getStringExtra("name7");
           name8 = getIntent().getStringExtra("name8");
           name9 = getIntent().getStringExtra("name9");



           ownerid=getIntent().getStringExtra("ownerid");

          TotalCount = getIntent().getStringExtra("count");
           sendVerificationCode(phonenumber);



       }
       else if(isLogin.equals("1")){
           Log.d("error--","again2");
           phonenumber =getIntent().getStringExtra("phonenumber");
           sendVerificationCode(phonenumber);
       }

        Log.d("error--","1");
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Checking...");
                progressDialog.show();
                String code =codes.getText().toString().trim();
                Log.d("error--","2");
                if(code.length()<6){
                    codes.setError("Enter Correct Code");
                    codes.setFocusable(true);
                    return;
                }
                Log.d("error--","3");
                verifyCode(code);

            }
        });

    }
    private void verifyCode(String code){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }

        Log.d("error--","4");
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(VerificationId,code);
        Log.d("error--","5");
        signInWithCredential(credential);
        Log.d("error--","6");
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        Log.d("error--","7");

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        progressDialog.dismiss();
                       if(task.isSuccessful()) {
                           if (isLogin.equals(String.valueOf(0))) {
                               FirebaseUser user = mAuth.getCurrentUser();
                               final String uid = user.getUid();
                               HashMap<String, Object> hashMap = new HashMap<>();
                               hashMap.put("uid", uid);
                               hashMap.put("MobileNumber", phonenumber);
                               hashMap.put("name", name);
                               hashMap.put("referid", referid);
                               hashMap.put("bankaccount", bankaccount);
                               hashMap.put("ifsccode", ifsccode);
                               hashMap.put("payment", "pending");

                               FirebaseDatabase database = FirebaseDatabase.getInstance();
                               final DatabaseReference reference = database.getReference("Users");
                               reference.child(phonenumber).setValue(hashMap);

                               HashMap<String, Object> hashMap2 = new HashMap<>();
                               hashMap2.put("mobilenumber", phonenumber);
                               hashMap2.put("myaccount", bankaccount);
                               hashMap2.put("myifsc", ifsccode);
                               hashMap2.put("name", name);
                               hashMap2.put("level1", level1);
                               hashMap2.put("level2", level2);
                               hashMap2.put("level3", level3);
                               hashMap2.put("level4", level4);
                               hashMap2.put("level5", level5);
                               hashMap2.put("level6", level6);
                               hashMap2.put("level7", level7);
                               hashMap2.put("level8", level8);
                               hashMap2.put("level9", referid);
                               hashMap2.put("ownerid", ownerid);

                               hashMap2.put("account1", account1);
                               hashMap2.put("account2", account2);
                               hashMap2.put("account3", account3);
                               hashMap2.put("account4", account4);
                               hashMap2.put("account5", account5);
                               hashMap2.put("account6", account6);
                               hashMap2.put("account7", account7);
                               hashMap2.put("account8", account8);
                               hashMap2.put("account9", account9);

                               hashMap2.put("ifsc1", ifsc1);
                               hashMap2.put("ifsc2", ifsc2);
                               hashMap2.put("ifsc3", ifsc3);
                               hashMap2.put("ifsc4", ifsc4);
                               hashMap2.put("ifsc5", ifsc5);
                               hashMap2.put("ifsc6", ifsc6);
                               hashMap2.put("ifsc7", ifsc7);
                               hashMap2.put("ifsc8", ifsc8);
                               hashMap2.put("ifsc9", ifsc9);

                               hashMap2.put("name1", name1);
                               hashMap2.put("name2", name2);
                               hashMap2.put("name3", name3);
                               hashMap2.put("name4", name4);
                               hashMap2.put("name5", name5);
                               hashMap2.put("name6", name6);
                               hashMap2.put("name7", name7);
                               hashMap2.put("name8", name8);
                               hashMap2.put("name9", name9);

                               DatabaseReference reference2 = database.getReference("Requests");
                               reference2.child(ownerid).child(phonenumber).setValue(hashMap2);
                               Toast.makeText(VerifyPhoneActivity.this, "Thank u we have recieved ur request place wait some time and then try to login the system", Toast.LENGTH_LONG).show();
                               mAuth.signOut();
                               Intent intent = new Intent(VerifyPhoneActivity.this, MainActivity.class);
                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                               startActivity(intent);


                           }
                           else{


                                   FirebaseDatabase database = FirebaseDatabase.getInstance();
                                   DatabaseReference user = database.getReference("Users/" + phonenumber);
                                   user.addValueEventListener(new ValueEventListener() {
                                       @Override
                                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                           String payment = "" + dataSnapshot.child("payment").getValue();
                                           if (payment.equals("success")) {
                                               if (ownerlist.contains(phonenumber)) {
                                                   Intent intent = new Intent(VerifyPhoneActivity.this, OwnerDashboardActivity.class);
                                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                   startActivity(intent);

                                               } else {
                                                   Log.d("error--", "yaha se dashboard gaya");
                                                   Intent intent = new Intent(VerifyPhoneActivity.this, Dashboard.class);
                                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                   startActivity(intent);

                                               }

                                           } else {
                                               Toast.makeText(VerifyPhoneActivity.this, "Your status is pending please deposit Registration Fee", Toast.LENGTH_LONG).show();
                                               mAuth.signOut();
                                               Intent intent = new Intent(VerifyPhoneActivity.this, MainActivity.class);
                                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                               startActivity(intent);
                                           }
                                       }

                                       @Override
                                       public void onCancelled(@NonNull DatabaseError databaseError) {
                                           Toast.makeText(VerifyPhoneActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                                       }
                                   });



                           }
                           }
                       else{
                               Toast.makeText(VerifyPhoneActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           }

                    }
                });

    }

    private void sendVerificationCode(String number){
        progressDialog.setMessage("Sending...");
        progressDialog.show();
        Log.d("error--","final1");
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
        Log.d("error--","final2");
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s,forceResendingToken);
            VerificationId =s;
            progressDialog.dismiss();



        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            if(isLogin.equals("0")){
                String code =phoneAuthCredential.getSmsCode();
                if(code !=null){
                    codes.setText(code);
                    verifyCode(code);

                }
            }
            if(isLogin.equals("1")){
                signInWithCredential(phoneAuthCredential);
            }





        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            progressDialog.dismiss();
            Toast.makeText(VerifyPhoneActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };
    private void checkUser(){
        user=mAuth.getCurrentUser();
        if(user!=null){
            mAuth.signOut();
            checkUser();

        }else{
            Toast.makeText(this,"Logged out",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(VerifyPhoneActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

    }
}
