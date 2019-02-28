package com.example.anuo.youdao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public FragmentAdapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }

    public FragmentAdapter(FragmentManager fragmentManager,List<Fragment> list){
        super(fragmentManager);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
