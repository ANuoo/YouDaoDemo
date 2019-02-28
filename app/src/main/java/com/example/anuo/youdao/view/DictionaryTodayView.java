package com.example.anuo.youdao.view;

public class DictionaryTodayView {
    private int imgId;
    private String title;
    private String titleMark;
    private String number;

    public DictionaryTodayView(int imgId,String title,String titleMark,String number){
        this.imgId = imgId;
        this.title = title;
        this.titleMark = titleMark;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleMark() {
        return titleMark;
    }

    public String getNumber() {
        return number;
    }

    public int getImgId() {
        return imgId;
    }
}
