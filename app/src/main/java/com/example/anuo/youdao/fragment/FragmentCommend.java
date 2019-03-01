package com.example.anuo.youdao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anuo.youdao.adapter.DictionaryTodayAdapter;
import com.example.anuo.youdao.view.DictionaryTodayView;
import com.example.anuo.youdao.decoration.IData;
import com.example.anuo.youdao.info.InfoOne;
import com.example.anuo.youdao.info.InfoTwo;
import com.example.anuo.youdao.R;
import com.example.anuo.youdao.decoration.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class FragmentCommend extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView recyclerView;
    public SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager linearLayoutManager = null;
    private DiffItemsAdapter diffItemsAdapter;
    private List<IData> datas;

    private RecyclerView recyclerViewToday;
    private DictionaryTodayAdapter dictionaryTodayAdapter;
    private List<DictionaryTodayView> dictionaryTodayViewList = new ArrayList<DictionaryTodayView>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_dictionary_recommend, container, false);
            initView();
            initData();
            initItem(view);
        }
        return view;
    }

    private void initView() {
        DictionaryTodayView one = new DictionaryTodayView(R.drawable.dictionary_recommend_today_picture_one, "百句英语语法拯救你的期末考", "英语学习干货", "10531人已报名");
        dictionaryTodayViewList.add(one);
        DictionaryTodayView two = new DictionaryTodayView(R.drawable.explore_roll_item_three, "高考物理十大经典例题", "新高三必备", "1098人已报名");
        dictionaryTodayViewList.add(two);
        DictionaryTodayView three = new DictionaryTodayView(R.drawable.explore_roll_item_one, "考前必看化学方程式", "新高三必备", "234人已报名");
        dictionaryTodayViewList.add(three);
        recyclerViewToday = view.findViewById(R.id.recycle_dictionary_recommend_today);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewToday.setLayoutManager(linearLayoutManager1);
        dictionaryTodayAdapter = new DictionaryTodayAdapter(getActivity(), dictionaryTodayViewList);
        recyclerViewToday.setAdapter(dictionaryTodayAdapter);
        recyclerViewToday.addItemDecoration(new SpaceItemDecoration(20));
    }

    private void initItem(View view) {
        recyclerView = view.findViewById(R.id.recycle_dictionary_recommend);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        diffItemsAdapter = new DiffItemsAdapter(getActivity(), datas);
        recyclerView.setAdapter(diffItemsAdapter);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            InfoOne infoOne = new InfoOne();
            infoOne.setTitle("可爱即是正义！不得不说的一分钟超甜治愈向混剪");
            infoOne.setMark("我的视界 2.3万浏览");
            infoOne.setImgIdOne(R.drawable.explore_roll_item_two);
            infoOne.setImgIdTwo(R.drawable.explore_roll_item_four);
            infoOne.setImgIdThree(R.drawable.explore_roll_item_two);
            datas.add(infoOne);
            InfoOne infoTwo = new InfoOne();
            infoTwo.setTitle("读一本好书，让心灵在三月的十里春风中苏醒");
            infoTwo.setMark("you 1.2万浏览");
            infoTwo.setImgIdOne(R.drawable.explore_roll_item_four);
            infoTwo.setImgIdTwo(R.drawable.explore_roll_item_two);
            infoTwo.setImgIdThree(R.drawable.explore_roll_item_four);
            datas.add(infoTwo);
            InfoOne infoThree = new InfoOne();
            infoThree.setTitle("学好英语的神操作，绝对有你不知道的");
            infoThree.setMark("me 2万浏览");
            infoThree.setImgIdOne(R.drawable.dictionary_recommend_recycleview_picture_one);
            infoThree.setImgIdTwo(R.drawable.dictionary_recommend_recycleview_picture_two);
            infoThree.setImgIdThree(R.drawable.explore_roll_item_four);
            datas.add(infoThree);
            InfoOne infoFour = new InfoOne();
            infoFour.setTitle("十部美剧带你练好英语口语，劳逸结合才会有高效率！");
            infoFour.setMark("");
            infoFour.setImgIdOne(R.drawable.explore_roll_item_two);
            infoFour.setImgIdTwo(R.drawable.dictionary_recommend_recycleview_picture_three);
            infoFour.setImgIdThree(R.drawable.dictionary_recommend_recycleview_picture_two);
            datas.add(infoFour);
            InfoTwo infoTwo1 = new InfoTwo();
            infoTwo1.setTitle("每天进步一小步，一月可以出国游？");
            infoTwo1.setMark("广告");
            infoTwo1.setImgIdAd(R.drawable.explore_roll_item_four);
            datas.add(infoTwo1);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
