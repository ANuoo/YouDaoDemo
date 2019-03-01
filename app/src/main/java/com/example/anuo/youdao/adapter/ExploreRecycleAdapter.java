package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.ExploreRecycleView;
import com.example.anuo.youdao.R;

import java.util.List;

public class ExploreRecycleAdapter extends RecyclerView.Adapter<ExploreRecycleAdapter.ViewHolder> {
    private Context mContext;
    private List<ExploreRecycleView> mExploreRecycleView;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.img_explore_item);
            mTextView = (TextView) view.findViewById(R.id.txt_explore_item);
        }
    }

    public ExploreRecycleAdapter(Context context, List<ExploreRecycleView> exploreRecycleViews) {
        this.mContext = context;
        mExploreRecycleView = exploreRecycleViews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.explore_recycleview_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ExploreRecycleView recycleView = mExploreRecycleView.get(i);
        viewHolder.mImageView.setImageResource(recycleView.getImageId());
        viewHolder.mTextView.setText(recycleView.getName());
    }

    @Override
    public int getItemCount() {
        return mExploreRecycleView.size();
    }
}
