package com.kevin.tech.myandroid.main;

import com.kevin.tech.myandroid.BasePresenter;
import com.kevin.tech.myandroid.BaseView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/4.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public interface MainContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
