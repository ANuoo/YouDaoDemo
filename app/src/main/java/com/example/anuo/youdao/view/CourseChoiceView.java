package com.example.anuo.youdao.view;

public class CourseChoiceView {
    private int imgId;
    private String name;

    public CourseChoiceView(int imgId,String name){
        this.imgId = imgId;
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }
}
