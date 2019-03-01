package com.example.anuo.youdao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anuo.youdao.adapter.DictionaryFollowAdapter;
import com.example.anuo.youdao.view.DictionaryFollowView;
import com.example.anuo.youdao.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentFollow extends Fragment implements View.OnClickListener {
    private View view;
    private RecyclerView recyclerView;
    private DictionaryFollowAdapter followAdapter;
    private List<DictionaryFollowView> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_dictionary_follow, container, false);
            initView();
        }
        return view;
    }

    private void initView() {
        list = new ArrayList<DictionaryFollowView>();
        DictionaryFollowView one = new DictionaryFollowView(R.drawable.dictionary_follow_picture_one, "趣看视界", "网罗国外好玩的新鲜视频，一起看世界", "231424人关注");
        list.add(one);
        DictionaryFollowView two = new DictionaryFollowView(R.drawable.dictionary_follow_picture_two, "双语美文", "英汉对照读美文，感悟语言的艺术", "23145人关注");
        list.add(two);
        DictionaryFollowView three = new DictionaryFollowView(R.drawable.dictionary_follow_picture_three, "有道晨读", "诉之于口，听之于耳，记之于心", "43145人关注");
        list.add(three);
        DictionaryFollowView four = new DictionaryFollowView(R.drawable.dictionary_follow_picture_four, "动听英乐", "精选动听英乐，用心感受天籁", "93157人关注");
        list.add(four);
        DictionaryFollowView five = new DictionaryFollowView(R.drawable.dictionary_follow_picture_five, "励志集", "不要小看自己的力量", "45278人关注");
        list.add(five);
        DictionaryFollowView six = new DictionaryFollowView(R.drawable.dictionary_follow_picture_six, "英孚口袋英语", "口袋英语，不只是干货而已", "56751人关注");
        list.add(six);
        DictionaryFollowView seven = new DictionaryFollowView(R.drawable.dictionary_follow_picture_seven, "英语功夫天天练", "教你英语真功夫，每天进步一点点！", "67623人关注");
        list.add(seven);
        DictionaryFollowView eight = new DictionaryFollowView(R.drawable.dictionary_follow_picture_eight, "壹句", "每天一句正能量名言，积跬步而致千里", "87651人关注");
        list.add(eight);
        recyclerView = view.findViewById(R.id.recycle_dictionary_follow);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        followAdapter = new DictionaryFollowAdapter(getActivity(), list);
        recyclerView.setAdapter(followAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}
