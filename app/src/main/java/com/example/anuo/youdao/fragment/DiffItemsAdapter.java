package com.example.anuo.youdao.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anuo.youdao.viewholder.BaseViewHolder;
import com.example.anuo.youdao.decoration.IData;
import com.example.anuo.youdao.R;
import com.example.anuo.youdao.decoration.RecycleItemTypeConstant;
import com.example.anuo.youdao.viewholder.ViewHolderOne;
import com.example.anuo.youdao.viewholder.ViewHolderTwo;

import java.util.List;

public class DiffItemsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<IData> listDatas;
    private Context mContext;

    public DiffItemsAdapter(Context context, List<IData> listDatas) {
        this.listDatas = listDatas;
        this.mContext = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BaseViewHolder viewHolder = null;
        switch (i) {
            case RecycleItemTypeConstant.RECYCLEVIEW_ITEM_TYPE_1:
                viewHolder = onCreateViewHolderOne(viewGroup);
                break;
            case RecycleItemTypeConstant.RECYCLEVIEW_ITEM_TYPE_2:
                viewHolder = onCreateViewHolderTwo(viewGroup);
                break;
            case RecycleItemTypeConstant.RECYCLEVIEW_ITEM_TYPE_3:
                break;
            default:
                viewHolder = onCreateDefaultViewHolder(viewGroup);
                break;
        }
        return viewHolder;
    }

    private BaseViewHolder onCreateDefaultViewHolder(ViewGroup viewGroup) {
        TextView textView = new TextView(mContext);
        BaseViewHolder holder = new BaseViewHolder(textView);
        return holder;
    }

    private BaseViewHolder onCreateViewHolderOne(ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.dictionary_recommend_recycleview_news, viewGroup, false);
        ViewHolderOne viewHolderOne = new ViewHolderOne(itemView);
        return viewHolderOne;
    }

    private BaseViewHolder onCreateViewHolderTwo(ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.dictionary_recommend_recycleview_advantage, viewGroup, false);
        ViewHolderTwo viewHolderTwo = new ViewHolderTwo(itemView);
        return viewHolderTwo;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        try {
            baseViewHolder.FillView(listDatas.get(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 0 || position > listDatas.size() - 1) {
            return -1;
        }
        return listDatas.get(position).typ();
    }
}
