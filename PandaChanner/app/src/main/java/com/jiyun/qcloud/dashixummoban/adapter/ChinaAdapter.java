package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jiyun.qcloud.dashixummoban.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/26.
 */

public class ChinaAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> list;
    private ArrayList<String> strings;
    public ChinaAdapter(FragmentManager fm,  ArrayList<BaseFragment> list,ArrayList<String> strings) {
        super(fm);
        this.list = list;
        this.strings=strings;
    }



    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
