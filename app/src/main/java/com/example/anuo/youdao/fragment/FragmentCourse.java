package com.example.anuo.youdao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anuo.youdao.adapter.AutoPullAdapter;
import com.example.anuo.youdao.adapter.CourseChoiceAdapter;
import com.example.anuo.youdao.view.CourseChoiceView;
import com.example.anuo.youdao.view.CourseEndlessRecycle;
import com.example.anuo.youdao.adapter.CourseGuidanceAdapter;
import com.example.anuo.youdao.view.CourseGuidanceView;
import com.example.anuo.youdao.adapter.CourseRecommendAdapter;
import com.example.anuo.youdao.view.CourseRecommendView;
import com.example.anuo.youdao.adapter.CourseSelectAdapter;
import com.example.anuo.youdao.view.CourseSelectView;
import com.example.anuo.youdao.R;
import com.example.anuo.youdao.decoration.SpaceItemDecoration;
import com.example.anuo.youdao.decoration.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class FragmentCourse extends Fragment implements View.OnClickListener {
    private View CourseView;
    private View view;
    private Context context;
    private AutoPullAdapter adapter;

    public RecyclerView recyclerView;
    public List<CourseEndlessRecycle> list = new ArrayList<CourseEndlessRecycle>();

    public RecyclerView mRecycleView;
    private List<CourseChoiceView> courseChoiceViews = new ArrayList<CourseChoiceView>();

    public RecyclerView recyclerViewRecommend;
    private List<CourseRecommendView> courseRecommendViews = new ArrayList<CourseRecommendView>();

    public RecyclerView recyclerViewGuidance;
    private List<CourseGuidanceView> courseGuidanceViewList = new ArrayList<CourseGuidanceView>();

    public RecyclerView recyclerViewSelect;
    private List<CourseSelectView> courseSelectViewList = new ArrayList<CourseSelectView>();

//    private Handler timehandler = new Handler();
//     Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            recyclerView.scrollTo(350,0);
//            timehandler.postDelayed(this,1000);
//        }
//    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_course, container, false);
            initEndlessData();
        }
        return view;
    }

    private void initEndlessData() {
        CourseEndlessRecycle One = new CourseEndlessRecycle(R.drawable.course_recycle_item_img, "死磕万级词汇  零基础蜕变A计划", "英语提升", "快速入门钟叔十年单词体系");
        list.add(One);
        CourseEndlessRecycle Two = new CourseEndlessRecycle(R.drawable.course_recycle_item_img, "明星私教带你快速练口语", "逻辑英语", "改变中国人的“哑巴英语”");
        list.add(Two);
        CourseEndlessRecycle Three = new CourseEndlessRecycle(R.drawable.course_recycle_item_img, "地道英音十大养成记", "逻辑英语", "伦敦大学正音师带你入门纯正英音");
        list.add(Three);
        CourseEndlessRecycle Four = new CourseEndlessRecycle(R.drawable.course_recycle_item_img, "5天高效背词训练营", "逻辑英语", "教你0到万次的超强记忆逻辑");
        list.add(Four);
        CourseChoiceView cet = new CourseChoiceView(R.drawable.course_cet, "四六级");
        courseChoiceViews.add(cet);
        CourseChoiceView logic = new CourseChoiceView(R.drawable.course_logic_english, "逻辑英语");
        courseChoiceViews.add(logic);
        CourseChoiceView postgraduate = new CourseChoiceView(R.drawable.course_postgraduate, "考研");
        courseChoiceViews.add(postgraduate);
        CourseChoiceView smalllanguage = new CourseChoiceView(R.drawable.course_smalllanguage, "小语种");
        courseChoiceViews.add(smalllanguage);
        CourseChoiceView hobby = new CourseChoiceView(R.drawable.course_hobby, "兴趣技能");
        courseChoiceViews.add(hobby);
        CourseChoiceView teacher = new CourseChoiceView(R.drawable.course_teacher, "教师资格");
        courseChoiceViews.add(teacher);
        CourseRecommendView First = new CourseRecommendView(R.drawable.course_recommend_picture, "一个公式带你妙解天下英文", "钟平", "英语宗师", "十年研究，用数学思维瞬间看懂天下长难句");
        courseRecommendViews.add(First);
        CourseRecommendView Second = new CourseRecommendView(R.drawable.course_recommend_picture, "0到10000级词汇蜕变，零基础蜕变A计划", "钟平", "逻辑英语", "五步渗透记忆爆破万级词汇");
        courseRecommendViews.add(Second);
        CourseRecommendView Thrid = new CourseRecommendView(R.drawable.course_recommend_picture, "一张图标迅速学英语语法", "祁连山", "英语宗师", "语法N年学不会？简单图标带你攻克语法难题");
        courseRecommendViews.add(Thrid);
        CourseGuidanceView theA = new CourseGuidanceView(R.drawable.course_recycle_item_img, "四六级究竟是个什么鬼", "2345播放");
        courseGuidanceViewList.add(theA);
        CourseGuidanceView theB = new CourseGuidanceView(R.drawable.course_recycle_item_img, "肌肉记忆法速记日语五十音", "1123播放");
        courseGuidanceViewList.add(theB);
        CourseGuidanceView theC = new CourseGuidanceView(R.drawable.course_recycle_item_img, "一个公式读天下英文", "2356播放");
        courseGuidanceViewList.add(theC);
        CourseSelectView theFirst = new CourseSelectView(R.drawable.img_course_select_circle, "逻辑英语", "一个公式带你妙解天下英语", "开课时间：2019.2.20 20:00  2课时", "李二", "已有5677人报名");
        courseSelectViewList.add(theFirst);
        CourseSelectView theSecond = new CourseSelectView(R.drawable.img_course_select_circle, "逻辑英语", "死磕万级词汇 零基础蜕变", "开课时间：2019.2.22 20:00  4课时", "王三", "已有2764人报名");
        courseSelectViewList.add(theSecond);
        CourseSelectView theThird = new CourseSelectView(R.drawable.img_course_select_circle, "实用英语", "如何像美国人一样流利说英语", "开课时间：2019.3.6 20:00  2课时", "张三", "已有699人报名");
        courseSelectViewList.add(theThird);
        CourseSelectView theFourth = new CourseSelectView(R.drawable.img_course_select_circle, "兴趣", "最强大脑教你快速提升记忆力", "开课时间：2019.2.21 20:00  1.5课时", "刘六", "已有699人报名");
        courseSelectViewList.add(theFourth);
        CourseSelectView theFiveth = new CourseSelectView(R.drawable.img_course_select_circle, "实用英语", "零基础打造纯正英式口音", "开课时间：2012.3.4 20:00  1课时", "爱丽丝", "");
        courseSelectViewList.add(theFiveth);
        CourseSelectView theSixth = new CourseSelectView(R.drawable.img_course_select_circle, "四六级", "有道考神四六级成绩解析大题", "开课时间：2019.3.5 20:00 4课时", "陈陈", "已有2314人报名");
        courseSelectViewList.add(theSixth);
        CourseSelectView theSeventh = new CourseSelectView(R.drawable.img_course_select_circle, "四六级", "吃透听力 听懂四六级", "开课时间：2019.3.4 20:00  1课时", "韩子", "已有233人报名");
        courseSelectViewList.add(theSeventh);
        CourseSelectView theEighth = new CourseSelectView(R.drawable.img_course_select_circle, "考研", "出分了！快速了解20考研最新考情", "开课时间：2019.2.21 20:00  4课时", "罗五", "已有2342人报名");
        courseSelectViewList.add(theEighth);
        CourseSelectView theNineth = new CourseSelectView(R.drawable.img_course_select_circle, "考研", "2019考研初试成绩分析及复试调剂二战指导", "开课时间：2019.2.26 20:00  2课时", "苏苏", "");
        courseSelectViewList.add(theNineth);
        CourseSelectView theTenth = new CourseSelectView(R.drawable.img_course_select_circle, "考研", "提升2020考研成功率必知的几件大事", "开课时间：2019.3.5 20:00  2课时", "王四", "已有2345人报名");
        courseSelectViewList.add(theTenth);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_course_endless);
        AutoPullAdapter autoPullAdapter = new AutoPullAdapter(getActivity(), list);
        recyclerView.setAdapter(autoPullAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(recyclerView);

        mRecycleView = (RecyclerView) view.findViewById(R.id.recycle_course_choise);
        CourseChoiceAdapter courseChoiceAdapter = new CourseChoiceAdapter(getActivity(), courseChoiceViews);
        mRecycleView.setAdapter(courseChoiceAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(linearLayoutManager);
        mRecycleView.addItemDecoration(new SpacesItemDecoration(75));

        recyclerViewRecommend = (RecyclerView) view.findViewById(R.id.recycle_course_recommend);
        CourseRecommendAdapter courseRecommendAdapter = new CourseRecommendAdapter(getActivity(), courseRecommendViews);
        recyclerViewRecommend.setAdapter(courseRecommendAdapter);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewRecommend.setLayoutManager(manager1);

        recyclerViewGuidance = (RecyclerView) view.findViewById(R.id.recycle_course_guidance);
        CourseGuidanceAdapter courseGuidanceAdapter = new CourseGuidanceAdapter(getActivity(), courseGuidanceViewList);
        recyclerViewGuidance.setAdapter(courseGuidanceAdapter);
        LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewGuidance.setLayoutManager(manager2);
        LinearSnapHelper linearSnapHelper1 = new LinearSnapHelper();
        linearSnapHelper1.attachToRecyclerView(recyclerViewGuidance);
        recyclerViewGuidance.addItemDecoration(new SpaceItemDecoration(20));

        recyclerViewSelect = (RecyclerView) view.findViewById(R.id.recycle_course_select);
        CourseSelectAdapter courseSelectAdapter = new CourseSelectAdapter(getActivity(), courseSelectViewList);
        recyclerViewSelect.setAdapter(courseSelectAdapter);
        LinearLayoutManager manager3 = new LinearLayoutManager(getContext());
        manager3.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewSelect.setLayoutManager(manager3);
    }

    @Override
    public void onClick(View v) {

    }
}
