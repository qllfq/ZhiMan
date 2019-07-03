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

import java.util.ArrayList;
import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {
    private Context mContext;
    private List<Work> mWorkList;
    private List<Integer> height;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(mContext == null){
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.work_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Work work = mWorkList.get(i);
       // viewHolder.workName.setText(work.getName());
        viewHolder.workImage.setImageResource(work.getImageId());
        viewHolder.workImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemClick(v,i);
                }
            }
        });
        ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
       // params.height = height.get(i);
        viewHolder.itemView.setLayoutParams(params);
        Glide.with(mContext).load(work.getImageId()).into(viewHolder.workImage);


    }

    @Override
    public int getItemCount() {
        return mWorkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView workImage;
       // TextView workName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            workImage = itemView.findViewById(R.id.work_image);
          //  workName = itemView.findViewById(R.id.work_name);
            int width = ((Activity) workImage.getContext()).getWindowManager().getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams params = workImage.getLayoutParams();
            //设置图片的相对于屏幕的宽高比
            params.width = width/2;
            params.height =  (int) (400 + Math.random() * 550) ;
            workImage.setLayoutParams(params);
        }
    }
    public WorkAdapter(List<Work> workList){
        mWorkList = workList;
        //getRandomHeight(mWorkList);
    }

    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
