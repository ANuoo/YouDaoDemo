package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.DictionaryTodayView;
import com.example.anuo.youdao.R;

import java.util.List;

public class DictionaryTodayAdapter extends RecyclerView.Adapter<DictionaryTodayAdapter.ViewHolder> {
    private Context context;
    private List<DictionaryTodayView> list;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textTitleMark;
        TextView textNum;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.img_dictionary_recommend_today);
            textTitle = (TextView) view.findViewById(R.id.txt_dictionary_recommend_today_card_title);
            textTitleMark = (TextView) view.findViewById(R.id.txt_dictionary_recommend_today_card_title_mark);
            textNum = (TextView) view.findViewById(R.id.txt_dictionary_recommend_today_card_number);
        }
    }

    public DictionaryTodayAdapter(Context context, List<DictionaryTodayView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.dictionary_recommend_recycleview_tody, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DictionaryTodayView dictionaryTodayView = list.get(i % list.size());
        viewHolder.imageView.setImageResource(dictionaryTodayView.getImgId());
        viewHolder.textTitle.setText(dictionaryTodayView.getTitle());
        viewHolder.textTitleMark.setText(dictionaryTodayView.getTitleMark());
        viewHolder.textNum.setText(dictionaryTodayView.getNumber());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
