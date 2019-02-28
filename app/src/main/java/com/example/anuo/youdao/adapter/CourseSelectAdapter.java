package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.CourseSelectView;
import com.example.anuo.youdao.R;

import java.util.List;

public class CourseSelectAdapter extends RecyclerView.Adapter<CourseSelectAdapter.ViewHolder> {
    public Context context;
    private List<CourseSelectView> courseSelectViewList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textTitleMark;
        TextView textTitle;
        TextView textTime;
        TextView textName;
        TextView textMark;

        public ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.img_course_select_circle);
            textTitleMark = view.findViewById(R.id.txt_course_select_list_title_mark);
            textTitle = view.findViewById(R.id.txt_course_select_list_title);
            textTime = view.findViewById(R.id.txt_course_select_list_time);
            textName = view.findViewById(R.id.txt_course_select_list_name);
            textMark = view.findViewById(R.id.txt_course_select_list_mark);
        }
    }

    public CourseSelectAdapter(Context context,List<CourseSelectView> courseSelectViews){
        this.context = context;
        courseSelectViewList = courseSelectViews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = View.inflate(context,R.layout.course_recycleview_select_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CourseSelectView courseSelectView = courseSelectViewList.get(i);
        viewHolder.imageView.setImageResource(courseSelectView.getImageId());
        viewHolder.textTitleMark.setText(courseSelectView.getTitleMark());
        viewHolder.textTitle.setText(courseSelectView.getTitle());
        viewHolder.textTime.setText(courseSelectView.getTime());
        viewHolder.textName.setText(courseSelectView.getName());
        viewHolder.textMark.setText(courseSelectView.getMark());
    }

    @Override
    public int getItemCount() {
        return courseSelectViewList.size();
    }
}
