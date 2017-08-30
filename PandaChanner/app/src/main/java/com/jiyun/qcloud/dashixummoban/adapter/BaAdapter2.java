package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.app.App;
import com.jiyun.qcloud.dashixummoban.entity.BadaBean;
import com.jiyun.qcloud.dashixummoban.ui.China.LiveChinaLiveBean;

import java.io.IOException;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dell on 2017/8/29.
 */

public class BaAdapter2 extends RecyclerView.Adapter {
    private Context context;
    private List<BadaBean.LiveBean> list;
    private  int liu=1;
    private LiveChinaLiveBean liveChinaLiveBean;
    private String url;
    private String flv2;

    public BaAdapter2(Context context, List<BadaBean.LiveBean> list) {
        this.context = context;
        this.list = list;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView ima_icom,ima_bt,ima_jiantou;
        TextView tv_title,tv_jianjie;
        JCVideoPlayer player;
        public MyHolder(View itemView) {
            super(itemView);
            ima_icom=itemView.findViewById(R.id.lv_icon);
            ima_bt=itemView.findViewById(R.id.lv_bt);
            ima_jiantou=itemView.findViewById(R.id.lv_jiantou);
            tv_title=itemView.findViewById(R.id.lv_title);
            tv_jianjie=itemView.findViewById(R.id.lv_jianjie);
            player=itemView.findViewById(R.id.lv_video);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.lv_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final MyHolder myHolder= (MyHolder) holder;

        Glide.with(context).load(list.get(position).getImage()).into(myHolder.player.ivThumb);
        myHolder.player.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);
        myHolder.ima_bt.setImageResource(R.drawable.newplay);
        myHolder.tv_title.setText("[正在直播]"+list.get(position).getTitle());
        myHolder.tv_jianjie.setText(list.get(position).getBrief());
        myHolder.ima_jiantou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(liu==1){
                    myHolder.ima_jiantou.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    myHolder.tv_jianjie.setVisibility(View.VISIBLE);
                    liu=0;
                }else if(liu==0){
                    myHolder.ima_jiantou.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    myHolder.tv_jianjie.setVisibility(View.GONE);
                    liu=1;
                }
            }
        });
        url = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+list.get(position).getId()+"&client=androidapp";;
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
                FragmentActivity activity = App.lastfragment.getActivity();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        flv2 = liveChinaLiveBean.getHls_url().getHls2();
                        myHolder.player.setVisibility(View.VISIBLE);
                        myHolder.player.setUp(flv2, "xxxx");
                        myHolder.player.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
