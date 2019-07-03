package com.example.qiaolulu.fangqi;

public class GuanZhuBean {
    private String name;
    private String time;
    private String title;
    private String content1;
    private String content2;
    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public GuanZhuBean(String name, String time, String title, String content1, String content2,int imageId) {
        this.name = name;
        this.time = time;
        this.title = title;
        this.content1 = content1;
        this.content2 = content2;
        this.imageId = imageId;
    }
}
