package com.example.anuo.youdao.info;

import com.example.anuo.youdao.decoration.IData;
import com.example.anuo.youdao.decoration.RecycleItemTypeConstant;

public class InfoTwo implements IData {
    @Override
    public int typ() {
        return RecycleItemTypeConstant.RECYCLEVIEW_ITEM_TYPE_2;
    }

    private String title;
    private String mark;
    private int imgIdAd;

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

    public int getImgIdAd() {
        return imgIdAd;
    }

    public void setImgIdAd(int imgIdAd) {
        this.imgIdAd = imgIdAd;
    }
}
