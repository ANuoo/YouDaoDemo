package com.example.anuo.youdao.view;

public class SearchAssociate {
    private String enter;
    private String explain;
    public SearchAssociate(String enter,String explain){
        this.enter = enter;
        this.explain = explain;
    }

    public String getEnter() {
        return enter;
    }

    public String getExplain() {
        return explain;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
