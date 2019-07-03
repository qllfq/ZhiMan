package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        imageView = findViewById(R.id.imageContent);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        int[] workarray = intent.getIntArrayExtra("workarray");
        if(workarray==null){
            imageView.setImageResource(position);
        }else {
            imageView.setImageResource(workarray[position]);
        }


    }

    @Override
    public void onClick(View v) {
        ContentActivity.this.finish();
    }
}
