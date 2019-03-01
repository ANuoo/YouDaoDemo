package com.example.anuo.youdao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anuo.youdao.view.MineRecycle;
import com.example.anuo.youdao.adapter.MineRecycleAdapter;
import com.example.anuo.youdao.R;

import java.util.ArrayList;

public class FragmentMine extends Fragment implements View.OnClickListener {
    private View MineView;
    private View view;
    public RecyclerView mrecyclerView;
    public ArrayList<MineRecycle> mineRecycleViewArrayList = new ArrayList<MineRecycle>();
    private MineRecycleAdapter mineAdapter;

    private CollapsingToolbarLayoutState state;
    private AppBarLayout appBarLayout;
    private TextView textView;
    private ImageView imageView;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_mine, container, false);
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getActivity().getResources().getColor(R.color.colorStateBar));
            initMineData();
            appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar_mine);
            textView = (TextView) view.findViewById(R.id.txt_mine_title_mark);
            imageView = (ImageView) view.findViewById(R.id.img_mine_bar_head);
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    int newalpha = 255 + i;
                    newalpha = newalpha < 0 ? 0 : newalpha;
                    imageView.setAlpha(newalpha);
                    textView.setAlpha(newalpha);
                    if (i == 0) {
                        if (state != CollapsingToolbarLayoutState.EXPANDED) {
                            state = CollapsingToolbarLayoutState.EXPANDED;
                        }
                    } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
                        if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                            state = CollapsingToolbarLayoutState.COLLAPSED;
                        }
                    } else {
                        if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                            state = CollapsingToolbarLayoutState.INTERNEDIATE;
                        }
                    }
                }
            });
        }
        return view;
    }

    private void initMineData() {
        MineRecycle gloden = new MineRecycle("会员中心", R.drawable.mine_vip_gloden_entrance_rect_bg, "开通立享多项特权");
        mineRecycleViewArrayList.add(gloden);
        MineRecycle notification = new MineRecycle("消息中心", R.drawable.mine_notifications_orange, "");
        mineRecycleViewArrayList.add(notification);
        MineRecycle myeyes = new MineRecycle("我的关注", R.drawable.mine_eyes_on_red_green, "");
        mineRecycleViewArrayList.add(myeyes);
        MineRecycle collection = new MineRecycle("我的收藏", R.drawable.mine_my_collection_blue, "");
        mineRecycleViewArrayList.add(collection);
        MineRecycle bought = new MineRecycle("已购买的内容", R.drawable.mine_youdao_course_bought_orange, "");
        mineRecycleViewArrayList.add(bought);
        MineRecycle download = new MineRecycle("已下载专栏", R.drawable.mine_youdao_course_download_yellow, "");
        mineRecycleViewArrayList.add(download);
        MineRecycle coupon = new MineRecycle("我的优惠券", R.drawable.mine_my_coupon_golden, "");
        mineRecycleViewArrayList.add(coupon);
        MineRecycle course = new MineRecycle("我的精品课", R.drawable.mine_youdao_course_green, "");
        mineRecycleViewArrayList.add(course);
        MineRecycle dictdownload = new MineRecycle("下载离线数据包", R.drawable.mine_download_dict_red, "");
        mineRecycleViewArrayList.add(dictdownload);
        MineRecycle phonecard = new MineRecycle("免流量专区", R.drawable.mine_phonecard_orange, "");
        mineRecycleViewArrayList.add(phonecard);
        MineRecycle setting = new MineRecycle("设置", R.drawable.mine_setting_blue, "");
        mineRecycleViewArrayList.add(setting);
        MineRecycle like = new MineRecycle("满意度调查", R.drawable.mine_like_solid_red, "");
        mineRecycleViewArrayList.add(like);
        mrecyclerView = (RecyclerView) view.findViewById(R.id.recycle_mine);
        mineAdapter = new MineRecycleAdapter(getActivity(), mineRecycleViewArrayList);
        mrecyclerView.setAdapter(mineAdapter);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onClick(View v) {

    }


}
