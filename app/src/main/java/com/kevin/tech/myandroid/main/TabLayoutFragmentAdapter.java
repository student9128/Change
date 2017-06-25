package com.kevin.tech.myandroid.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.tech.myandroid.R;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class TabLayoutFragmentAdapter extends FragmentPagerAdapter {
    private List<String> tabList;
    private Context context;
    private List<Fragment> fragments;
    private LinearLayout mTabView;

    public TabLayoutFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabLayoutFragmentAdapter(FragmentManager fm, List<String> tabList, Context context, List<Fragment> fragments) {
        super(fm);
        this.tabList = tabList;
        this.context = context;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_tab_view, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(tabList.get(position));
        textView.setTextColor(ContextCompat.getColor(context,R.color.black));
        if (0 == position) {
            textView.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
            TextPaint tp = textView.getPaint();
            tp.setFakeBoldText(true);
        }
        return view;
    }
}
