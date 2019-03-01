package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.CourseGuidanceView;
import com.example.anuo.youdao.R;

import java.util.List;

public class CourseGuidanceAdapter extends RecyclerView.Adapter<CourseGuidanceAdapter.ViewHolder> {
    private Context context;
    private List<CourseGuidanceView> courseGuidanceViewList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView imageViewPlay;
        TextView textTitle;
        TextView textTitleMark;
        ImageView imageViewMarkPlay;
        TextView textMark;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_course_guidance_video);
            imageViewPlay = view.findViewById(R.id.img_course_guidance_video_button);
            textTitle = view.findViewById(R.id.txt_course_guidance_list_title);
            textTitleMark = view.findViewById(R.id.txt_course_guidance_list_title_mark);
            imageViewMarkPlay = view.findViewById(R.id.img_course_guidance_play);
            textMark = view.findViewById(R.id.txt_course_guidance_list_mark);
        }
    }

    public CourseGuidanceAdapter(Context context, List<CourseGuidanceView> courseGuidanceViews) {
        this.context = context;
        courseGuidanceViewList = courseGuidanceViews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.course_recycleview_guidance_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CourseGuidanceView courseGuidanceView = courseGuidanceViewList.get(i);
        viewHolder.imageView.setImageResource(courseGuidanceView.getImageId());
        viewHolder.textTitle.setText(courseGuidanceView.getTitle());
        viewHolder.textMark.setText(courseGuidanceView.getMark());
    }

    @Override
    public int getItemCount() {
        return courseGuidanceViewList.size();
    }
}
