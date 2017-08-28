package com.jiyun.qcloud.dashixummoban.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by Administrator on 2017/8/23 0023.
 */

public class WideAdapter extends StaticPagerAdapter {
    int age[]={R.drawable.a, R.drawable.b, R.drawable.c};
    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
       view.setImageResource(age[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getCount() {
        return age.length;
    }
}
