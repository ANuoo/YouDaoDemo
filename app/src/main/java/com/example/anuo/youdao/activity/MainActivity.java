package com.example.anuo.youdao.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.anuo.youdao.R;
import com.example.anuo.youdao.fragment.FragmentCourse;
import com.example.anuo.youdao.fragment.FragmentDictionary;
import com.example.anuo.youdao.fragment.FragmentExplore;
import com.example.anuo.youdao.fragment.FragmentMine;
import com.example.anuo.youdao.fragment.FragmentTranslate;

public class MainActivity extends FragmentActivity {
    private RadioButton buttonDictionary,buttonTranslate,buttonCourse,buttonExplore,buttonMine;
    private ViewPager viewPager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_home,new FragmentDictionary());
        fragmentTransaction.commit();
    }

    private void initView(){
        buttonDictionary = (RadioButton)findViewById(R.id.but_home_dictionary);
        buttonTranslate = (RadioButton) findViewById(R.id.but_home_translate);
        buttonCourse = (RadioButton) findViewById(R.id.but_home_course);
        buttonExplore = (RadioButton) findViewById(R.id.but_home_explore);
        buttonMine = (RadioButton)findViewById(R.id.but_home_mine);
        radioGroup = (RadioGroup)findViewById(R.id.radio_home_select);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (checkedId){
                    case R.id.but_home_dictionary:
                        fragmentTransaction.replace(R.id.frame_home,new FragmentDictionary());
                        break;
                    case R.id.but_home_translate:
                        fragmentTransaction.replace(R.id.frame_home,new FragmentTranslate());
                        break;
                    case R.id.but_home_course:
                        fragmentTransaction.replace(R.id.frame_home,new FragmentCourse());
                        break;
                    case R.id.but_home_explore:
                        fragmentTransaction.replace(R.id.frame_home,new FragmentExplore());
                        break;
                    case R.id.but_home_mine:
                        fragmentTransaction.replace(R.id.frame_home,new FragmentMine());
                        break;
                }
                fragmentTransaction.commit();
            }
        });
    }

}