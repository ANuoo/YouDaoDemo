package com.example.anuo.youdao.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.anuo.youdao.activity.SearchActivity;
import com.example.anuo.youdao.adapter.FragmentAdapter;
import com.example.anuo.youdao.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentDictionary extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button buttonRecommend, buttonFollow, buttonForeigners, buttonColumn;
    private Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_dictionary, container, false);
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getActivity().getResources().getColor(R.color.colorPink));
            initView();
            initText();
        }
        return view;
    }

    private void initView() {
        toolbar = (Toolbar) view.findViewById(R.id.dictionary_toolbar_enter);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_dictionary_content);

        list = new ArrayList<>();
        buttonRecommend = (Button) view.findViewById(R.id.but_dictionary_recommend);
        buttonFollow = (Button) view.findViewById(R.id.but_dictionary_follow);
        buttonForeigners = (Button) view.findViewById(R.id.but_dictionary_foreigners);
        buttonColumn = (Button) view.findViewById(R.id.but_dictionary_column);

        buttonRecommend.setOnClickListener(this);
        buttonFollow.setOnClickListener(this);
        buttonForeigners.setOnClickListener(this);
        buttonColumn.setOnClickListener(this);

        list.add(new FragmentCommend());
        list.add(new FragmentFollow());
        list.add(new ThirdFragment());
        list.add(new FragmentColumn());

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }


    @Override
    public void onPageSelected(int i) {
        initButtonListener();
        switch (i) {
            case 0:
                buttonRecommend.setTextColor(getResources().getColor(R.color.colorPink));
                break;
            case 1:
                buttonFollow.setTextColor(getResources().getColor(R.color.colorPink));
                break;
            case 2:
                buttonForeigners.setTextColor(getResources().getColor(R.color.colorPink));
                break;
            case 3:
                buttonColumn.setTextColor(getResources().getColor(R.color.colorPink));
                break;
        }
    }


    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        initButtonListener();
        switch (v.getId()) {
            case R.id.but_dictionary_recommend:
                viewPager.setCurrentItem(0);
                break;
            case R.id.but_dictionary_follow:
                viewPager.setCurrentItem(1);
                break;
            case R.id.but_dictionary_foreigners:
                viewPager.setCurrentItem(2);
                break;
            case R.id.but_dictionary_column:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private void initButtonListener() {
        buttonRecommend.setTextColor(getResources().getColor(R.color.colorHomeSelectOff));
        buttonFollow.setTextColor(getResources().getColor(R.color.colorHomeSelectOff));
        buttonForeigners.setTextColor(getResources().getColor(R.color.colorHomeSelectOff));
        buttonColumn.setTextColor(getResources().getColor(R.color.colorHomeSelectOff));
    }

    private void initText() {
        TextView textView = (TextView) view.findViewById(R.id.txt_dictionary_toolbar);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);

            }
        });
    }

    private Bitmap roundBitmapByXfermode(Bitmap bitmap, int outWidth, int outHeight, int radius) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap can't be null");
        }

        float widthScale = outWidth * 1.0f / bitmap.getWidth();
        float heightScale = outHeight * 1.0f / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(widthScale, heightScale);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        Bitmap targetBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        canvas.drawARGB(0, 0, 0, 0);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        RectF rectF = new RectF(0f, 0f, (float) outWidth, (float) outHeight);

        canvas.drawRoundRect(rectF, radius, radius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        Rect rect = new Rect(0, 0, outWidth, outHeight);
        canvas.drawBitmap(newBitmap, rect, rect, paint);
        return targetBitmap;
    }
}