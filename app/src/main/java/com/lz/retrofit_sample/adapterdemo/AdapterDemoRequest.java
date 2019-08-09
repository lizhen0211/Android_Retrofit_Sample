package com.lz.retrofit_sample.adapterdemo;

import com.lz.retrofit_sample.convertdemo.gsonconverter.GsonConverterFactory;

import java.io.IOException;

import retrofit2.Retrofit;

public class AdapterDemoRequest {

    public void getIp(ErrorHandlingAdapter.MyCallback<Ip> myCallback) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://httpbin.org/")
                .addCallAdapterFactory(new ErrorHandlingAdapter.ErrorHandlingCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AdapterDemoService service = retrofit.create(AdapterDemoService.class);
        ErrorHandlingAdapter.MyCall<Ip> call = service.getIp();
        call.enqueue(myCallback);
    }
}

