package com.example.qiaolulu.fangqi;

import android.graphics.Bitmap;

public class DialogBean {
    Bitmap bitmap;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public DialogBean(Bitmap bitmap, String name) {
        this.bitmap = bitmap;
        this.name = name;
    }

   /* public DialogBean(String name) {
        this.name = name;
    }*/
}
