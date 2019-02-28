package com.example.anuo.youdao.view;

public class ExploreRecycleView {
    private  String name;
    private  int imageId;

    public ExploreRecycleView(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
