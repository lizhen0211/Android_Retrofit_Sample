package com.lz.retrofit_sample.postdemo;

import com.google.gson.JsonObject;
import com.lz.retrofit_sample.convertdemo.gsonconverter.GsonConverterFactory;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PostDemoRequest {

    public Response<ResponseBean> postWithBody(PersonBody body) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostDemoService service = retrofit.create(PostDemoService.class);
        Call<ResponseBean> call = service.postWithBody(body);
        return call.execute();
    }

    public Response<JsonObject> postFormUrlEncoded() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostDemoService service = retrofit.create(PostDemoService.class);
        Call<JsonObject> call = service.postFormUrlEncoded("AAA", "BBB");
        return call.execute();
    }

    public Response<JsonObject> multipartRequests(File file) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostDemoService service = retrofit.create(PostDemoService.class);

        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("", file.getName(), fileReqBody);
        MultipartBody.Part stringPart = MultipartBody.Part.createFormData("","");
        String descriptionString = "hello, this is desc";
        RequestBody descBody = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
        Call<JsonObject> call = service.uploadImage(filePart, stringPart,descBody);
        return call.execute();
    }
}
