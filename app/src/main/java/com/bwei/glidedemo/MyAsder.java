package com.bwei.glidedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/3/14
 */


public class MyAsder extends RecyclerView.Adapter<MyAsder.MyViewHolder>{
    private List<Bean.DataBean> namelist;
    private Context context;
    public MyAsder(List<Bean.DataBean> namelist, Context context) {
        this.namelist = namelist;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder=new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text.setText(namelist.get(position).getTitle());
        Glide.with(context)
                .load(namelist.get(position).getUserImg())
                .into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return namelist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView imageview;
        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
             imageview = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }
}
