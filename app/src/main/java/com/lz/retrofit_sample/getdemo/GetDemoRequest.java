package com.lz.retrofit_sample.getdemo;

import com.lz.retrofit_sample.headerdemo.User;
import com.lz.retrofit_sample.simpledemo.Repo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetDemoRequest {

    public Response<User> getRequestWithParam() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetDemoService service = retrofit.create(GetDemoService.class);
        Call<User> call = service.getWithParams();
        return call.execute();
    }

    public Response<List<Repo>> getRequestWithParam2() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetDemoService service = retrofit.create(GetDemoService.class);
        Call<List<Repo>> call = service.getWithParams2("octocat");
        return call.execute();
    }

    public Response<List<Repo>> getRequestWithParam3() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetDemoService service = retrofit.create(GetDemoService.class);
        Call<List<Repo>> call = service.getWithParams3("octocat", "desc");
        return call.execute();
    }

    public Response<List<Repo>> getRequestWithParam4() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetDemoService service = retrofit.create(GetDemoService.class);
        Map<String, String> options = new HashMap<>();
        options.put("sort", "desc");
        Call<List<Repo>> call = service.getWithParams4("octocat", options);
        return call.execute();
    }
}
