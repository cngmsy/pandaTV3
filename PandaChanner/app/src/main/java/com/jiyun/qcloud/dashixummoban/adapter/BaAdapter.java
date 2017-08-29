package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.app.App;
import com.jiyun.qcloud.dashixummoban.entity.BadaBean;
import com.jiyun.qcloud.dashixummoban.entity.ChinaBean;
import com.jiyun.qcloud.dashixummoban.ui.China.LiveChinaLiveBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dell on 2017/8/28.
 */

public class BaAdapter extends BaseAdapter {
    private Context context;
    private List<BadaBean.LiveBean> list;
    private  int liu=1;
    private LiveChinaLiveBean liveChinaLiveBean;
    private String url;
    private String flv2;

    public BaAdapter(Context context, List<BadaBean.LiveBean> list) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
            holder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.lv_item,null);
            holder.ima_icom=view.findViewById(R.id.lv_icon);
            holder.ima_bt=view.findViewById(R.id.lv_bt);
            holder.ima_jiantou=view.findViewById(R.id.lv_jiantou);
            holder.tv_title=view.findViewById(R.id.lv_title);
            holder.tv_jianjie=view.findViewById(R.id.lv_jianjie);
            holder.player=view.findViewById(R.id.lv_video);
            //holder.videoView=view.findViewById(R.id.lv_video)
        Glide.with(context).load(list.get(i).getImage()).into(holder.player.ivThumb);
        holder.player.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);

        holder.ima_bt.setImageResource(R.drawable.newplay);
        holder.tv_title.setText("[正在直播]"+list.get(i).getTitle());
        holder.tv_jianjie.setText(list.get(i).getBrief());
        holder.ima_jiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(liu==1){
                    holder.ima_jiantou.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    holder.tv_jianjie.setVisibility(View.VISIBLE);
                    liu=0;
                }else if(liu==0){
                    holder.ima_jiantou.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    holder.tv_jianjie.setVisibility(View.GONE);
                    liu=1;
                }


            }
        });
        url = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+list.get(i).getId()+"&client=androidapp";;
//        holder.ima_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    holder.ima_bt.setVisibility(View.GONE);
//                    holder.ima_icom.setVisibility(View.GONE);
//                    holder.player.setVisibility(View.VISIBLE);
//
//            }
//        });
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                liveChinaLiveBean = gson.fromJson(string, LiveChinaLiveBean.class);
                Log.e("duhduhih0", liveChinaLiveBean.getPublicX());
                FragmentActivity activity = App.lastfragment.getActivity();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {



                                flv2 = liveChinaLiveBean.getHls_url().getHls2();
                                holder.player.setVisibility(View.VISIBLE);
                                holder.player.setUp(flv2, "xxxx");

                                holder.player.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);



                        //holder.tv_jianjie.setText(list.get(i).getBrief());
                        //Log.e("22----------", holder.play.toString());

                    }
                });
            }
        });




        return view;
    }

    class ViewHolder{
        ImageView ima_icom,ima_bt,ima_jiantou;
        TextView tv_title,tv_jianjie;
        JCVideoPlayer player;
    }
}
