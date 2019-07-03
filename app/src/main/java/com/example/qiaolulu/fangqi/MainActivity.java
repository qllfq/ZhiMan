package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirstPage firstPage;
    private Mine mine;
    private ImageView finger;
    BottomLayout firstPageLayout;
    BottomLayout mineLayout;
    FragmentManager fragmentManager;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        initView();
    }

    private void initView() {
        firstPageLayout = findViewById(R.id.firstpage);
        finger = findViewById(R.id.finger);
        finger.setOnClickListener(this);
        mineLayout = findViewById(R.id.mine);
        firstPageLayout.setFocusedImage(R.drawable.firstfocused);
        firstPageLayout.setNormalImage(R.drawable.firstnormal);
        mineLayout.setNormalImage(R.drawable.minenormal);
        mineLayout.setFocusedImage(R.drawable.minefocused);
        firstPageLayout.setFocused(true);
        firstPageLayout.setTvText("首页");
        mineLayout.setTvText("我的");
        mineLayout.setFocused(false);
        firstPageLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        frameLayout = findViewById(R.id.frameLayout_container);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        firstPage = new FirstPage();
        transaction.add(R.id.frameLayout_container,firstPage);
        transaction.commit();
        //Intent intent = new Intent(MainActivity.this,FirstPage.class);

    }

    @Override
    public void onClick(View v) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.firstpage:
                firstPageLayout.setFocused(true);
                mineLayout.setFocused(false);
                if(firstPage==null){
                    firstPage = new FirstPage();

                }
                transaction.replace(R.id.frameLayout_container,firstPage);
               // transaction.replace(R.id.)
                break;
            case R.id.finger:
                Intent intent = new Intent(MainActivity.this,Finger.class);
                startActivity(intent);
                break;
            case R.id.mine:
                firstPageLayout.setFocused(false);
                mineLayout.setFocused(true);
                if(mine==null){
                    mine = new Mine();

                }
                transaction.replace(R.id.frameLayout_container,mine);
                break;
        }
        transaction.commit();
    }
}
