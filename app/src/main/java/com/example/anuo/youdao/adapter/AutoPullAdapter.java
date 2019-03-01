package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.CourseEndlessRecycle;
import com.example.anuo.youdao.R;

import java.util.List;

public class AutoPullAdapter extends RecyclerView.Adapter<AutoPullAdapter.BaseViewHolder> {
    private Context context;
    private List<CourseEndlessRecycle> listBeans;

    public AutoPullAdapter(Context context, List<CourseEndlessRecycle> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textViewone;
        TextView textViewtwo;

        public BaseViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_course_endless);
            textView = view.findViewById(R.id.txt_course_endless_title);
            textViewone = view.findViewById(R.id.txt_course_endless_mark_title);
            textViewtwo = view.findViewById(R.id.txt_course_endless_mark);
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.course_recycleview_endless_item, null);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        CourseEndlessRecycle courseEndlessRecycle = listBeans.get(i % listBeans.size());
        baseViewHolder.imageView.setImageResource(courseEndlessRecycle.getImgId());
        baseViewHolder.textView.setText(courseEndlessRecycle.getTitle());
        baseViewHolder.textViewone.setText(courseEndlessRecycle.getMarkTitle());
        baseViewHolder.textViewtwo.setText(courseEndlessRecycle.getMark());

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

}
