package com.lz.retrofit_sample.simpledemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SimpleDemoService {

    /**
     * https://api.github.com/users/octocat/repos
     *
     * @param user
     * @return
     */
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
