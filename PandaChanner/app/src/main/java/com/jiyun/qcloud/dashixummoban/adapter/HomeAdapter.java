package com.jiyun.qcloud.dashixummoban.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.entity.Home2;
import com.jiyun.qcloud.dashixummoban.entity.Home3;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.main.IjkFullscreenActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/8/24 0024.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {
    private final PandaHome.DataBean data;
    private final Home2 home2;
    private final Home3 home3;
    public ArrayList<String> datas = new ArrayList<>();
    ArrayList<String> image = new ArrayList<>();
    private Context context;

    public HomeAdapter(PandaHome.DataBean data, Home2 home2, Home3 home3) {
        this.data = data;
        this.home2 = home2;
        this.home3=home3;
        for (int i = 0; i < data.getBigImg().size(); i++) {
            image.add(data.getBigImg().get(i).getImage());
            datas.add(data.getBigImg().get(i).getTitle());
        }
    }

//创建新View，被LayoutManager所调用

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.rollview_home, null);
        View view = LayoutInflater.from(context).inflate(R.layout.home_item, viewGroup, false);
        View home_zhi = LayoutInflater.from(context).inflate(R.layout.home_zhi, viewGroup, false);
        if (viewType == 0) {
            Holder ag = new Holder(inflate);
            return ag;
        } else if (viewType == 1) {
            Holder vh = new Holder(view);
            return vh;
        } else if (viewType == 2 || viewType == 3||viewType==4||viewType==5) {
            Holder vh = new Holder(home_zhi);
            return vh;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if (position == 0) {
            //设置Banner样式
            holder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片加载器
            holder.banner.setImageLoader(new GlideImageLoader());
            holder.banner.setImages(image);
            //设置Banner动画效果
            // holder.banner.setBannerAnimation(Transformer.DepthPage);
            //设置Banner标题集合（当banner样式有显示title时）
            holder.banner.setBannerTitles(datas);
            //设置轮播时间
            holder.banner.setDelayTime(2000);
            //设置指示器位置（当banner模式中有指示器时）
            holder.banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //Banner设置方法全部调用完毕时最后调用
            holder.banner.start();
            holder.banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("mp4",data.getBigImg().get(position).getPid());
                    intent.putExtra("name",datas.get(position));
                    context.startActivity(intent);
                }
            });
        } else if (position == 1) {
            final List<PandaHome.DataBean.PandaeyeBean.ItemsBean> items = data.getPandaeye().getItems();
            holder.be.setText(data.getPandaeye().getTitle());
            Glide.with(context).load(data.getPandaeye().getPandaeyelogo()).into(holder.be_image);
            holder.be_textlive.setText(items.get(0).getBrief());
            holder.be_textfa.setText(items.get(1).getBrief());
            holder.be_textlivetitle.setText(items.get(0).getTitle());
            holder.be_textfatextle.setText(items.get(1).getTitle());
            holder.be_textlivetitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("mp4",items.get(0).getPid());
                    intent.putExtra("name",items.get(0).getTitle());
                    context.startActivity(intent);
                }
            });
            holder.be_textfatextle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("mp4",items.get(1).getPid());
                    intent.putExtra("name",items.get(1).getTitle());
                    context.startActivity(intent);
                }
            });
        } else if (position == 2) {
            holder.zhi.setText(data.getPandalive().getTitle());
            final List<PandaHome.DataBean.PandaliveBean.ListBean> list = data.getPandalive().getList();
            GridviewAdapter adapter = new GridviewAdapter(context, list);
            holder.zhiGrid.setAdapter(adapter);
            holder.zhiGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("name",list.get(i).getTitle());
                    context.startActivity(intent);
                }
            });
        } else if (position == 3) {
            holder.zhi.setText(data.getCctv().getTitle());
            final List<Home2.ListBean> list = home2.getList();
            GridviewCctv adapter=new GridviewCctv(context,list);
            holder.zhiGrid.setNumColumns(2);
            holder.zhiGrid.setAdapter(adapter);
            holder.zhiGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("mp4",list.get(i).getPid());
                    intent.putExtra("name",list.get(i).getTitle());
                    context.startActivity(intent);
                }
            });
        }else if (position==4){
            holder.zhi.setText(data.getList().get(0).getTitle());
            final List<Home3.ListBean> list = home3.getList();
            GridList gridList=new GridList(context,list);
            holder.zhiGrid.setNumColumns(1);
            holder.zhiGrid.setAdapter(gridList);
            holder.zhiGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("mp4",list.get(i).getPid());
                    intent.putExtra("name",list.get(i).getTitle());
                    context.startActivity(intent);
                }
            });
        }else if (position==5){
            holder.zhi.setText(data.getChinalive().getTitle());
            final List<PandaHome.DataBean.ChinaliveBean.ListBeanXX> Chinalive = data.getChinalive().getList();
            GridChinalive adapter=new GridChinalive(context,Chinalive);
            holder.zhiGrid.setAdapter(adapter);
            holder.zhiGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, IjkFullscreenActivity.class);
                    intent.putExtra("name",data.getChinalive().getTitle());
                    context.startActivity(intent);
                }
            });
        }
    }

//将数据与界面进行绑定的操作


//获取数据的数量

    @Override
    public int getItemCount() {

        return 6;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class Holder extends RecyclerView.ViewHolder {
        private ImageView be_image;
        private TextView be_textlive;
        private TextView be_textlivetitle;
        private TextView be_textfa;
        private TextView be_textfatextle;
        private TextView be;
        private Banner banner;
        private TextView zhi;
        private GridView zhiGrid;

        public Holder(View view) {
            super(view);
            banner = (Banner) view.findViewById(R.id.banner);
            be_image = view.findViewById(R.id.be_image);
            be_textlive = view.findViewById(R.id.be_textlive);
            be_textlivetitle = view.findViewById(R.id.be_textlivetitle);
            be_textfa = view.findViewById(R.id.be_textfa);
            be_textfatextle = view.findViewById(R.id.be_textfatextle);
            be = view.findViewById(R.id.be);
            zhi = view.findViewById(R.id.zhi);
            zhiGrid = view.findViewById(R.id.zhi_grid);
        }

    }
}
