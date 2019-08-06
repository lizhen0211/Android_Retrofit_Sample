package com.lz.retrofit_sample.asyncdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lz.retrofit_sample.R;
import com.lz.retrofit_sample.getdemo.GetDemoActivity;
import com.lz.retrofit_sample.headerdemo.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * SYNCHRONOUS VS. ASYNCHRONOUS
 * Call instances can be executed either synchronously or asynchronously.
 * Each instance can only be used once, but calling clone() will create a new instance that can be used.
 * <p>
 * On Android, callbacks will be executed on the main thread.
 * On the JVM, callbacks will happen on the same thread that executed the HTTP request.
 */
public class AsyncActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
    }

    public void onAsyncRequest1Click(View view) {
        AsyncDemoRequest request = new AsyncDemoRequest();
        request.async1(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e(GetDemoActivity.class.getSimpleName(), response.body().toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
