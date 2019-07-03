package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL;

public class Tuijian extends Fragment implements View.OnClickListener {

    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.lunbo2,
            R.drawable.lunbo3,
            R.drawable.lunbo4,
            R.drawable.lunbo5,
            R.drawable.ad

    };
    //存放图片的标题

    private LinearLayout law1;
    private LinearLayout law2;
    private ViewPagerAdapter madapter;
    private ScheduledExecutorService scheduledExecutorService;
    private LinearLayout marketLinear;
    private LinearLayout band;
    private LinearLayout box;
    private LinearLayout gonglue;
    Intent intent;
    private int[] workarray = {R.drawable.timg4,R.drawable.timg1,R.drawable.timg2,R.drawable.timg3,
            R.drawable.timg5,R.drawable.timg9,R.drawable.timg7,R.drawable.timg8,R.drawable.timg6};
    private Work[] works = {new Work(R.drawable.timg4),new Work(R.drawable.timg1),
            new Work(R.drawable.timg2),new Work(R.drawable.timg3),
            new Work(R.drawable.timg5),new Work(R.drawable.timg6)
            ,new Work(R.drawable.timg7),new Work(R.drawable.timg8),
            new Work(R.drawable.timg9)};
    private List<Work> workList = new ArrayList<>();
    private WorkAdapter adapter;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.tuijian,null);
        band = view.findViewById(R.id.band);
        box = view.findViewById(R.id.box);
        gonglue = view.findViewById(R.id.light);
        gonglue.setOnClickListener(this);
        box.setOnClickListener(this);
        band.setOnClickListener(this);
        initWorks();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager,VERTICAL);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,  StaggeredGridLayoutManager.VERTICAL));
        adapter = new WorkAdapter(workList);
        adapter.setOnItemClickListener(new WorkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               Intent intent = new Intent(getActivity(),ContentActivity.class);
               intent.putExtra("position",position);
               intent.putExtra("workarray",workarray);
               startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        marketLinear = view.findViewById(R.id.market);
        marketLinear.setOnClickListener(this);




        mViewPaper = (ViewPager)view.findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }




        madapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(madapter);
        return view;
    }



    public  class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub

            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }
    };
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }

    }



    private void initWorks() {
        workList.clear();
        for(int i=0;i<workarray.length;i++){
            Work work = new Work(workarray[i]);
            workList.add(work);
           /* Random random = new Random();
            int index = random.nextInt(works.length);
            workList.add(works[index]);*/
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.market:
              intent = new Intent(getActivity(),Market.class);
              startActivity(intent);
              break;
            case R.id.band:
                intent = new Intent(getActivity(),Band.class);
                startActivity(intent);
                break;
            case R.id.box:
                intent = new Intent(getActivity(),Box.class);
                startActivity(intent);
                break;
            case R.id.light:
                intent = new Intent(getActivity(),Gonglue.class);
                startActivity(intent);
                break;
        }
    }
}




