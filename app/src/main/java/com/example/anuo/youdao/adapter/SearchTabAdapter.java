package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.view.SearchTabView;

import java.util.List;

public class SearchTabAdapter extends RecyclerView.Adapter<SearchTabAdapter.ViewHolder> {
    private Context context;
    private List<SearchTabView> list;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.txt_tab);
        }
    }

    public SearchTabAdapter(Context context,List<SearchTabView> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.search_recycleview_tab_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SearchTabView searchTabView = list.get(i);
        viewHolder.textView.setText(searchTabView.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

