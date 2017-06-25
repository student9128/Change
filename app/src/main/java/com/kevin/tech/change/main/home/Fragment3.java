package com.kevin.tech.change.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.tech.change.Constant;
import com.kevin.tech.change.R;

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


public class Fragment3 extends Fragment {
    @BindView(R.id.textView)
    TextView textView;
    Unbinder unbinder;

    public static Fragment3 newInstance(String s) {
        Fragment3 fragment1 = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.ARGS, s);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_content, container, false);
        unbinder = ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String s = bundle.getString(Constant.ARGS);
        textView.setText(s);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
