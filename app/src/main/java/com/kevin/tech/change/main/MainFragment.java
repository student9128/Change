package com.kevin.tech.change.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.tech.change.NoSmoothViewPager;
import com.kevin.tech.change.R;
import com.kevin.tech.change.base.BaseFragment;
import com.kevin.tech.change.main.home.fragment2.Fragment2;
import com.kevin.tech.change.main.home.Fragment3;
import com.kevin.tech.change.main.home.Fragment4;
import com.kevin.tech.change.main.home.fragmnet1.Fragment1;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/4.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class MainFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.ns_view_pager)
    NoSmoothViewPager nsViewPager;
    Unbinder unbinder;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_function)
    ImageView ivFunction;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    private List<String> mTabList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();
    private TabLayoutFragmentAdapter mAdapter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Constant.ARGS, "");
//        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        AppCompatActivity activity = (AppCompatActivity) this.mActivity;
        activity.setSupportActionBar(toolBar);
        activity.getSupportActionBar().setTitle(null);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        initTabList();
        mAdapter = new TabLayoutFragmentAdapter(getFragmentManager(), mTabList, getActivity(), mFragments);
        nsViewPager.setAdapter(mAdapter);
        nsViewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(nsViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addOnTabSelectedListener(this);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(mAdapter.getTabView(i));
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initFragmentList();
    }

    /**
     * add Fragment
     */
    public void initFragmentList() {
        mFragments.clear();
        mFragments.add(Fragment1.newInstance("Fragment1"));
        mFragments.add(Fragment2.newInstance("Fragment2"));
        mFragments.add(Fragment3.newInstance("Fragment3"));
        mFragments.add(Fragment4.newInstance("Fragment4"));

    }

    private void initTabList() {
        mTabList.clear();
        mTabList.add("Tab1");
        mTabList.add("Tab2");
        mTabList.add("Tab3");
        mTabList.add("Tab4");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView textView = (TextView) customView.findViewById(R.id.textView);
        textView.setTextColor(ContextCompat.getColor(mActivity, R.color.colorPrimary));
        TextPaint tp = textView.getPaint();
        tp.setFakeBoldText(true);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView textView = (TextView) customView.findViewById(R.id.textView);
        textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
        TextPaint tp = textView.getPaint();
        tp.setFakeBoldText(false);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
