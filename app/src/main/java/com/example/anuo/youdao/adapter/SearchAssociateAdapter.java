package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.view.SearchAssociate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAssociateAdapter extends RecyclerView.Adapter<SearchAssociateAdapter.ViewHolder> {
    private List<SearchAssociate> list = new ArrayList<SearchAssociate>();
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textEnter;
        TextView textExplain;

        public ViewHolder(View view){
            super(view);
            textEnter = (TextView)view.findViewById(R.id.txt_search_associate_enter);
            textExplain = (TextView)view.findViewById(R.id.txt_search_associate_explain);
        }
    }
   public SearchAssociateAdapter(List<SearchAssociate> list,Context context){
        this.list = list;
        this.context = context;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_recycleview_associate_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SearchAssociate searchAssociate = list.get(i);
        viewHolder.textEnter.setText(searchAssociate.getEnter());
        viewHolder.textExplain.setText(searchAssociate.getExplain());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
