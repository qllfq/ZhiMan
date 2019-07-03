package com.example.qiaolulu.fangqi;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Person extends BottomSheetDialogFragment {

    private BottomSheetBehavior mBehavior;
    BottomSheetDialog dialog;
    //private Sucai[] sucais = {new Sucai(R.drawable.first),new Sucai(R.drawable.second)};
    private List<Sucai> sucaiList = new ArrayList<>();
    private static Sucai[] mSucais;
    private SucaiAdapter adapter;
    private CoordinatorLayout ll_bottom_sheet;
    private static CardView mll_bottom;
    private static Context mContext;

    public void doclick(View v)
    {
        //点击任意布局关闭
        mBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
    private SwipeDismissBehavior swipeDismissBehavior;

    public static Person getInstance(Context context,Sucai[] sucais) {
        mContext = context;
       mSucais = sucais;
        Person fragment = new Person();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sucai, container, false);
      int width = view.getWidth();
        int height = view.getHeight();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(width, height);
        swipeDismissBehavior = new SwipeDismissBehavior();
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipeDismissBehavior.setDragDismissDistance(0.5F);
        swipeDismissBehavior.setStartAlphaSwipeDistance(0F);
        swipeDismissBehavior.setEndAlphaSwipeDistance(0.5F);
        swipeDismissBehavior.setSensitivity(0);
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
        layoutParams.setBehavior(swipeDismissBehavior);
        view.setLayoutParams(layoutParams);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_test);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
      initWorks();
       // getData();
        adapter = new SucaiAdapter(sucaiList);
        recyclerView.setAdapter(adapter);
        Log.i("person","1111");

    }
    private void initWorks() {
        sucaiList.clear();
        for(int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(mSucais.length);
            sucaiList.add(mSucais[index]);
        }
    }

    public void getData(){
        Bundle bundle = getArguments();
        if(bundle != null){
            int[] per = bundle.getIntArray("person");
            for(int i=0;i<per.length;i++){
                Sucai sucai = new Sucai(i);
                sucaiList.add(sucai);
            }
        }
    }

}
