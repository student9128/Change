package com.kevin.tech.change.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kevin.tech.change.view.LoadingDialog;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class BaseActivity extends AppCompatActivity {
    private LoadingDialog mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = new LoadingDialog();
    }
}
