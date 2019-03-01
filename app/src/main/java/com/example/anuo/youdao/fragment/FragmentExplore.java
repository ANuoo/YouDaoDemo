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
import android.view.Window;
import android.view.WindowManager;

import com.example.anuo.youdao.adapter.ExploreRecycleAdapter;
import com.example.anuo.youdao.adapter.ExploreRecycleRollAdapter;
import com.example.anuo.youdao.view.ExploreRecycleRollView;
import com.example.anuo.youdao.view.ExploreRecycleView;
import com.example.anuo.youdao.R;
import com.example.anuo.youdao.decoration.SpacesItemDecoration;

import java.util.ArrayList;

public class FragmentExplore extends Fragment implements View.OnClickListener {
    private View ExploreView;
    private View view;
    private View mview;
    public RecyclerView mCollectRecycleView;
    public RecyclerView mRecycleView;
    private ArrayList<ExploreRecycleView> exploreRecycleViews = new ArrayList<ExploreRecycleView>();
    private ArrayList<ExploreRecycleRollView> exploreRecycleViewArrayList = new ArrayList<ExploreRecycleRollView>();
    private ExploreRecycleAdapter mExploreRecycleAdapter;
    private ExploreRecycleRollAdapter exploreRecycleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_explore, container, false);
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getActivity().getResources().getColor(R.color.colorStateBar));
            initExploreitemData();
        }

        return view;
    }

    private void initExploreitemData() {
        ExploreRecycleView wordbook = new ExploreRecycleView("单词本", R.drawable.explore_wordbook);
        exploreRecycleViews.add(wordbook);
        ExploreRecycleView professional = new ExploreRecycleView("人工翻译", R.drawable.explore_professional);
        exploreRecycleViews.add(professional);
        ExploreRecycleView youdaoHome = new ExploreRecycleView("有道精品", R.drawable.explore_youdao_home);
        exploreRecycleViews.add(youdaoHome);
        ExploreRecycleView activityCenter = new ExploreRecycleView("活动中心", R.drawable.explore_activity_center);
        exploreRecycleViews.add(activityCenter);
        ExploreRecycleRollView imageone = new ExploreRecycleRollView("Don't let your past determine the furture", "131975人  已跟读", R.drawable.explore_roll_item_one);
        exploreRecycleViewArrayList.add(imageone);
        ExploreRecycleRollView imagetwo = new ExploreRecycleRollView("what people ought to do is get outside their own house", "162688人  已跟读", R.drawable.explore_roll_item_two);
        exploreRecycleViewArrayList.add(imagetwo);
        ExploreRecycleRollView imagethree = new ExploreRecycleRollView("May your day be so merry,merry and bright!", "174790人  已跟读", R.drawable.explore_roll_item_three);
        exploreRecycleViewArrayList.add(imagethree);
        ExploreRecycleRollView imagefour = new ExploreRecycleRollView("Let me wish you and your family a peaceful", "144642人  已跟读", R.drawable.explore_roll_item_four);
        exploreRecycleViewArrayList.add(imagefour);
        mCollectRecycleView = (RecyclerView) view.findViewById(R.id.recycle_explore);
        mExploreRecycleAdapter = new ExploreRecycleAdapter(getActivity(), exploreRecycleViews);
        mCollectRecycleView.setAdapter(mExploreRecycleAdapter);
        mCollectRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecycleView = (RecyclerView) view.findViewById(R.id.recycle_explore_roll);
        exploreRecycleAdapter = new ExploreRecycleRollAdapter(getActivity(), exploreRecycleViewArrayList);
        mRecycleView.setAdapter(exploreRecycleAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(layoutManager);
        mRecycleView.addItemDecoration(new SpacesItemDecoration(20));
    }

    @Override
    public void onClick(View v) {

    }
    //    @Override
//    protected View initView() {
//        ExploreView = View.inflate(mContext,R.layout.fragment_explore,null);
//        return ExploreView;
//    }
//
//    @Override
//    protected void initData() {
//        super.initData();
//    }
}
