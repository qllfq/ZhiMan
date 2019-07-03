package com.example.qiaolulu.fangqi;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.PagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.astuetz.PagerSlidingTabStrip;

        import java.util.ArrayList;

public class FirstPage extends Fragment{
    PagerSlidingTabStrip pst;
    ViewPager viewPager;
    ArrayList<Fragment> fragments;
    ArrayList<String> titleDatas=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_page,null);
        pst = view.findViewById(R.id.firstpage_pst);
        viewPager = view.findViewById(R.id.firstpage_viewpager);
        fragments = new ArrayList<>();
        Tuijian tuijian = new Tuijian();
        Guanzhu guanzhu = new Guanzhu();
        Zuixin zuixin = new Zuixin();
        fragments.add(tuijian);
        fragments.add(guanzhu);
        fragments.add(zuixin);
        titleDatas.add("推荐");
        titleDatas.add("关注");
        titleDatas.add("最新");
        Log.i("tag","11111");
        FragmentManager fragmentManager = getChildFragmentManager();
        viewPager.setAdapter(new MyViewPageAdapter(fragmentManager,titleDatas,fragments));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                
            }

            @Override
            public void onPageSelected(int i) {
                updateTextStyle(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        viewPager.setCurrentItem(0);
        pst.setViewPager(viewPager);
        pst.setTextSize(50);
        return view;
    }
    private void updateTextStyle(int position) {
        LinearLayout tabsContainer = (LinearLayout) pst.getChildAt(0);
        for(int i=0; i< tabsContainer.getChildCount(); i++) {
            TextView textView = (TextView) tabsContainer.getChildAt(i);
            if(position == i) {
                textView.setTextSize(18);
                textView.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                textView.setTextSize(12);
                textView.setTextColor(getResources().getColor(R.color.transparent));
            }
        }

    }

}
