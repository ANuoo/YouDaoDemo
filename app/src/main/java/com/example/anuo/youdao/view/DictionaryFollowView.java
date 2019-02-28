package com.example.anuo.youdao.view;

public class DictionaryFollowView {
    private int imageId;
    private String title;
    private String titleMark;
    private String number;

    public DictionaryFollowView(int imageId,String title,String titleMark,String number){
        this.imageId = imageId;
        this.title = title;
        this.titleMark = titleMark;
        this.number = number;
    }

    public int getImageId() {
        return imageId;
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
}
