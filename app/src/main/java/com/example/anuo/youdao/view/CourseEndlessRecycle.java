package com.example.anuo.youdao.view;

public class CourseEndlessRecycle {
    private int imgId;
    private String title;
    private String markTitle;
    private String mark;

    public CourseEndlessRecycle(int imgId,String title,String markTitle,String mark){
        this.imgId = imgId;
        this.title = title;
        this.markTitle = markTitle;
        this.mark = mark;
    }

    public int getImgId() {
        return imgId;
    }

    public String getTitle() {
        return title;
    }

    public String getMarkTitle() {
        return markTitle;
    }

    public String getMark() {
        return mark;
    }
}
