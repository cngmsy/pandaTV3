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
import com.jiyun.qcloud.dashixummoban.entity.Home2;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26 0026.
 */

public class GridviewCctv extends BaseAdapter {
    private final Context context;
    private final List<Home2.ListBean> list;

    public GridviewCctv(Context context, List<Home2.ListBean> list) {
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
        if (view==null) {
            view = LayoutInflater.from(context).inflate(R.layout.gridcctv_item, null);
            holder=new ViewHolder();
            holder.grit_img = (ImageView) view.findViewById(R.id.gritcctv_img);
            holder.cctv_shij = (TextView) view.findViewById(R.id.cctv_shij);
            holder.grid_text = (TextView) view.findViewById(R.id.gridcctv_text);
            holder.cctv_ri = (TextView) view.findViewById(R.id.cctv_ri);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getImage()).into(holder.grit_img);
        holder.grid_text.setText(list.get(i).getTitle());
        holder.cctv_shij.setText(list.get(i).getVideoLength());
        holder.cctv_ri.setText(list.get(i).getDaytime());

        return view;
    }

    public static class ViewHolder {
        public ImageView grit_img;
        public TextView cctv_shij,cctv_ri;
        public TextView grid_text;
    }


}
