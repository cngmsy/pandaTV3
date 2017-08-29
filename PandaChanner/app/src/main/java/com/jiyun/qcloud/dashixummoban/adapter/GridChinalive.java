package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;

import java.util.List;

/**
 * Created by Administrator on 2017/8/27 0027.
 */

public class GridChinalive extends BaseAdapter{
    private final Context context;
    private final List<PandaHome.DataBean.ChinaliveBean.ListBeanXX> list;

    public GridChinalive(Context context, List<PandaHome.DataBean.ChinaliveBean.ListBeanXX> list) {
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
        ViewHolder holder;
        view = LayoutInflater.from(context).inflate(R.layout.chinalive_item, null);
        holder=new ViewHolder();
        holder.gridText=view.findViewById(R.id.grid_text);
        holder.gritImg=view.findViewById(R.id.grit_img);
        Glide.with(context).load(list.get(i).getImage()).into(holder.gritImg);
        holder.gridText.setText(list.get(i).getTitle());
        return view;
    }

    class ViewHolder {
        ImageView gritImg;
        TextView gridText;
    }
}
