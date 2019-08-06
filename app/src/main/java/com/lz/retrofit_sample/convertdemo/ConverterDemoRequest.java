package com.lz.retrofit_sample.convertdemo;

import com.lz.retrofit_sample.convertdemo.gsonconverter.GsonConverterFactory;
import com.lz.retrofit_sample.convertdemo.moshiconverter.MoshiConverterFactory;
import com.lz.retrofit_sample.headerdemo.User;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConverterDemoRequest {

    public Response<ResponseBody> withoutConverter() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        ConverterDemoService service = retrofit.create(ConverterDemoService.class);
        Call<ResponseBody> call = service.withoutConverter();
        return call.execute();
    }

    public Response<User> gsonConverter() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConverterDemoService service = retrofit.create(ConverterDemoService.class);
        Call<User> call = service.gsonConverter();
        return call.execute();
    }

    public Response<User> moshiConverter() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        ConverterDemoService service = retrofit.create(ConverterDemoService.class);
        Call<User> call = service.moshiConverter();
        return call.execute();
    }
}
