package com.example.qiaolulu.fangqi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//先不要写尖括号中的内容，先实现RecyclerView.Adapter的方法

/**
 * 1.继承RecyclerView.Adapter,实现三个方法
 * 2.将RecyclerView.ViewHolder改为ViewHolder,创建内部类ViewHolder
 * 3.ViewHolder继承RecyclerView.ViewHolder,实现方法
 *
 *
 */
public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.MyViewHolder>{
    private List<DialogBean> mList = new ArrayList<DialogBean>();
    private Context mContext;

    public DialogAdapter(Context context,List<DialogBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext,R.layout.item_layout,null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int i) {
        DialogBean dialogBean = mList.get(i);
      //  viewHolder.name.setText(dialogBean.getName().toString());
        viewHolder.imageView.setImageBitmap(dialogBean.getBitmap());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(v,i);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        //TextView name;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           // name = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.pic);
        }
    }

    private  OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }
}
