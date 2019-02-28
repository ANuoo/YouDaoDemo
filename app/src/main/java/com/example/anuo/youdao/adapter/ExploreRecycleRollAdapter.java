package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.ExploreRecycleRollView;
import com.example.anuo.youdao.R;

import java.util.List;

public class ExploreRecycleRollAdapter extends RecyclerView.Adapter<ExploreRecycleRollAdapter.ViewHolder> {
    private Context mContext;
    private List<ExploreRecycleRollView> mExploreRecycleRollViewList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView mtextView;

        public ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.img_explore_roll_item);
            textView = (TextView)view.findViewById(R.id.txt_explore_roll_item);
            mtextView = (TextView)view.findViewById(R.id.txt_explore_roll_sign);
        }
    }

    public ExploreRecycleRollAdapter(Context context,List<ExploreRecycleRollView> exploreRecycleRollViews){
        this.mContext = context;
        mExploreRecycleRollViewList = exploreRecycleRollViews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext,R.layout.explore_recycleview_roll,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ExploreRecycleRollView exploreRecycleRollView = mExploreRecycleRollViewList.get(i);
        viewHolder.imageView.setImageResource(exploreRecycleRollView.getImgId());
        viewHolder.textView.setText(exploreRecycleRollView.getSentence());
        viewHolder.mtextView.setText(exploreRecycleRollView.getSign());
    }

    @Override
    public int getItemCount() {
        return mExploreRecycleRollViewList.size();
    }
}
