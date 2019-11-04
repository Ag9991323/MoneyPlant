package com.example.networkmarketing.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmarketing.R;
import com.example.networkmarketing.models.Request;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

public class _request_recyclerview extends RecyclerView.Adapter <_request_recyclerview.holder>{
    List<Request> userlist;
    String userName;
    String userPhone;
    String userUid;
    String userEmail ;
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    DatabaseReference mRequest;
    DatabaseReference mUsers;
    DatabaseReference mTeams;
    Context mContext;

    ProgressDialog progressDialog;

    public _request_recyclerview(List<Request> userlist,Context context) {
        this.userlist = userlist;
        mAuth =FirebaseAuth.getInstance();
        this.mContext=context;
        mDatabase=FirebaseDatabase.getInstance();
        mRequest=mDatabase.getReference("Requests");
        mTeams=mDatabase.getReference("Teams");
        mUsers =mDatabase.getReference("Users");
        progressDialog=new ProgressDialog(mContext);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity__request_recyclerview,parent,false);
        return new holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final holder holder, int position) {
        final String Name = userlist.get(position).getName();
        final String Phone = userlist.get(position).getMobilenumber();
        final String bankaccount =userlist.get(position).getMyaccount();
        final String ifsccode =userlist.get(position).getMyifsc();
        final String account1=userlist.get(position).getAccount1();
        final String account2=userlist.get(position).getAccount2();
        final String account3=userlist.get(position).getAccount3();
        final String account4=userlist.get(position).getAccount4();
        final String account5=userlist.get(position).getAccount5();
        final String account6=userlist.get(position).getAccount6();
        final String account7=userlist.get(position).getAccount7();
        final String account8=userlist.get(position).getAccount8();
        final String account9=userlist.get(position).getAccount9();


        final String level1 =userlist.get(position).getLevel1();
        final String level2 =userlist.get(position).getLevel2();
        final String level3 =userlist.get(position).getLevel3();
        final String level4 =userlist.get(position).getLevel4();
        final String level5 =userlist.get(position).getLevel5();
        final String level6 =userlist.get(position).getLevel6();
        final String level7 =userlist.get(position).getLevel7();
        final String level8 =userlist.get(position).getLevel8();
        final String level9 =userlist.get(position).getLevel9();


        final String ifsc1= userlist.get(position).getIfsc1();
        final String ifsc2= userlist.get(position).getIfsc2();
        final String ifsc3= userlist.get(position).getIfsc3();
        final String ifsc4= userlist.get(position).getIfsc4();
        final String ifsc5= userlist.get(position).getIfsc5();
        final String ifsc6= userlist.get(position).getIfsc6();
        final String ifsc7= userlist.get(position).getIfsc7();
        final String ifsc8= userlist.get(position).getIfsc8();
        final String ifsc9= userlist.get(position).getIfsc9();


        final String name1 =userlist.get(position).getName1();
        final String name2 =userlist.get(position).getName2();
        final String name3 =userlist.get(position).getName3();
        final String name4 =userlist.get(position).getName4();
        final String name5 =userlist.get(position).getName5();
        final String name6 =userlist.get(position).getName6();
        final String name7 =userlist.get(position).getName7();
        final String name8 =userlist.get(position).getName8();
        final String name9 =userlist.get(position).getName9();

        final String ownerid= userlist.get(position).getOwnerid();


        holder.userName.setText(Name);
        holder.userPhone.setText(Phone);
        holder.acceptRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Accepting request...");
                progressDialog.show();
                final HashMap<String,Object> hashMap2=new HashMap<>();
                hashMap2.put("MobileNumber",Phone);
                hashMap2.put("myaccount",bankaccount);
                hashMap2.put("myifsc",ifsccode);
                hashMap2.put("name",Name);
                hashMap2.put("ownerid",ownerid);
                hashMap2.put("level1",level1);
                hashMap2.put("level2",level2);
                hashMap2.put("level3",level3);
                hashMap2.put("level4",level4);
                hashMap2.put("level5",level5);
                hashMap2.put("level6",level6);
                hashMap2.put("level7",level7);
                hashMap2.put("level8",level8);
                hashMap2.put("level9",level9);

                hashMap2.put("account1",account1);
                hashMap2.put("account2",account2);
                hashMap2.put("account3",account3);
                hashMap2.put("account4",account4);
                hashMap2.put("account5",account5);
                hashMap2.put("account6",account6);
                hashMap2.put("account7",account7);
                hashMap2.put("account8",account8);
                hashMap2.put("account9",account9);

                hashMap2.put("ifsc1",ifsc1);
                hashMap2.put("ifsc2",ifsc2);
                hashMap2.put("ifsc3",ifsc3);
                hashMap2.put("ifsc4",ifsc4);
                hashMap2.put("ifsc5",ifsc5);
                hashMap2.put("ifsc6",ifsc6);
                hashMap2.put("ifsc7",ifsc7);
                hashMap2.put("ifsc8",ifsc8);
                hashMap2.put("ifsc9",ifsc9);

                hashMap2.put("name1",name1);
                hashMap2.put("name2",name2);
                hashMap2.put("name3",name3);
                hashMap2.put("name4",name4);
                hashMap2.put("name5",name5);
                hashMap2.put("name6",name6);
                hashMap2.put("name7",name7);
                hashMap2.put("name8",name8);
                hashMap2.put("name9",name9);

                final HashMap<String,Object> hashMap3 =new HashMap<>();
                hashMap3.put("name",Name);
                hashMap3.put("mobilenumber",Phone);
                hashMap3.put("referer",level9);





//                mTeams.child(Phone).updateChildren(hashMap2).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        mTeams.child(level9).child("myChild").child(Phone).updateChildren(hashMap3).addOnSuccessListener(new OnSuccessListener<Void>() {
////                            @Override
////                            public void onSuccess(Void aVoid) {
////                                mUsers.child(Phone).child("payment").setValue("success");
////                                mRequest.child(ownerid).child(Phone).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
////                                    @Override
////                                    public void onSuccess(Void aVoid) {
////                                        holder.acceptRequest.setVisibility(View.GONE);
////                                        holder.declineRequest.setVisibility(View.GONE);
////                                        holder.userPhone.setVisibility(View.GONE);
////                                        holder.userName.setVisibility(View.GONE);
////                                        progressDialog.dismiss();
////                                    }
////                                });
////                            }
////                        });
////
////                    }
////                }).addOnFailureListener(new OnFailureListener() {
////                    @Override
////                    public void onFailure(@NonNull Exception e) {
////                        Toast.makeText(mContext,"Failed request",Toast.LENGTH_SHORT).show();
////                    }
////                });
                mTeams.child(Phone).updateChildren(hashMap2).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        mTeams.child(level9).child("myChild").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level8).child("Child2").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level7).child("Child3").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level6).child("Child4").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level5).child("Child5").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level4).child("Child6").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level3).child("Child7").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level2).child("Child8").child(Phone).updateChildren(hashMap3);
                        mTeams.child(level1).child("Child9").child(Phone).updateChildren(hashMap3).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                mUsers.child(Phone).child("payment").setValue("success");
                                mRequest.child(ownerid).child(Phone).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        holder.acceptRequest.setVisibility(View.GONE);
                                        holder.declineRequest.setVisibility(View.GONE);
                                        holder.userPhone.setVisibility(View.GONE);
                                        holder.userName.setVisibility(View.GONE);
                                        progressDialog.dismiss();
                                    }
                                });
                            }
                        });

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(mContext,"Failed request",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
       holder.declineRequest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              mRequest.child(ownerid).child(Phone).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                  @Override
                  public void onSuccess(Void aVoid) {
                      mUsers.child(Phone).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                          @Override
                          public void onSuccess(Void aVoid) {
                              holder.acceptRequest.setVisibility(View.GONE);
                              holder.declineRequest.setVisibility(View.GONE);
                              holder.userPhone.setVisibility(View.GONE);
                              holder.userName.setVisibility(View.GONE);
                              progressDialog.dismiss();
                          }
                      });

                  }
              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {
                      Toast.makeText(mContext,"Failed Request",Toast.LENGTH_SHORT).show();
                  }
              });
           }
       });
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        TextView userName,userPhone;
        Button acceptRequest;
        Button declineRequest;
        public holder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userPhone = itemView.findViewById(R.id.userPhone);
            acceptRequest= itemView.findViewById(R.id.AcceptBtn);
            declineRequest = itemView.findViewById(R.id.DeclineBtn);
        }
    }
}
