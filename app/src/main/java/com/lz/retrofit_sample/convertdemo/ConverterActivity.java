package com.lz.retrofit_sample.convertdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lz.retrofit_sample.R;
import com.lz.retrofit_sample.getdemo.GetDemoActivity;
import com.lz.retrofit_sample.headerdemo.User;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class ConverterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
    }

    public void onNotspecifyConvertClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ConverterDemoRequest request = new ConverterDemoRequest();
                try {
                    Response<ResponseBody> response = request.withoutConverter();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onGsonConvertClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ConverterDemoRequest request = new ConverterDemoRequest();
                try {
                    Response<User> response = request.gsonConverter();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onMoshiConverterClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ConverterDemoRequest request = new ConverterDemoRequest();
                try {
                    Response<User> response = request.moshiConverter();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
