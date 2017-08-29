package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.app.App;
import com.jiyun.qcloud.dashixummoban.entity.Live.HuDongBean;
import com.jiyun.qcloud.dashixummoban.main.InDetailsActivity;

import java.util.List;

/**
 * Created by lenovo on 2017/8/28.
 */

public class InterAdapter extends RecyclerView.Adapter<InterAdapter.ViewHolder> {
    private List<HuDongBean.InteractiveBean> list;
    private Context context;

    public InterAdapter(Context context, List<HuDongBean.InteractiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_interaction, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, InDetailsActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("web",list.get(position).getUrl());
                App.mBaseActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.intercation_title);
            imageView = itemView.findViewById(R.id.interaction_img);
            linearLayout=itemView.findViewById(R.id.interaction);
        }
    }
}
