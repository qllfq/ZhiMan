package com.example.qiaolulu.fangqi;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class DialogSelector extends Dialog{
    private Context mContext;
    private List<DialogBean> mList = new ArrayList<DialogBean>();
    private DialogAdapter dialogAdapter;
    private RecyclerView recyclerView;
    private OnDialogClickListener listener;
    public DialogSelector(@NonNull Context context, List<DialogBean> list,OnDialogClickListener listener) {
        super(context);
        this.mContext = context;
        this.mList = list;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_member);
         Window window = getWindow();
         window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
        this.setCancelable(true);

    }

    /**
     * 为dialog添加监听，接口回调
     * 在这里定义接口，然后activity实现接口方法，将接口对象传递过来，
     * 在adapter中使用监听对象随时给listener传递bitmap值
     */
    @Override
    protected void onStart() {
        super.onStart();
        dialogAdapter = new DialogAdapter(mContext,mList);
        dialogAdapter.setOnItemClickListener(new DialogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                DialogBean dia= mList.get(position);
                Bitmap bitmap = dia.getBitmap();
                listener.getBitmap(bitmap);
                dismiss();

            }
        });

        GridLayoutManager layoutManager = new GridLayoutManager(mContext,3);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dialogAdapter);

    }

    /**
     * 定义接口，传值给activity
     */

    public interface OnDialogClickListener{
        void getBitmap(Bitmap bitmap);
    }
}
