package com.jiyun.qcloud.dashixummoban.ui.live;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivePageBeans;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.LiveViewPagerAdapter;
import com.jiyun.qcloud.dashixummoban.ui.live.fragment.LiveFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.fragment.MomentFragment;
import com.jiyun.qcloud.dashixummoban.ui.live.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class LivePageFragment extends BaseFragment implements LivepageContract.View {
    @BindView(R.id.live_tablayout)
    TabLayout liveTablayout;
    @BindView(R.id.live_viewPager)
    NoScrollViewPager liveViewPager;
    Unbinder unbinder;
    private LiveViewPagerAdapter adapter;
    private LivepageContract.Presenter presenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initData() {
        presenter = new LivepagePresenter(this);
        presenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
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
    public void setPresenter(LivepageContract.Presenter presenter) {

    }

    @Override
    public void showHomeListData(LivePageBeans livePageBeans) {
        if (livePageBeans != null) {
            List<Fragment> contentList = new ArrayList<>();
            List<String> titleList = new ArrayList<>();
            contentList.add(new LiveFragment());
            for (int x = 0; x < livePageBeans.getTablist().size(); x++) {
                titleList.add(livePageBeans.getTablist().get(x).getTitle());
                if (x > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("vsid", livePageBeans.getTablist().get(x).getId());
                    MomentFragment momentFragment = new MomentFragment();
                    momentFragment.setArguments(bundle);
                    contentList.add(momentFragment);
                }
            }
            adapter = new LiveViewPagerAdapter(getFragmentManager(), titleList, contentList);
            liveViewPager.setAdapter(adapter);
            liveViewPager.setScrollable(false);
            liveTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            liveTablayout.setSelectedTabIndicatorColor(Color.parseColor("#3F51B5"));
            liveTablayout.setTabTextColors(Color.BLACK, Color.parseColor("#3F51B5"));
            LinearLayout linearLayout = (LinearLayout) liveTablayout.getChildAt(0);
            linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                    R.drawable.layout_divider_vertical));
            liveTablayout.setupWithViewPager(liveViewPager);
        }
    }
}
