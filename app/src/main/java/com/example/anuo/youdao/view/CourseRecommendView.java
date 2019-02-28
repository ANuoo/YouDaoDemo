package com.example.anuo.youdao.view;

public class CourseRecommendView {
    private int imageId;
    private String ListTitle;
    private String ListName;
    private String ListNameMark;
    private String ListMark;

    public CourseRecommendView(int imageId,String ListTitle,String ListName,String ListNameMark,String ListMark){
        this.imageId = imageId;
        this.ListTitle = ListTitle;
        this.ListName = ListName;
        this.ListNameMark = ListNameMark;
        this.ListMark = ListMark;
    }

    public int getImageId() {
        return imageId;
    }

    public String getListTitle() {
        return ListTitle;
    }

    public String getListName() {
        return ListName;
    }

    public String getListNameMark() {
        return ListNameMark;
    }

    public String getListMark() {
        return ListMark;
    }
}
