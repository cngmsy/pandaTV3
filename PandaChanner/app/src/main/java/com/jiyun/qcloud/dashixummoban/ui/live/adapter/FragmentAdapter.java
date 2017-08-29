package com.jiyun.qcloud.dashixummoban.ui.live.adapter;

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
import com.jiyun.qcloud.dashixummoban.entity.Live.MomentBean;
import com.jiyun.qcloud.dashixummoban.ui.live.video.VedioActivity;

import java.util.List;

/**
 * Created by lenovo on 2017/8/24.
 */

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.ViewHolder> {
    private List<MomentBean.VideoBean> list;
    private Context context;

    public FragmentAdapter(Context context, List<MomentBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_moment, parent, false));
        return holder;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getT());
        holder.timer.setText(list.get(position).getPtime());
        holder.tv.setText(list.get(position).getLen());
        Glide.with(context).load(list.get(position).getImg()).centerCrop().into(holder.iv);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VedioActivity.class);
                intent.putExtra("url", "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=" + list.get(position).getVid());
                intent.putExtra("title", list.get(position).getT());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView timer;
        private TextView tv;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.item_img);
            title = (TextView) itemView.findViewById(R.id.item_title);
            timer = (TextView) itemView.findViewById(R.id.item_year);
            linearLayout = itemView.findViewById(R.id.item_linear);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
