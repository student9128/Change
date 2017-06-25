package com.kevin.tech.change.main.home.fragmnet1;

import com.kevin.tech.change.BasePresenter;
import com.kevin.tech.change.BaseView;
import com.kevin.tech.change.bean.MyJoke;

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
