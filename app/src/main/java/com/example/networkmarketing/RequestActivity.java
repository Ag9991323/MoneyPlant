package com.example.networkmarketing;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmarketing.Adapter._request_recyclerview;
import com.example.networkmarketing.models.Request;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    DatabaseReference databaseReference;
    _request_recyclerview request_recycleview;
    RecyclerView recyclerView;
    List<Request> usersList;
    String mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        mPhone=mUser.getPhoneNumber();
        recyclerView=findViewById(R.id.recyclerView);
        databaseReference = FirebaseDatabase.getInstance().getReference("Requests");
        setupRecyclerView();
        usersList=new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(RequestActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setupRecyclerView() {
        databaseReference.child(mPhone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                 Request user =ds.getValue(Request.class);
                    try {
                        usersList.add(user);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                  request_recycleview= new _request_recyclerview(usersList,RequestActivity.this);
                    recyclerView.setAdapter(request_recycleview);

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
        Intent intent= new Intent(RequestActivity.this, OwnerDashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
