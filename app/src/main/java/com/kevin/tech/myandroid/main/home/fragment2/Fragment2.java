package com.kevin.tech.myandroid.main.home.fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kevin.tech.myandroid.Constant;
import com.kevin.tech.myandroid.R;
import com.kevin.tech.myandroid.adapter.RecyclerViewAdapter;
import com.kevin.tech.myandroid.base.BaseFragment;
import com.kevin.tech.myandroid.view.DividerItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class Fragment2 extends BaseFragment implements Fragment2Contract.View {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.pb_progress_bar)
    ProgressBar pbProgressBar;
    private RecyclerViewAdapter mAdapter;
    Unbinder unbinder;

    private Fragment2Contract.Presenter mPresenter;

    public static Fragment2 newInstance(String s) {
        Fragment2 fragment1 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.ARGS, s);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new Fragment2Presenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_content, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String s = bundle.getString(Constant.ARGS);
        textView.setText(s);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        rvRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        initLoadingDialog();
        mPresenter.loadData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(Fragment2Contract.Presenter presenter) {

    }

    @Override
    public void showProgressBar() {
        showLoadingDialog();
    }

    @Override
    public void hideProgeressBar() {
        dismissLoadingDialog();
    }
}
