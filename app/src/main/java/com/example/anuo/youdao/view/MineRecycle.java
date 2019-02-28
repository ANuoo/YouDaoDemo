package com.example.anuo.youdao.view;

public class MineRecycle {
    private String name;
    private int imgId;
    private String mark;

    public MineRecycle(String name,int imgId,String mark){
        this.name = name;
        this.imgId = imgId;
        this.mark = mark;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }
}
