package com.example.qiaolulu.fangqi;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BottomLayout extends LinearLayout{
    private int normalIcon;
    private int focusedIcon;



    private boolean isFocused;
    private ImageView ivIcon;
    private TextView tvText;

    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_layout,this);
        ivIcon = findViewById(R.id.bottom_icon);
        tvText = findViewById(R.id.bottom_text);
    }

    public void setNormalImage(int normalIcon){
        this.normalIcon = normalIcon;
        ivIcon.setImageResource(normalIcon);
    }
    public void setFocusedImage(int focusedIcon){
        this.focusedIcon = focusedIcon;
    }
    public void setTvText(String text){
        tvText.setText(text);
    }
    public void setFocused(boolean focused) {
        isFocused = focused;
        if(isFocused){
            ivIcon.setImageResource(focusedIcon);
            tvText.setTextColor(getResources().getColor(R.color.yellow));
        }else {
            ivIcon.setImageResource(normalIcon);
            tvText.setTextColor(Color.BLACK);
        }
    }
}
