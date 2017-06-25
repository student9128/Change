package com.kevin.tech.myandroid.main.home.fragment2;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kevin.tech.myandroid.http.AppRetrofit;
import com.kevin.tech.myandroid.main.home.fragmnet1.ApiService;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/11.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class Fragment2Presenter implements Fragment2Contract.Presenter {
    private Fragment2Contract.View mView;

    public Fragment2Presenter(Fragment2Contract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void loadData() {
        AppRetrofit appRetrofit = new AppRetrofit();
        ApiService apiService = appRetrofit.create(ApiService.class);
//        ApiService apiService = appRetrofit.retrofit.create(ApiService.class);
        apiService.getJoke()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mView.showProgressBar();

                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Map<String, Object>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Map<String, Object> stringObjectMap) {
//                        Gson gson = new Gson();
                        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                        String json = gson.toJson(stringObjectMap);
                        Log.d("Next:===\t", json);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.hideProgeressBar();
                        Log.d("Error", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgeressBar();
                    }
                });


    }
}
