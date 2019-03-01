package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.CourseRecommendView;
import com.example.anuo.youdao.R;

import java.util.List;

public class CourseRecommendAdapter extends RecyclerView.Adapter<CourseRecommendAdapter.ViewHolder> {
    private Context context;
    private List<CourseRecommendView> courseRecommendViews;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textName;
        TextView textNameMark;
        TextView textMark;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_course_recommend);
            textTitle = view.findViewById(R.id.txt_course_recommend_list_title);
            textName = view.findViewById(R.id.txt_course_recommend_name);
            textNameMark = view.findViewById(R.id.txt_course_recommend_list_name_mark);
            textMark = view.findViewById(R.id.txt_course_recommend_list_mark);
        }
    }

    public CourseRecommendAdapter(Context context, List<CourseRecommendView> courseRecommendViews) {
        this.context = context;
        this.courseRecommendViews = courseRecommendViews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.course_recycleview_recommend_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CourseRecommendView courseRecommendView = courseRecommendViews.get(i);
        viewHolder.imageView.setImageResource(courseRecommendView.getImageId());
        viewHolder.textTitle.setText(courseRecommendView.getListTitle());
        viewHolder.textName.setText(courseRecommendView.getListName());
        viewHolder.textNameMark.setText(courseRecommendView.getListNameMark());
        viewHolder.textMark.setText(courseRecommendView.getListMark());
    }

    @Override
    public int getItemCount() {
        return courseRecommendViews.size();
    }
}
