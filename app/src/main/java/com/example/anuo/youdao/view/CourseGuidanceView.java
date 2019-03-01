package com.example.anuo.youdao.view;

public class CourseGuidanceView {
    private int imageId;
    private String title;
    private String mark;

    public CourseGuidanceView(int imageId, String title, String mark) {
        this.imageId = imageId;
        this.title = title;
        this.mark = mark;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getMark() {
        return mark;
    }
}
