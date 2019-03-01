package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.DictionaryFollowView;
import com.example.anuo.youdao.R;

import java.util.List;

public class DictionaryFollowAdapter extends RecyclerView.Adapter<DictionaryFollowAdapter.ViewHolder> {
    private Context context;
    private List<DictionaryFollowView> list;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textTitleMark;
        TextView textnumber;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.img_dictionary_follow);
            textTitle = (TextView) view.findViewById(R.id.txt_dictionary_follow_title);
            textTitleMark = (TextView) view.findViewById(R.id.txt_dictionary_follow_title_mark);
            textnumber = (TextView) view.findViewById(R.id.txt_dictionary_follow_number);
        }
    }

    public DictionaryFollowAdapter(Context context, List<DictionaryFollowView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.dictionary_recycleview_follow_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DictionaryFollowView dictionaryFollowView = list.get(i);
        viewHolder.imageView.setImageResource(dictionaryFollowView.getImageId());
        viewHolder.textTitle.setText(dictionaryFollowView.getTitle());
        viewHolder.textTitleMark.setText(dictionaryFollowView.getTitleMark());
        viewHolder.textnumber.setText(dictionaryFollowView.getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
