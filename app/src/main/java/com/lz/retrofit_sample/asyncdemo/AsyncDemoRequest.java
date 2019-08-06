package com.lz.retrofit_sample.asyncdemo;

import com.lz.retrofit_sample.headerdemo.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsyncDemoRequest {

    public void async1(Callback<User> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AsyncDemoService service = retrofit.create(AsyncDemoService.class);
        Call<User> call = service.async1();
        call.enqueue(callback);
    }
}
