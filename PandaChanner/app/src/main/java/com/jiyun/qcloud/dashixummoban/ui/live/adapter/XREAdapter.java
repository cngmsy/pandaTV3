package com.jiyun.qcloud.dashixummoban.ui.live.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.Live.BiankanBianliaoBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by w1565 on 2017/7/21.
 */

public class XREAdapter extends RecyclerView.Adapter<XREAdapter.MyViewHolder> {
    private OnItemClickLinear onItemClickLinear;
    private TextView biankanitem_author;
    private TextView biankanitem_total;
    private TextView biankanitem_message;
    private TextView biankanitem_time;

    public void setOnItemClickLinear(OnItemClickLinear onItemClickLinear) {
        this.onItemClickLinear = onItemClickLinear;
    }

    public interface OnItemClickLinear {
        public void onItemclick(int position);

        public void onLongItemclick(int position);
    }


    private ArrayList<BiankanBianliaoBean.DataBean.ContentBean> list;
    private Context context;

    public XREAdapter(ArrayList<BiankanBianliaoBean.DataBean.ContentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.biankan_item, null);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        );
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.biankanitem_author.setText(list.get(position).getAuthor());
        holder.biankanitem_message.setText(list.get(position).getMessage());
        holder.biankanitem_total.setText("176970楼");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);

        holder.biankanitem_time.setText(str);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickLinear != null) {
                    onItemClickLinear.onItemclick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickLinear != null) {
                    onItemClickLinear.onLongItemclick(position);
                }
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView biankanitem_author, biankanitem_total, biankanitem_message, biankanitem_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            biankanitem_author = (TextView) itemView.findViewById(R.id.biankanitem_author);
            biankanitem_total = (TextView) itemView.findViewById(R.id.biankanitem_total);
            biankanitem_message = (TextView) itemView.findViewById(R.id.biankanitem_message);
            biankanitem_time = (TextView) itemView.findViewById(R.id.biankanitem_time);
        }
    }

}
