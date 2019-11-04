package com.example.networkmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class OwnerDashboardActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser user;
    String mUID;
    Button mygroupbtn;
    FirebaseDatabase database;
    DatabaseReference reference;
    String referid;
    String phonenumber;
    String success="success";
    TextView Level2,Level3,Level4,Level5,Level8,Level6,Level7,Level9,mylayer;
    TextView Account2,Account3,Account4,Account5,Account6,Account7,Account8,Account9;
    TextView Ifsc2,Ifsc3,Ifsc4,Ifsc5,Ifsc6,Ifsc7,Ifsc8,Ifsc9,TotalCount;
    TextView Name2,Name3,Name4,Name5,Name6,Name7,Name8,Name9;
    int count;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.ownermenu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.logout:
                mAuth.signOut();
                checkUser();
                return   true;
            case R.id.requests:
                Intent intent2 = new Intent(this,RequestActivity.class);
                startActivity(intent2);
                return true;
            default:
                return false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mAuth =FirebaseAuth.getInstance();
        mygroupbtn =findViewById(R.id.mygroupBtn);
        Level2=findViewById(R.id.Level2Tv);
        Level3=findViewById(R.id.Level3Tv);
        Level4=findViewById(R.id.Level4Tv);
        Level5=findViewById(R.id.Level5Tv);
        Level6=findViewById(R.id.Level6Tv);
        Level7=findViewById(R.id.Level7Tv);
        Level8=findViewById(R.id.Level8Tv);
        Level9 = findViewById(R.id.Level9Tv);


        Account2=findViewById(R.id.account2Tv);
        Account3=findViewById(R.id.account3Tv);
        Account4=findViewById(R.id.account4Tv);
        Account5=findViewById(R.id.account5Tv);
        Account6=findViewById(R.id.account6Tv);
        Account7=findViewById(R.id.account7Tv);
        Account8=findViewById(R.id.account8Tv);
        Account9 = findViewById(R.id.account9Tv);


        Ifsc2=findViewById(R.id.ifsc2Tv);
        Ifsc3=findViewById(R.id.ifsc3Tv);
        Ifsc4=findViewById(R.id.ifsc4Tv);
        Ifsc5=findViewById(R.id.ifsc5Tv);
        Ifsc6=findViewById(R.id.ifsc6Tv);
        Ifsc7=findViewById(R.id.ifsc7Tv);
        Ifsc8=findViewById(R.id.ifsc8Tv);
        Ifsc9 = findViewById(R.id.ifsc9Tv);

        Name2=findViewById(R.id.Name2Tv);
        Name3=findViewById(R.id.Name3Tv);
        Name4=findViewById(R.id.Name4Tv);
        Name5=findViewById(R.id.Name5Tv);
        Name6=findViewById(R.id.Name6Tv);
        Name7=findViewById(R.id.Name7Tv);
        Name8=findViewById(R.id.Name8Tv);
        Name9 = findViewById(R.id.Name9Tv);

        mylayer=findViewById(R.id.mylayer);


        database = FirebaseDatabase.getInstance();

        checkUser();
        reference= database.getReference("Teams");
        reference.keepSynced(true);
        if(phonenumber!=null) {

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        if (phonenumber.equals(ds.child("MobileNumber").getValue())) {



                             String name= ""+ds.child("name").getValue();

                            String level2 = "" + ds.child("level2").getValue();
                            String level3 = "" + ds.child("level3").getValue();
                            String level4 = "" + ds.child("level4").getValue();
                            String level5 = "" + ds.child("level5").getValue();
                            String level6 = "" + ds.child("level6").getValue();
                            String level7 = "" + ds.child("level7").getValue();
                            String level8 = "" + ds.child("level8").getValue();
                            String level9 = "" + ds.child("level9").getValue();

                            Level2.setText(level2);
                            Level3.setText(level3);
                            Level4.setText(level4);
                            Level5.setText(level5);
                            Level6.setText(level6);
                            Level7.setText(level7);
                            Level8.setText(level8);
                            Level9.setText(level9);


                            String account2 = "" + ds.child("account2").getValue();
                            String account3 = "" + ds.child("account3").getValue();
                            String account4 = "" + ds.child("account4").getValue();
                            String account5 = "" + ds.child("account5").getValue();
                            String account6 = "" + ds.child("account6").getValue();
                            String account7 = "" + ds.child("account7").getValue();
                            String account8 = "" + ds.child("account8").getValue();
                            String account9 = "" + ds.child("account9").getValue();


                            Account2.setText(account2);
                            Account3.setText(account3);
                            Account4.setText(account4);
                            Account5.setText(account5);
                            Account6.setText(account6);
                            Account7.setText(account7);
                            Account8.setText(account8);
                            Account9.setText(account9);


                            String ifsc2= "" + ds.child("ifsc2").getValue();
                            String ifsc3 = "" + ds.child("ifsc3").getValue();
                            String ifsc4= "" + ds.child("ifsc4").getValue();
                            String ifsc5 = "" + ds.child("ifsc5").getValue();
                            String ifsc6 = "" + ds.child("ifsc6").getValue();
                            String ifsc7 = "" + ds.child("ifsc7").getValue();
                            String ifsc8 = "" + ds.child("ifsc8").getValue();
                            String ifsc9 = "" + ds.child("ifsc9").getValue();


                            Ifsc2.setText(ifsc2);
                            Ifsc3.setText(ifsc3);
                            Ifsc4.setText(ifsc4);
                            Ifsc5.setText(ifsc5);
                            Ifsc6.setText(ifsc6);
                            Ifsc7.setText(ifsc7);
                            Ifsc8.setText(ifsc8);
                            Ifsc9.setText(ifsc9);

                            String name2 =""+ds.child("name2").getValue();
                            String name3 =""+ds.child("name3").getValue();
                            String name4 =""+ds.child("name4").getValue();
                            String name5 =""+ds.child("name5").getValue();
                            String name6 =""+ds.child("name6").getValue();
                            String name7 =""+ds.child("name7").getValue();
                            String name8 =""+ds.child("name8").getValue();
                            String name9 =""+ds.child("name9").getValue();


                            Name2.setText(name2);
                            Name3.setText(name3);
                            Name4.setText(name4);
                            Name5.setText(name5);
                            Name6.setText(name6);
                            Name7.setText(name7);
                            Name8.setText(name8);
                            Name9.setText(name9);

                            mylayer.setText(name);






                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            mygroupbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(OwnerDashboardActivity.this,ChildActivity.class);
                    intent.putExtra("phone",phonenumber);
                    startActivity(intent);
                }
            });


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUser();
    }


    @Override
    protected void onStart() {
        checkUser();
        super.onStart();
    }
    private void checkUser(){
        user=mAuth.getCurrentUser();
        if(user!=null){
            mUID=user.getUid();
            phonenumber =user.getPhoneNumber();

        }else{
            Toast.makeText(this,"Logged out",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(OwnerDashboardActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
