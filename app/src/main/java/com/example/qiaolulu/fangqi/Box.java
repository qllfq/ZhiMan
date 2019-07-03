package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Box extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private ImageView huodong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        back = findViewById(R.id.back);
        huodong = findViewById(R.id.huodong);
        huodong.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                Box.this.finish();
                break;
            case R.id.huodong:
                Intent intent = new Intent(Box.this,Huodong.class);
                startActivity(intent);
        }

    }
}
