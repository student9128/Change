package com.kevin.tech.change.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by sunfei on 2017/5/13.
 */
public class OkHttpFactory {
    private static OkHttpClient okHttpClient;

    private static void createHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
//                .cookieJar(new CookieJar() {
//                    @Override
//                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//                        CustomCookieStore cookieStore = new CustomCookieStore(context);
//                        for (Cookie cookie : cookies) {
//                            cookieStore.add(url, cookie);
//                        }
//                    }
//
//                    @Override
//                    public List<Cookie> loadForRequest(HttpUrl url) {
////                        Log.e("cookie", "----loadForRequest" + new CustomCookieStore(context).getCookies());
//                        return new CustomCookieStore(context).getCookies();
//                    }
//                })
                .build();
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpFactory.class) {
                if (null == okHttpClient)
                    createHttpClient();
            }
        }
        return okHttpClient;
    }
}
