package com.example.anuo.youdao.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.anuo.youdao.fragment.FragmentColumn;
import com.example.anuo.youdao.fragment.FragmentCommend;
import com.example.anuo.youdao.fragment.FragmentFollow;
import com.example.anuo.youdao.fragment.ThirdFragment;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private String[] title = new String[]{"推荐","我的关注","老外看东西","全部栏目"};

    public MyFragmentAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new FragmentCommend();
        }else if(i == 1){
            return new FragmentFollow();
        }else if(i == 2){
            return new ThirdFragment();
        }else if(i == 3){
            return new FragmentColumn();
        }
        return new FragmentCommend();
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
