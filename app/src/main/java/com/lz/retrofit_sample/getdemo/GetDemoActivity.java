package com.lz.retrofit_sample.getdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lz.retrofit_sample.R;
import com.lz.retrofit_sample.headerdemo.User;
import com.lz.retrofit_sample.simpledemo.Repo;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class GetDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_demo);
    }

    public void onSimpleGetClick(View view) {
        Toast.makeText(this, "参考SimpleDemo", Toast.LENGTH_SHORT).show();
    }

    public void onGetWithParam1Click(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GetDemoRequest request = new GetDemoRequest();
                try {
                    Response<User> response = request.getRequestWithParam();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onGetWithParam2Click(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GetDemoRequest request = new GetDemoRequest();
                try {
                    Response<List<Repo>> response = request.getRequestWithParam2();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onGetWithParam3Click(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GetDemoRequest request = new GetDemoRequest();
                try {
                    Response<List<Repo>> response = request.getRequestWithParam3();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onGetWithParam4Click(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GetDemoRequest request = new GetDemoRequest();
                try {
                    Response<List<Repo>> response = request.getRequestWithParam4();
                    Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
