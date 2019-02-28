package com.example.anuo.youdao.info;

import com.example.anuo.youdao.decoration.IData;
import com.example.anuo.youdao.decoration.RecycleItemTypeConstant;

public class InfoOne implements IData {
    @Override
    public int typ() {
        return RecycleItemTypeConstant.RECYCLEVIEW_ITEM_TYPE_1;
    }

    private String title;
    private String mark;
    private int imgIdOne;
    private int imgIdTwo;
    private int imgIdThree;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getImgIdOne() {
        return imgIdOne;
    }

    public void setImgIdOne(int imgIdOne) {
        this.imgIdOne = imgIdOne;
    }

    public int getImgIdTwo() {
        return imgIdTwo;
    }

    public void setImgIdTwo(int imgIdTwo) {
        this.imgIdTwo = imgIdTwo;
    }

    public int getImgIdThree() {
        return imgIdThree;
    }

    public void setImgIdThree(int imgIdThree) {
        this.imgIdThree = imgIdThree;
    }
}
