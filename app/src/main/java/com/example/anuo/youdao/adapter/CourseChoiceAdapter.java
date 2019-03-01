package com.example.anuo.youdao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.CourseChoiceView;
import com.example.anuo.youdao.R;

import java.util.List;

public class CourseChoiceAdapter extends RecyclerView.Adapter<CourseChoiceAdapter.ViewHolder> {
    private Context context;
    private List<CourseChoiceView> courseChoiceViews;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img_course_choice);
            textView = view.findViewById(R.id.txt_course_choice);
        }
    }

    public CourseChoiceAdapter(Context context, List<CourseChoiceView> courseChoiceViews) {
        this.context = context;
        this.courseChoiceViews = courseChoiceViews;
    }

    @NonNull
    @Override
    public CourseChoiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.course_recycleview_choise_item, null);
        CourseChoiceAdapter.ViewHolder viewHolder = new CourseChoiceAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseChoiceAdapter.ViewHolder viewHolder, int i) {
        CourseChoiceView courseChoiceView = courseChoiceViews.get(i);
        viewHolder.imageView.setImageResource(courseChoiceView.getImgId());
        viewHolder.textView.setText(courseChoiceView.getName());
    }

    @Override
    public int getItemCount() {
        return courseChoiceViews.size();
    }
}


