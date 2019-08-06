package com.lz.retrofit_sample.convertdemo;

import com.lz.retrofit_sample.headerdemo.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ConverterDemoService {

    /**
     * https://api.github.com/users/list?sort=desc
     *
     * @return
     */
    @GET("users/list?sort=desc")
    Call<ResponseBody> withoutConverter();

    /**
     * https://api.github.com/users/list?sort=desc
     *
     * @return
     */
    @GET("users/list?sort=desc")
    Call<User> gsonConverter();

    /**
     * https://api.github.com/users/list?sort=desc
     *
     * @return
     */
    @GET("users/list?sort=desc")
    Call<User> moshiConverter();
}
