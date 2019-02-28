package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.MineRecycle;
import com.example.anuo.youdao.R;

import java.util.List;

public class MineRecycleAdapter extends RecyclerView.Adapter<MineRecycleAdapter.ViewHolder> {
    private Context context;
    private List<MineRecycle> mineRecycleList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView mtextView;

        public ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.img_mine_list);
            textView = (TextView)view.findViewById(R.id.txt_mine_list_name);
            mtextView = (TextView)view.findViewById(R.id.txt_mine_list_mark);
        }
    }

    public MineRecycleAdapter(Context context,List<MineRecycle> mineRecycles){
        this.context = context;
        this.mineRecycleList = mineRecycles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.mine_recycleview,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MineRecycle mineRecycle = mineRecycleList.get(i);
        viewHolder.imageView.setImageResource(mineRecycle.getImgId());
        viewHolder.textView.setText(mineRecycle.getName());
        viewHolder.mtextView.setText(mineRecycle.getMark());
    }

    @Override
    public int getItemCount() {
        return mineRecycleList.size();
    }
}
