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
import com.jiyun.qcloud.dashixummoban.entity.Home3;

import java.util.List;

/**
 * Created by Administrator on 2017/8/27 0027.
 */

public class GridList extends BaseAdapter {
    private final List<Home3.ListBean> list;
    private final Context context;

    public GridList(Context context, List<Home3.ListBean> list) {
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
            holder=new ViewHolder();
            view=LayoutInflater.from(context).inflate(R.layout.grid_listitem, null);
            holder.gritlistImg=view.findViewById(R.id.gritlist_img);
            holder.imageView2=view.findViewById(R.id.imageView2);
            holder.listImage=view.findViewById(R.id.list_image);
            holder.listShij=view.findViewById(R.id.list_shij);
            holder.listName=view.findViewById(R.id.list_name);
            holder.listRi=view.findViewById(R.id.list_ri);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getImage()).into(holder.gritlistImg);
        holder.listName.setText(list.get(i).getTitle());
        holder.listShij.setText(list.get(i).getVideoLength());
        holder.listRi.setText(list.get(i).getDaytime());
        return view;
    }
    class ViewHolder {
        ImageView gritlistImg;
        ImageView imageView2;
        ImageView listImage;
        TextView listShij;
        TextView listName;
        TextView listRi;
    }
}
