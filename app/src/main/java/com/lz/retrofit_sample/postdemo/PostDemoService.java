package com.lz.retrofit_sample.postdemo;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PostDemoService {

    /**
     * http://httpbin.org/post
     * <p>
     * An object can be specified for use as an HTTP request body with the @Body annotation.
     *
     * @param
     * @return
     */
    @POST("post")
    Call<ResponseBean> postWithBody(@Body PersonBody body);


    /**
     * Form-encoded data is sent when @FormUrlEncoded is present on the method.
     * Each key-value pair is annotated with
     *
     * @param paramA
     * @param paramB
     * @return
     * @Field containing the name and the object providing the value.
     */
    @FormUrlEncoded
    @POST("post")
    Call<JsonObject> postFormUrlEncoded(@Field("param_a") String paramA, @Field("param_b") String paramB);

    /**
     * Multipart requests are used when @Multipart is present on the method. Parts are declared using the @Part annotation.
     * <p>
     * Multipart parts use one of Retrofit's converters or they can implement RequestBody to handle their own serialization.
     *
     * @param file
     * @param body
     * @param description
     * @return
     */
    @Multipart
    @POST("storages/images")
    Call<JsonObject> uploadImage(@Part MultipartBody.Part file,
                                 @Part MultipartBody.Part body,
                                 @Part("description") RequestBody description);

}
