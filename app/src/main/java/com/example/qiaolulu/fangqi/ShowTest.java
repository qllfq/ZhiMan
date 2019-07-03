package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowTest extends AppCompatActivity {
    private Bitmap bitmap;
    private byte [] bis;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_test);
        imageView = findViewById(R.id.imageShow);

        Intent intent=getIntent();
        if(intent !=null)
        {
            bis=intent.getByteArrayExtra("bitmap");
            bitmap= BitmapFactory.decodeByteArray(bis, 0, bis.length);
        }
        imageView.setImageBitmap(bitmap);
    }
    }

