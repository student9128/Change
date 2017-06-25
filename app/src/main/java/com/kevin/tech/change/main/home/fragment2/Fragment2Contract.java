package com.kevin.tech.change.main.home.fragment2;

import com.kevin.tech.change.BasePresenter;
import com.kevin.tech.change.BaseView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/11.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public interface Fragment2Contract {
    interface View extends BaseView<Fragment2Contract.Presenter> {
        void showProgressBar();

        void hideProgeressBar();

//        void addData(List<MyJoke> data);
    }

    interface Presenter extends BasePresenter {
        void loadData();
    }
}
