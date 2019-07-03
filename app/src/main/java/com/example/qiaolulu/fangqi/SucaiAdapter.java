package com.example.qiaolulu.fangqi;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class SucaiAdapter extends RecyclerView.Adapter<SucaiAdapter.ViewHolder> {
    private Context mContext;
    private List<Sucai> mSucaiList;
    //private List<Integer> height;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(mContext == null){
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.sucai_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Sucai sucai = mSucaiList.get(i);
        viewHolder.sucaiImage.setImageResource(sucai.getImageId());
        /*viewHolder.sucaiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClick(v,i);
                }
            }
        });*/
        Glide.with(mContext).load(sucai.getImageId()).into(viewHolder.sucaiImage);
    }

    @Override
    public int getItemCount() {
        return mSucaiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView sucaiImage;
        //TextView workName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            sucaiImage = itemView.findViewById(R.id.sucai_image);

        }
    }
    public SucaiAdapter(List<Sucai> sucaiList){
        mSucaiList = sucaiList;

    }



/*
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
*/


}








