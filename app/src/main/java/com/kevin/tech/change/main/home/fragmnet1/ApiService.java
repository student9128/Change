package com.kevin.tech.change.main.home.fragmnet1;

import com.kevin.tech.change.bean.MyJoke;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public interface ApiService {
    @GET("xiaohua.json")
    Observable<List<MyJoke>> getData();

    @GET("?essence=1&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&manifest_version_code=612&resolution=1450*2800&dpi=620&update_version_code=6120")
    Observable<Map<String,Object>> getJoke();
}

