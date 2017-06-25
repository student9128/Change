package com.kevin.tech.myandroid.base;

import android.app.Application;
import android.content.Context;
import android.os.Looper;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>BaseApplication.
 * <p>
 */


public class BaseApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }


    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

}
