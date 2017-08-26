package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.gun.ListBean;

import java.util.List;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/23.
 * 负责 全部
 * 团队 1人
 */

public class GunLvAdapter extends BaseAdapter {

    private Context context;
    private List<ListBean> list;

    public GunLvAdapter(Context context, List<ListBean> list) {
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
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_gun,null);
            holder.headImg = view.findViewById(R.id.img_gun_head);
            holder.titleTv = view.findViewById(R.id.tv_gun_title);
            holder.contentTv = view.findViewById(R.id.tv_gun_content);
            holder.lengthTv = view.findViewById(R.id.tv_gun_length);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        ListBean listBean = list.get(i);
        holder.titleTv.setText(listBean.getTitle());
        holder.contentTv.setText(listBean.getBrief());
        Glide.with(context).load(listBean.getImage()).into(holder.headImg);
        holder.lengthTv.setText(listBean.getVideoLength());
        holder.lengthTv.setTextColor(Color.WHITE);
        return view;
    }

    class ViewHolder {
        TextView titleTv,contentTv,lengthTv;
        ImageView headImg;
    }
}
