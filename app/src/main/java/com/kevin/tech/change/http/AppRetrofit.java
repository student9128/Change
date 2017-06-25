package com.kevin.tech.change.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/11.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class AppRetrofit {
    public static String BASE_URL = "http://lf.snssdk.com/neihan/service/tabs/";
    private static int CONNET_TIME_OUT = 20;
    private static int READ_TIME_OUT = 120;
    private Retrofit retrofit;
    private static AppRetrofit appRetrofit;

    public AppRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(initBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public <T> T create(Class<T> service) {

        return retrofit.create(service);
    }

    public AppRetrofit(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .client(initBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    public AppRetrofit(int connectTimeOut) {
        CONNET_TIME_OUT = connectTimeOut;
        retrofit = new Retrofit.Builder()
                .client(initBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient.Builder initBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        Request newRequest = chain.request().newBuilder()
////                                .addHeader()
//                                .build();
//
//                        return chain.proceed(newRequest);
//                    }
//                });
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        return builder;
    }

    public static AppRetrofit getInstance() {
        if (appRetrofit == null) {
            synchronized (AppRetrofit.class) {
                appRetrofit = new AppRetrofit();
            }
        }
        return appRetrofit;
    }

    public static AppRetrofit getInstance(String baseUrl) {
        if (appRetrofit == null) {
            synchronized (AppRetrofit.class) {
                appRetrofit = new AppRetrofit(baseUrl);
            }
        }
        return appRetrofit;
    }
}
