package com.kevin.tech.change.main.home.fragmnet1;

import android.util.Log;

import com.kevin.tech.change.bean.MyJoke;
import com.kevin.tech.change.http.AppRetrofit;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class Fragment1Presenter implements Fragment1Contract.Presenter {
    private Fragment1Contract.View mView;

    public Fragment1Presenter(Fragment1Contract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void loadData() {

        mView.showProgressBar();
        AppRetrofit.getInstance("http://api.laifudao.com/open/")
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MyJoke>>() {
                    Disposable disposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        this.disposable = d;
                    }

                    @Override
                    public void onNext(@NonNull List<MyJoke> myJokes) {
                        mView.addData(myJokes);
//                mView.hideProgeressBar();
                        Log.d("Next:\t", "获取数据完成：" + myJokes.size());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.hideProgeressBar();
                        Log.d("Next:\t", "Error：" + e.toString());
                        disposable.dispose();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgeressBar();
                        Log.d("Next:\t", "complete");
                        disposable.dispose();
                    }
                });


//        HttpMethods.getInstance().getJoke(new Observer<List<MyJoke>>() {
//            Disposable disposable;
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                this.disposable = d;
//            }
//
//            @Override
//            public void onNext(List<MyJoke> myJokes) {
//                mView.addData(myJokes);
////                mView.hideProgeressBar();
//                Log.d("Next:\t", "获取数据完成：" + myJokes.size());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                mView.hideProgeressBar();
//                Log.d("Next:\t", "Error：" + e.toString());
//                disposable.dispose();
//            }
//
//            @Override
//            public void onComplete() {
//                mView.hideProgeressBar();
//                Log.d("Next:\t", "complete");
//                disposable.dispose();
//            }
//        });
    }
}
