package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Purches extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purches);
        Intent intent = getIntent();
        imageView = findViewById(R.id.commodity);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        int[] sucai = intent.getIntArrayExtra("sucai");
        int position = intent.getIntExtra("position",0);
        imageView.setImageResource(sucai[position]);

    }

    @Override
    public void onClick(View v) {
        Purches.this.finish();
    }
}
