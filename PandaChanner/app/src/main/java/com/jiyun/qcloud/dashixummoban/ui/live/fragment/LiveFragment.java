package com.jiyun.qcloud.dashixummoban.ui.live.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Live.LiveBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivevedioBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.MoreBeans;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.MyAdapter;
import com.jiyun.qcloud.dashixummoban.ui.live.live_fragment.LookFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.live_fragment.MoreFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.network.LiveContract;
import com.jiyun.qcloud.dashixummoban.ui.live.network.LivePresenter;
import com.jiyun.qcloud.dashixummoban.ui.live.view.MyMediaController;
import com.jiyun.qcloud.dashixummoban.ui.live.view.NoScrollViewPager;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by lenovo on 2017/8/23.
 */

//  pla_pause.png
public class LiveFragment extends BaseFragment implements LiveContract.View {
    @BindView(R.id.icon_layout)
    AutoRelativeLayout iconLayout;
    @BindView(R.id.live_down)
    ImageView liveDown;
    @BindView(R.id.live_tabLayout_fragment)
    TabLayout liveTabLayoutFragment;
    @BindView(R.id.live_viewPager_fragment)
    NoScrollViewPager liveViewPagerFragment;
    Unbinder unbinder;
    @BindView(R.id.live_brief)
    TextView liveBrief;
    @BindView(R.id.live_title)
    TextView liveTitle;
    @BindView(R.id.vitamio)
    VideoView vitamio;
    @BindView(R.id.icon)
    ImageView icon;
    private List<Fragment> list;
    private MyAdapter adapter;
    private int curr = 1;
    private LiveContract.Presenter presenter;
    private MediaController mMediaController;
    private MoreBeans.ListBean listBean;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            listBean = (MoreBeans.ListBean) intent.getSerializableExtra("listBean");
            presenter.getVedio("http://vdn.live.cntv.cn/api2/live.do?client=androidapp&channel=pa://cctv_p2p_hd" + listBean.getId());
            liveTitle.setText("【正在直播】" + listBean.getTitle());
        }
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.live_fragment;
    }

    @Override
    protected void initData() {
        presenter = new LivePresenter(this);
        presenter.start();
    }


    @Override
    protected void initView(View view) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("hc");
        getActivity().registerReceiver(receiver, intentFilter);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        list = new ArrayList<>();
        list.add(new MoreFragment());
        list.add(new LookFragment());
        adapter = new MyAdapter(getChildFragmentManager(), list);
        liveViewPagerFragment.setAdapter(adapter);
        setTabLayout();
        return rootView;
    }

    private void setTabLayout() {
        liveViewPagerFragment.setScrollable(false);
        liveViewPagerFragment.setOffscreenPageLimit(2);
        liveTabLayoutFragment.setSelectedTabIndicatorColor(Color.parseColor("#3F51B5"));
        liveTabLayoutFragment.setTabTextColors(Color.BLACK, Color.parseColor("#3F51B5"));
        LinearLayout linearLayout = (LinearLayout) liveTabLayoutFragment.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));
        liveTabLayoutFragment.setupWithViewPager(liveViewPagerFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(LiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showHomeListData(LiveBeans liveBeans) {
        liveBrief.setText(liveBeans.getLive().get(0).getBrief());
    }

    @Override
    public void showVedioList(LivevedioBeans livevedioBeans) {
        vitamio.setVisibility(View.VISIBLE);
        icon.setVisibility(View.GONE);
        String flv2 = livevedioBeans.getFlv_url().getFlv2();
        vitamio.setVideoURI(Uri.parse(flv2));
        mMediaController = new MyMediaController(getContext(), vitamio, getActivity());
        mMediaController.show(5000);//控制器显示5s后自动隐藏
        vitamio.setMediaController(mMediaController);//绑定控制器
        vitamio.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//设置播放画质 高画质
        vitamio.requestFocus();//取得焦点
    }

    @OnClick({R.id.live_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.live_down:
                if (curr == 1) {
                    liveBrief.setVisibility(View.VISIBLE);
                    liveDown.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    curr = 0;
                } else if (curr == 0) {
                    liveBrief.setVisibility(View.GONE);
                    liveDown.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    curr = 1;
                }
                break;
        }
    }
}
