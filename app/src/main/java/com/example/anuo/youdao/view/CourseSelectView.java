package com.example.anuo.youdao.view;

public class CourseSelectView {
    private int imageId;
    private String titleMark;
    private String title;
    private String time;
    private String name;
    private String mark;

    public CourseSelectView(int imageId, String titleMark, String title, String time, String name, String mark) {
        this.imageId = imageId;
        this.title = title;
        this.titleMark = titleMark;
        this.time = time;
        this.name = name;
        this.mark = mark;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitleMark() {
        return titleMark;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }
}
