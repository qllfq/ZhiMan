package com.example.qiaolulu.fangqi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import multitouch.MoveGestureDetector;
import multitouch.RotateGestureDetector;

public class Finger extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;

    int t;
    int l;
    int width;
    int height;
    private Bitmap mBitmap;
    private Button save;
    private ImageView person;
    private ImageView picture;
    private ImageView talk;
    private ImageView pen;
    private ImageView paper;
    private int[] persons = {R.drawable.fingerone,R.drawable.fingertwo,
            R.drawable.fingerthree,R.drawable.fingerfour,R.drawable.fingerfive,R.drawable.fingersix,
            R.drawable.fingerseven,R.drawable.fingereight,R.drawable.fingernine};
    private int[] pictures = {R.drawable.fingerone,R.drawable.fingertwo,
            R.drawable.fingerthree,R.drawable.fingerfour,R.drawable.fingerfive,R.drawable.fingersix,
            R.drawable.fingerseven,R.drawable.fingereight,R.drawable.fingernine};
    private int[] talks = {R.drawable.paowu,R.drawable.pop2,
            R.drawable.pop3,R.drawable.pop4,R.drawable.pop5,R.drawable.paoba,
            R.drawable.paof,R.drawable.paoliu,R.drawable.paoqi,R.drawable.paos,R.drawable.paosi,
            R.drawable.paot};
    private int[] pens = {R.drawable.fingerone,R.drawable.fingertwo,
            R.drawable.fingerthree,R.drawable.fingerfour,R.drawable.fingerfive,R.drawable.fingersix,
            R.drawable.fingerseven,R.drawable.fingereight,R.drawable.fingernine};
    private int[] papers = {R.drawable.paper2,R.drawable.paper3,
            R.drawable.paper4,R.drawable.paper5,R.drawable.paper6,R.drawable.paper7,
            R.drawable.paper8,R.drawable.paper9,R.drawable.paper10,R.drawable.paper11,
            R.drawable.paper12,R.drawable.paper13,R.drawable.paper14,R.drawable.paper15,
            R.drawable.paper16};
    private List<DialogBean> mList = new ArrayList<DialogBean>();
    private ImageView view;
    private Context mContext;
    public LinearLayout linear;
    private MoveGestureDetector mMoveGestureDetector;
    private RotateGestureDetector mRotateGestureDetector;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private float mRotationDegrees = 0.f;
    private View mView;
    DialogSelector.OnDialogClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);

        initView();
        initListener();
    }

    private void initView() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        save = findViewById(R.id.save);
        save.setOnClickListener(this);
        person = findViewById(R.id.person);
        picture = findViewById(R.id.picture);
        talk = findViewById(R.id.talk);
        pen = findViewById(R.id.pen);
        paper = findViewById(R.id.paper);
        linear = findViewById(R.id.linear);
        person.setOnClickListener(this);
        picture.setOnClickListener(this);
        talk.setOnClickListener(this);
        pen.setOnClickListener(this);
        paper.setOnClickListener(this);
        mContext = getApplicationContext();
        mMoveGestureDetector = new MoveGestureDetector(this,mSimpleOnMoveGestureListener);
        mRotateGestureDetector = new RotateGestureDetector(this,mSimpleOnRotateGestureListener);
        mScaleGestureDetector = new ScaleGestureDetector(this,mScaleGestureListener);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
    }
    private void initData(int[] arrayBean) {
        mList.clear();
        for (int i=0;i<arrayBean.length;i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),arrayBean[i]);
            DialogBean dialogBean = new DialogBean(bitmap,i+"");
            mList.add(dialogBean);

        }

    }
    public void initListener(){
        listener = new DialogSelector.OnDialogClickListener() {
            @Override
            public void getBitmap(Bitmap bitmap) {
                view = new ImageView(mContext);
                view.setImageBitmap(bitmap);
                mView = view;
                linear.addView(view);
                mBitmap = bitmap;
            }
        };
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person:
                initData(persons);
                DialogSelector dialogPerson = new DialogSelector(this,mList,listener);
                dialogPerson.show();
                break;
            case R.id.picture:
                initData(pictures);
                DialogSelector dialogPicture = new DialogSelector(this,mList,listener);
                dialogPicture.show();
                break;
            case R.id.talk:
                initData(talks);
                DialogSelector dialogTalk = new DialogSelector(this,mList,listener);
                dialogTalk.show();
                break;
            case R.id.pen:
                initData(pens);
                DialogSelector dialogPen = new DialogSelector(this,mList,listener);
                dialogPen.show();
                break;
            case R.id.paper:
                initData(papers);
                DialogSelector dialogPaper = new DialogSelector(this,mList,listener);
                dialogPaper.show();
                break;
            case R.id.save:

               /* Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.WHITE);
                canvas.drawBitmap(mBitmap,l,t,null);
                Intent intent = new Intent(Finger.this,ShowTest.class);
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte [] bitmapByte =baos.toByteArray();
                intent.putExtra("bitmap", bitmapByte);
                startActivity(intent);*/
                break;
            case R.id.back:
                Finger.this.finish();
                break;
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mMoveGestureDetector.onTouchEvent(event);
        mRotateGestureDetector.onTouchEvent(event);
        mScaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    /**
     * 移动手势检测

     */
    private float mOffsetX = 0;
    private float mOffsetY = 0;
    private float mLastX = 0;
    private float mLastY = 0;
    private MoveGestureDetector.SimpleOnMoveGestureListener mSimpleOnMoveGestureListener = new MoveGestureDetector.SimpleOnMoveGestureListener(){
        @Override
        public boolean onMove(MoveGestureDetector detector) {
            mOffsetX = detector.getFocusDelta().x+mLastX;
            mOffsetY = detector.getFocusDelta().y+mLastY;
            mView.setTranslationX(mOffsetX);
            mView.setTranslationY(mOffsetY);
            int[] location = new int[2];
            linear.getLocationOnScreen(location);
            l = location[0];
            t = location[1];
            Log.e("top",l+"");
            return super.onMove(detector);
        }

        @Override
        public void onMoveEnd(MoveGestureDetector detector) {
            mLastX = mOffsetX;
            mLastY = mOffsetY;
            int[] location = new int[2];
            linear.getLocationOnScreen(location);
            l = location[0];
            t = location[1];
            Log.e("top",l+"");
            super.onMoveEnd(detector);
        }

    };

    /**
     * 旋转手势检测
     */

    private RotateGestureDetector.SimpleOnRotateGestureListener mSimpleOnRotateGestureListener = new RotateGestureDetector.SimpleOnRotateGestureListener(){

        @Override
        public boolean onRotate(RotateGestureDetector detector) {
            mRotationDegrees = -detector.getRotationDegreesDelta()+mRotationDegrees;
            mRotationDegrees = mRotationDegrees % 360;
            mView.setRotation(mRotationDegrees);
            return true;
        }
    };

    /**
     * 缩放手势
     */

    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor  *= scaleGestureDetector.getScaleFactor();
            mView.setScaleX(mScaleFactor);
            mView.setScaleY(mScaleFactor);

            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

        }
    };




}
