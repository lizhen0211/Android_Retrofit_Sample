package com.lz.retrofit_sample.headerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lz.retrofit_sample.R;
import com.lz.retrofit_sample.getdemo.GetDemoActivity;
import com.lz.retrofit_sample.getdemo.GetDemoRequest;
import com.lz.retrofit_sample.getdemo.GetDemoService;
import com.lz.retrofit_sample.simpledemo.Repo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeaderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
    }

    public void onHeaderParam1Click(View view) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HeaderDemoRequest request = new HeaderDemoRequest();
                try {
                    Response<List<User>> response = request.getUsers();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onHeaderParam2Click(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HeaderDemoRequest request = new HeaderDemoRequest();
                try {
                    Response<User> response = request.getUser();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
