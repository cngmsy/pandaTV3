package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.app.App;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.manager.ActivityCollector;
import com.jiyun.qcloud.dashixummoban.manager.FragmentMager;
import com.jiyun.qcloud.dashixummoban.ui.Broadcast.Broadcast;
import com.jiyun.qcloud.dashixummoban.ui.Broadcast.iview.BroadPresenter;
import com.jiyun.qcloud.dashixummoban.ui.China.China;
import com.jiyun.qcloud.dashixummoban.ui.Gun.activity.Gun;
import com.jiyun.qcloud.dashixummoban.ui.Gun.activity.ivewgun.GunPresenter;
import com.jiyun.qcloud.dashixummoban.ui.home.Home2Ptresenter;
import com.jiyun.qcloud.dashixummoban.ui.home.HomePageFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.LivePageFragment;

import butterknife.BindView;
import butterknife.OnClick;
import util.UpdateAppUtils;

/**
 * Created by chj on 2017/8/20.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homePage)
    RadioButton homePage;
    @BindView(R.id.homePandaLive)
    RadioButton homePandaLive;
    @BindView(R.id.homeRollVideo)
    RadioButton homeRollVideo;
    @BindView(R.id.homePandaBroadcast)
    RadioButton homePandaBroadcast;
    @BindView(R.id.homeLiveChina)
    RadioButton homeLiveChina;
    @BindView(R.id.homeBottomGroup)
    RadioGroup homeBottomGroup;
    private FragmentManager fragmentManager;
    private long mExitTime;
    private Intent intent;

    @Override
    protected void initData() {
        UpdateAppUtils.from(this)//Activity名
                .serverVersionCode(2)  //服务器versionCode
                .serverVersionName("2.0") //服务器versionName
                .apkPath("http://123.206.14.104:8080/FileUploadDemo/files/wxl.apk") //最新apk下载地址
                .update();
        personImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DengActivity.class);
                startActivity(intent);
            }
        });
        fragmentManager = App.mBaseActivity.getSupportFragmentManager();
        HomePageFragment homeFragment= (HomePageFragment) FragmentMager.getInstance().start(R.id.container, HomePageFragment.class,false).build();
        //presenter在这里初始化
        new Home2Ptresenter(homeFragment,homeFragment,homeFragment);
    }

    @Override
    protected void initView() {
        intent = new Intent();
        intent.setAction("axcv");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.homePage, R.id.homePandaLive, R.id.homeRollVideo, R.id.homePandaBroadcast, R.id.homeLiveChina, R.id.homeBottomGroup})
    public void onClicks(View view) {
        switch (view.getId()) {
            case R.id.homePage:
                hudongImg.setVisibility(View.VISIBLE);
                iconImg.setVisibility(View.VISIBLE);
                titleTv.setVisibility(View.GONE);
                FragmentMager.getInstance().start(R.id.container, HomePageFragment.class,false).build();
                sendBroadcast(intent);
                break;
            case R.id.homePandaLive:
                hudongImg.setVisibility(View.GONE);
                iconImg.setVisibility(View.GONE);
                titleTv.setVisibility(View.VISIBLE);
                titleTv.setText("熊猫直播");
                FragmentMager.getInstance().start(R.id.container, LivePageFragment.class,false).build();
                sendBroadcast(intent);
                break;
            case R.id.homeRollVideo:
                hudongImg.setVisibility(View.GONE);
                iconImg.setVisibility(View.GONE);
                titleTv.setVisibility(View.VISIBLE);
                titleTv.setText("滚滚视频");
                Gun gun = (Gun) FragmentMager.getInstance().start(R.id.container, Gun.class, false).build();
                new GunPresenter(gun);
                sendBroadcast(intent);
                break;
            case R.id.homePandaBroadcast:
                hudongImg.setVisibility(View.GONE);
                iconImg.setVisibility(View.GONE);
                titleTv.setVisibility(View.VISIBLE);
                titleTv.setText("熊猫播报");
                Broadcast broadcast = (Broadcast) FragmentMager.getInstance().start(R.id.container, Broadcast.class, false).build();
                new BroadPresenter(broadcast);
                sendBroadcast(intent);
                break;
            case R.id.homeLiveChina:
                hudongImg.setVisibility(View.GONE);
                iconImg.setVisibility(View.GONE);
                titleTv.setVisibility(View.VISIBLE);
                titleTv.setText("直播中国");
                FragmentMager.getInstance().start(R.id.container, China.class,false).build();
                sendBroadcast(intent);
                break;
            case R.id.homeBottomGroup:
                break;
        }
    }

    ///////////////////
    /**
     * 自定义回退栈管理；
     * 获取栈顶的fragment的名字，判断名字是否和主页的名字是否一样，
     * 如果一样就退出应用，如果不是就回退上一个fragment；
     *
     * onBackPressed()与onKeyDown
     */
    @Override
    public void onBackPressed() {
        String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomePageFragment".equals(simpleName) ||
                "LivePageFragment".equals(simpleName) ||
                "Gun".equals(simpleName)||
                "Broadcast".equals(simpleName)||
                "China".equals(simpleName)
                ) {
            finish();
        } else {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStackImmediate();//
                String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                App.lastfragment = (BaseFragment) fragmentManager.findFragmentByTag(name);
            }
        }
    }

    /**
     * 双击退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("HomePageFragment".equals(name) ||
                "LivePageFragment".equals(name) ||
                "Gun".equals(name)||
                "Broadcast".equals(name)||
                "China".equals(name)
                ){
            if (keyCode == KeyEvent.KEYCODE_BACK) {//back键被按下了
                if ((System.currentTimeMillis() - mExitTime) > 2000) {//第二次点击判断是否在两秒内完成，是的话Finish掉（退出）
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    ActivityCollector.getInstance().exit(this);
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.hudongImg)
    public void onViewClicked() {
        Intent intent = new Intent(MainActivity.this, InteractionActivity.class);
        startActivity(intent);
    }
    public interface Int {
        void show(String s);
    }
}




