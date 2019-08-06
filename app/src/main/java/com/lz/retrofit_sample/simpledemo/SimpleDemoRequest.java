package com.lz.retrofit_sample.simpledemo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SimpleDemoRequest {

    public Response<List<Repo>> listReposByUser() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SimpleDemoService service = retrofit.create(SimpleDemoService.class);
        Call<List<Repo>> repos = service.listRepos("octocat");
        return repos.execute();
    }
}
