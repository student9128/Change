package com.kevin.tech.myandroid.main.home.fragmnet1;

import com.kevin.tech.myandroid.BasePresenter;
import com.kevin.tech.myandroid.BaseView;
import com.kevin.tech.myandroid.bean.MyJoke;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public interface Fragment1Contract {
    interface View extends BaseView<Fragment1Contract.Presenter> {
        void showProgressBar();

        void hideProgeressBar();

        void addData(List<MyJoke> data);

    }

    interface Presenter extends BasePresenter {
        void loadData();

    }
}
