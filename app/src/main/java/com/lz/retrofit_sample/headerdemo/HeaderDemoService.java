package com.lz.retrofit_sample.headerdemo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface HeaderDemoService {

    /**
     * https://api.github.com/users/octocat
     * <p>
     * You can set static headers for a method using the @Headers annotation.
     *
     * @return
     */
    @Headers("Cache-Control: max-age=640000")
    @GET("users")
    Call<List<User>> getUsers();


    /**
     * Note that headers do not overwrite each other.
     * All headers with the same name will be included in the request.
     *
     * @param username
     * @return
     */
    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);


    /**
     * A request Header can be updated dynamically using the @Header annotation.
     * A corresponding parameter must be provided to the @Header.
     * If the value is null, the header will be omitted.
     * Otherwise, toString will be called on the value, and the result used.
     *
     * @param authorization
     * @return
     */
    @GET("user")
    Call<User> getUserWithAuth(@Header("Authorization") String authorization);

    /**
     * Similar to query parameters, for complex header combinations, a Map can be used.
     * <p>
     * Headers that need to be added to every request can be specified using an OkHttp interceptor.
     *
     * @param headers
     * @return
     */
    @GET("user")
    Call<User> getUser(@HeaderMap Map<String, String> headers);
}
