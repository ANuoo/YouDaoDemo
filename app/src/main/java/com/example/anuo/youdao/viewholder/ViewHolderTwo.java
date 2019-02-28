package com.example.anuo.youdao.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.decoration.IData;
import com.example.anuo.youdao.info.InfoTwo;
import com.example.anuo.youdao.R;

public class ViewHolderTwo extends BaseViewHolder {
    private TextView textTitle;
    private TextView textMark;
    private ImageView imageAd;

    public ViewHolderTwo(View itemView){
        super(itemView);
        textTitle = (TextView)itemView.findViewById(R.id.txt_dictionary_recommend_ad_title);
        textMark = (TextView)itemView.findViewById(R.id.txt_dictionary_recommend_ad_mark);
        imageAd = (ImageView)itemView.findViewById(R.id.img_dictionary_recommend_picture_ad);

    }

    @Override
    public void FillView(IData data) {
        super.FillView(data);
        textTitle.setText(((InfoTwo)data).getTitle());
        textMark.setText(((InfoTwo)data).getMark());
        imageAd.setImageResource(((InfoTwo)data).getImgIdAd());
    }
}
