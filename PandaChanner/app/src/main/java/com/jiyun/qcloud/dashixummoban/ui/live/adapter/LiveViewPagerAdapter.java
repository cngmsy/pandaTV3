package com.jiyun.qcloud.dashixummoban.ui.live.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/8/23.
 */

public class LiveViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> list;
    private List<Fragment> fragments;

    public LiveViewPagerAdapter(FragmentManager fm, List<String> list, List<Fragment> fragments) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
