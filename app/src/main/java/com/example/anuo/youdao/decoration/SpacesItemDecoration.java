package com.example.anuo.youdao.decoration;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space){
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if(parent.getChildAdapterPosition(view) == 0){
            outRect.left = 60;
            outRect.right = space;
            outRect.top = space;
            outRect.bottom = space;
        }else if(parent.getChildAdapterPosition(view) == 3){
            outRect.left = space;
            outRect.right = 60;
            outRect.top = space;
            outRect.bottom = space;
        }else{
            outRect.left = space;
            outRect.right = space;
            outRect.top = space;
            outRect.bottom = space;
        }
    }
}
