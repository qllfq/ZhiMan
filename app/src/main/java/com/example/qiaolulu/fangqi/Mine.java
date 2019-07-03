package com.example.qiaolulu.fangqi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

public class Mine extends Fragment {
    PagerSlidingTabStrip pst;
    ViewPager viewPager;
     ArrayList<Fragment> fragments;
     //声明pst的标题
    ArrayList<String> titleDatas=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine,null);
        pst= (PagerSlidingTabStrip)view.findViewById(R.id.pst);
        viewPager= (ViewPager)view.findViewById(R.id.pager);
        fragments = new ArrayList<>();
        Shoucang shoucang = new Shoucang();
        Me tuijian = new Me();
        Caogao caogao = new Caogao();
        fragments.add(tuijian);
        fragments.add(shoucang);
        fragments.add(caogao);
        titleDatas.add("我的");
        titleDatas.add("收藏");
        titleDatas.add("草稿");
        FragmentManager fragmentManager = getChildFragmentManager();
        viewPager.setAdapter(new MyViewPageAdapter(fragmentManager,titleDatas,fragments));
        viewPager.setCurrentItem(0);
        pst.setViewPager(viewPager);
        pst.setTextSize(40);
        return view;
    }


}
