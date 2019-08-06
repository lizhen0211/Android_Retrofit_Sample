package com.lz.retrofit_sample.headerdemo;

import android.view.View;

import com.lz.retrofit_sample.simpledemo.Repo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeaderDemoRequest {

    public Response<List<User>> getUsers() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeaderDemoService service = retrofit.create(HeaderDemoService.class);
        Call<List<User>> call = service.getUsers();
        return call.execute();
    }

    public Response<User> getUser() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HeaderDemoService service = retrofit.create(HeaderDemoService.class);
        Call<User> call = service.getUser("octocat");
        return call.execute();
    }
}
