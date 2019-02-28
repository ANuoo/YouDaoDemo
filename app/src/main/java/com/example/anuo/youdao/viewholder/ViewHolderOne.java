package com.example.anuo.youdao.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.decoration.IData;
import com.example.anuo.youdao.info.InfoOne;
import com.example.anuo.youdao.R;

public class ViewHolderOne extends BaseViewHolder {
    private TextView textTitle;
    private TextView textMark;
    private ImageView imageOne;
    private ImageView imageTwo;
    private ImageView imageThree;

    public ViewHolderOne(View itemView){
        super(itemView);
        textTitle = (TextView)itemView.findViewById(R.id.txt_dictionary_recommend_title);
        textMark = (TextView)itemView.findViewById(R.id.txt_dictionary_recommend_mark);
        imageOne = (ImageView)itemView.findViewById(R.id.img_dictionary_recommend_picture_one);
        imageTwo = (ImageView)itemView.findViewById(R.id.img_dictionary_recommend_picture_two);
        imageThree = (ImageView)itemView.findViewById(R.id.img_dictionary_recommend_picture_three);

    }

    @Override
    public void FillView(IData data) {
        super.FillView(data);
        if(data instanceof InfoOne){
            textTitle.setText(((InfoOne)data).getTitle());
            textMark.setText(((InfoOne)data).getMark());
            imageOne.setImageResource(((InfoOne)data).getImgIdOne());
            imageTwo.setImageResource(((InfoOne)data).getImgIdTwo());
            imageThree.setImageResource(((InfoOne)data).getImgIdThree());
        }
    }
}
