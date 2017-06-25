package com.kevin.tech.myandroid.main.home.fragmnet1;

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
import com.kevin.tech.myandroid.base.BaseApplication;
import com.kevin.tech.myandroid.base.BaseFragment;
import com.kevin.tech.myandroid.bean.MyJoke;
import com.kevin.tech.myandroid.utils.NetUtils;
import com.kevin.tech.myandroid.utils.ToastUtils;
import com.kevin.tech.myandroid.view.DividerItemDecoration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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


public class Fragment1 extends BaseFragment implements Fragment1Contract.View, View.OnClickListener, RecyclerViewAdapter.onItemClickListener {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.pb_progress_bar)
    ProgressBar pbProgressBar;
    private Fragment1Contract.Presenter mPresenter;
    private RecyclerViewAdapter mAdapter;
    Unbinder unbinder;

    public static Fragment1 newInstance(String s) {
        Fragment1 fragment1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.ARGS, s);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new Fragment1Presenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_content, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String s = bundle.getString(Constant.ARGS);
        textView.setText(s);
        textView.setVisibility(View.GONE);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerViewAdapter(new ArrayList<MyJoke>(0));
        rvRecyclerView.setAdapter(mAdapter);
        rvRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST));
        mAdapter.setItemClickListener(this);
        initLoadingDialog();
        if (!NetUtils.isNetworkAvailable(BaseApplication.getContext())) {
            ToastUtils.showMyToast(mActivity, "没有网络");
        } else {
            mPresenter.loadData();
        }
//        getMD5("12369");
        return view;
    }

    public static String getMD5(String str) {
        StringBuffer buf = new StringBuffer("");
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");

            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("32位：result: " + buf.toString());//32位的加密
        System.out.println("16位：result: " + buf.toString().substring(8, 24));//16位的加密
        return buf.toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(Fragment1Contract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProgressBar() {
//        pbProgressBar.setVisibility(View.VISIBLE);
        showLoadingDialog();
    }

    @Override
    public void hideProgeressBar() {
//        pbProgressBar.setVisibility(View.GONE);
        dismissLoadingDialog();

    }

    @Override
    public void addData(List<MyJoke> data) {
        mAdapter.setNewData(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onItemClick(int position) {
        showToast("你点击了第" + position + "条");
//        mAdapter.deleteItem(position);
//        mAdapter.notifyDataSetChanged();
    }
}
