package com.lz.retrofit_sample.simpledemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lz.retrofit_sample.R;

import java.io.IOException;
import java.util.List;

import okhttp3.Headers;
import retrofit2.Response;

public class SimpleDemoActivity extends Activity {

    private static final String TAG = SimpleDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_demo);
    }

    public void onSimpleGetClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDemoRequest simpleDemoRequest = new SimpleDemoRequest();
                try {
                    Response<List<Repo>> response = simpleDemoRequest.listReposByUser();
                    Log.e(SimpleDemoService.class.getSimpleName(), response + "");

                    Headers headers = response.headers();
                    Log.e(TAG + ":" + "headers", headers.toString());
                    String message = response.message();
                    Log.e(TAG + ":" + "message", message);
                    boolean successful = response.isSuccessful();
                    int code = response.code();
                    Log.e(TAG + ":" + "successful&code", successful + " " + code);
                    for (Repo repo : response.body()) {
                        Log.e(TAG, repo.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
