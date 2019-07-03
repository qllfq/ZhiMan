package com.example.qiaolulu.fangqi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

class MyViewPageAdapter extends FragmentPagerAdapter {
    private ArrayList<String> titleList;
    private ArrayList<Fragment> fragmentList;
    public MyViewPageAdapter(FragmentManager fm, ArrayList<String> titleList,ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
