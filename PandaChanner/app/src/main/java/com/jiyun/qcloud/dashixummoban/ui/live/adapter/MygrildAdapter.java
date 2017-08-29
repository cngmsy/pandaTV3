package com.jiyun.qcloud.dashixummoban.ui.live.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.Live.MoreBeans;

import java.util.List;

/**
 * Created by lenovo on 2017/8/24.
 */

public class MygrildAdapter extends BaseAdapter {
    private Context context;
    private List<MoreBeans.ListBean> list;

    public MygrildAdapter(Context context, List<MoreBeans.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        GrildHodler hodler;
        if (view == null) {
            hodler = new GrildHodler();
            view = LayoutInflater.from(context).inflate(R.layout.item_more_grild, null);
            hodler.img = view.findViewById(R.id.item_more_img);
            hodler.tv = view.findViewById(R.id.item_more_title);
            view.setTag(hodler);
        } else {
            hodler = (GrildHodler) view.getTag();
        }
        Glide.with(context).load(list.get(i).getImage()).into(hodler.img);
        hodler.tv.setText(list.get(i).getTitle());
        return view;
    }

    static class GrildHodler {
        private ImageView img;
        private TextView tv;
    }
}
