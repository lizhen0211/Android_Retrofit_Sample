package com.lz.retrofit_sample.getdemo;

import com.lz.retrofit_sample.headerdemo.User;
import com.lz.retrofit_sample.simpledemo.Repo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface GetDemoService {

    /**
     * https://api.github.com/users/list?sort=desc
     *
     * @return
     */
    @GET("users/list?sort=desc")
    Call<User> getWithParams();

    /**
     * https://api.github.com/group/Square/users
     * <p>
     * A request URL can be updated dynamically using replacement blocks and parameters on the method.
     * A replacement block is an alphanumeric string surrounded by { and }.
     * A corresponding parameter must be annotated with @Path using the same string.
     *
     * @param username
     * @return
     */
    @GET("/users/{username}/repos")
    Call<List<Repo>> getWithParams2(@Path("username") String username);

    /**
     * https://api.github.com/users/octocat/repos?sort=desc
     * <p>
     * Query parameters can also be added.
     *
     * @param username
     * @param sort
     * @return
     */
    @GET("/users/{username}/repos")
    Call<List<Repo>> getWithParams3(@Path("username") String username, @Query("sort") String sort);

    /**
     * For complex query parameter combinations a Map can be used.
     *
     * @param username
     * @param options
     * @return
     */
    @GET("users/{username}/repos")
    Call<List<Repo>> getWithParams4(@Path("username") String username, @QueryMap Map<String, String> options);
}
