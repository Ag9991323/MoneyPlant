package com.example.networkmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmarketing.Adapter.childRecyclerView;
import com.example.networkmarketing.models.myChild;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class childShowActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    FirebaseUser mUser;
    DatabaseReference mReference;
    String phonenumber;
    childRecyclerView childrecyclerView;
    RecyclerView recyclerView;
    String group;
    List<myChild> usersList;
    ArrayList<String> ownerlist;
    TextView totalIncome;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_show);
        totalIncome=findViewById(R.id.totalIncome);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        phonenumber =mUser.getPhoneNumber();
        recyclerView=findViewById(R.id.recyclerView);
        group =getIntent().getStringExtra("groupnumber");
        mDatabase = FirebaseDatabase.getInstance();
        mReference=mDatabase.getReference("Teams/"+phonenumber);
        setupRecyclerView();
        usersList=new ArrayList<>();
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

        LinearLayoutManager layoutManager = new LinearLayoutManager(childShowActivity.this);
//        layoutManager.setReverseLayout(true);
//        layoutManager.setStackFromEnd(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


    }


    private void setupRecyclerView() {
        mReference.child(group).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(group.equals("myChild")){
                    count=(int)dataSnapshot.getChildrenCount()*200;
                    totalIncome.setText(String.valueOf(count));

                }
                else{
                    count=(int)dataSnapshot.getChildrenCount()*100;
                    totalIncome.setText(String.valueOf(count));

                }

                usersList.clear();

                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    myChild user =ds.getValue(myChild.class);
                    try {
                        usersList.add(user);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    childrecyclerView= new childRecyclerView(usersList,childShowActivity.this);
                    recyclerView.setAdapter(childrecyclerView);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(ownerlist.contains(phonenumber)){
            Intent intent= new Intent(childShowActivity.this, OwnerDashboardActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else{
            Intent intent= new Intent(childShowActivity.this, Dashboard.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}
