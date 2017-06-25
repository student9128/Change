package com.kevin.tech.myandroid.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitWapper {

    private static RetrofitWapper mRetrofitWapper;
    private Retrofit mRetrofit;

    /**
     * 将构造函数私有化
     */
    private RetrofitWapper() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 获取RetrofitWapper实例（单例模式）
     *
     * @return
     */
    public static RetrofitWapper getRetrofitWapperInstance() {
        if (mRetrofitWapper == null) {
            synchronized (RetrofitWapper.class) {
                mRetrofitWapper = new RetrofitWapper();
            }
        }
        return mRetrofitWapper;
    }

    /**
     * 创建接口访问入口
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }


    public class Constant {
        public static final String BASE_URL = "http://lf.snssdk.com/neihan/service/tabs/";
    }

}