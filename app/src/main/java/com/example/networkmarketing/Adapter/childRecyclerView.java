package com.example.networkmarketing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmarketing.R;
import com.example.networkmarketing.models.myChild;

import java.util.List;

public class childRecyclerView  extends  RecyclerView.Adapter<childRecyclerView.holder>{
    List<myChild> userlist;
    Context mContext;

    public childRecyclerView(List<myChild> userlist, Context mContext) {
        this.userlist = userlist;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.childrecyclerview,parent,false);
        return new childRecyclerView.holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String name =userlist.get(position).getName();
        String mobilenumber =userlist.get(position).getMobilenumber();
        String referer =userlist.get(position).getReferer();
        holder.Name.setText(name);
        holder.Phone.setText(mobilenumber);
        holder.referernumber.setText(referer);


    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public  class holder extends RecyclerView.ViewHolder{
        TextView Name,Phone,referernumber;

        public holder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.Name);
            Phone=itemView.findViewById(R.id.Phone);
            referernumber=itemView.findViewById(R.id.referernumber);
        }
    }
}
