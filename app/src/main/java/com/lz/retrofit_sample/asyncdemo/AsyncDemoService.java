package com.lz.retrofit_sample.asyncdemo;

import com.lz.retrofit_sample.headerdemo.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AsyncDemoService {

    /**
     * https://api.github.com/users/list?sort=desc
     *
     * @return
     */
    @GET("users/list?sort=desc")
    Call<User> async1();
}
