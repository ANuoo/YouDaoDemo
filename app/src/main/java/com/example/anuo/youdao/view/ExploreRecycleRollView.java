package com.example.anuo.youdao.view;

public class ExploreRecycleRollView {
    private String sentence;
    private String sign;
    private int imgId;

    public ExploreRecycleRollView(String sentence, String sign, int imgId) {
        this.sentence = sentence;
        this.sign = sign;
        this.imgId = imgId;
    }

    public String getSentence() {
        return sentence;
    }

    public String getSign() {
        return sign;
    }

    public int getImgId() {
        return imgId;
    }
}
