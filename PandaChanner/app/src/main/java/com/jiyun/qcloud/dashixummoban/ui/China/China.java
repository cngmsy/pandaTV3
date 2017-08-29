package com.jiyun.qcloud.dashixummoban.ui.China;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.ChinaBean;
import com.jiyun.qcloud.dashixummoban.ui.China.dizhi.Badaling;
import com.jiyun.qcloud.dashixummoban.ui.home.ChinaContract;
import com.jiyun.qcloud.dashixummoban.ui.home.ChinaPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/8/23 0023.
 */

public class China extends BaseFragment implements ChinaContract.View{


    @BindView(R.id.my_tab)
    TabLayout myTab;
    @BindView(R.id.jia_but)
    ImageButton jiaBut;
    @BindView(R.id.my_viewpager)
    ViewPager myViewpager;
    private ArrayList<BaseFragment> fragmentArrayList=new ArrayList<>();
    private ArrayList<String> uriArrayList=new ArrayList<>();
    private ArrayList<String> tileArrayList=new ArrayList<>();
    private ArrayList<String> uri=new ArrayList<>();
    private ChinaContract.Presenter presenter;
    ArrayList<String> arrayList1 = new ArrayList<String>();
    private ArrayList<ChinaBean.AlllistBean> alllistBeen=new ArrayList<>();
    private ArrayList<ChinaBean.AlllistBean> tablistBeen=new ArrayList<>();
    private FragmentStatePagerAdapter der;
    private PopupWindow popupWindow;
    private ImageButton close;
    private Button bianji;
    private MyGridLayout grid;
    private MyGridLayout grid2;

    @Override
    protected int getLayoutRes() {
        return R.layout.chian;
    }

    @Override
    protected void initData() {
        presenter=new ChinaPresenter(this);
        presenter.start();


    }

    @Override
    protected void initView(View view) {
        View view2=LayoutInflater.from(getContext()).inflate(R.layout.china_pop,null);
        popupWindow = new PopupWindow(view2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        grid = view2.findViewById(R.id.grid);
        close = view2.findViewById(R.id.bt_close);
        bianji = view2.findViewById(R.id.bt_bianji);
        grid2 = view2.findViewById(R.id.grid2);
        grid2.setEnabled(true);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }


    @OnClick(R.id.jia_but)
    public void onViewClicked() {
        View v=LayoutInflater.from(getContext()).inflate(R.layout.activity_main,null);
        popupWindow.showAsDropDown(v,0,0);
    }

    @Override
    public void showProgress() {
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                Log.e("TAG",arrayList1.size()+"");
                der.notifyDataSetChanged();
            }
        });
        bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if("编辑".equals(bianji.getText().toString())){
                 bianji.setText("完成");
                 grid.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                     @Override
                     public void onItemClick(TextView tv) {
                         grid.setEnabled(true);//设置可拖拽
                         if(arrayList1.size()>4){
                             String s=tv.getText().toString();
                             for(int i=0;i<arrayList1.size();i++){

                                 if(s.equals(arrayList1.get(i))){
                                     arrayList1.remove(i);
                                    // tileArrayList.add(s);
                                     fragmentArrayList.remove(i);
                                 }

                             }
                             //修改
                             tileArrayList.add(tv.getText().toString());
                             arrayList1.remove(tv.getText().toString());
                             grid.removeView(tv);
                             grid2.addItem(tv.getText().toString());
                         }else{
                             Toast.makeText(getActivity(), "不能少于四个栏目", Toast.LENGTH_SHORT).show();
                         }


                     }
                 });

                 grid2.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                     @Override
                     public void onItemClick(TextView tv) {

                         String s = tv.getText().toString();
                         for (int i = 0; i < tileArrayList.size(); i++) {
                             if (s.equals(tileArrayList.get(i))) {
//                                    alllist.remove(i).getTitle();
                                 //arrayList1.add(s);
                                 tileArrayList.remove(i);
                                 fragmentArrayList.add(new Badaling(uri.get(i)));
                             }
                         }
                         grid2.removeView(tv);//移除是需要时间,不能直接添加
                         tileArrayList.remove(tv.getText().toString());
                         arrayList1.add(tv.getText().toString());
                         grid.addItem(tv.getText().toString());
                     }
                 });

             }else if("完成".equals(bianji.getText().toString())){
                 Toast.makeText(getContext(), "dfdfd" + arrayList1.size(), Toast.LENGTH_SHORT).show();
                 grid.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                     @Override
                     public void onItemClick(TextView tv) {
                     }
                 });
                 grid2.setOnItemClickListener(new MyGridLayout.OnItemClickListener() {
                     @Override
                     public void onItemClick(TextView tv) {
                     }
                 });
                 bianji.setText("编辑");
             }
            }

        });
    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(ChinaContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void loadChinaList(ChinaBean chinaBean) {
        List<ChinaBean.TablistBean> tablist = chinaBean.getTablist();
        List<ChinaBean.AlllistBean> alllist = chinaBean.getAlllist();
        /*for(int i=0;i<tablist.size();i++){
            arrayList2.add(tablist.get(i).getTitle());
            fragmentArrayList.add(new Badaling(tablist.get(i).getUrl()));
        }*/
       tablistBeen.addAll(alllist);
        for (int i = 0; i <tablist.size() ; i++) {
            arrayList1.add(tablist.get(i).getTitle());
            fragmentArrayList.add(new Badaling(tablist.get(i).getUrl()));
        }
        for (int i = 0; i <alllist.size() ; i++) {
            uriArrayList.add(tablistBeen.get(i).getUrl());
            tileArrayList.add(tablistBeen.get(i).getTitle());
            uri.add(tablistBeen.get(i).getUrl());
        }
        for (int i = 0; i <arrayList1.size() ; i++) {
            for (int j = 0; j <tileArrayList.size() ; j++) {
                if (arrayList1.get(i).equals(tileArrayList.get(j))){
                    tileArrayList.remove(j);
                }
            }
        }
        grid2.setItemList(tileArrayList);
        grid.setItemList(arrayList1);

        der=new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentArrayList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentArrayList.size();
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return arrayList1.get(position);
            }
        };
            myViewpager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            myViewpager.setAdapter(der);

        myTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        myTab.setupWithViewPager(myViewpager);

    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }
}