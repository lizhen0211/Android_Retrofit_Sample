package com.lz.retrofit_sample.adapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lz.retrofit_sample.R;

import java.io.IOException;

import retrofit2.Response;

public class AdapterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
    }

    public void onErrorHandlingAdapterClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                AdapterDemoRequest request = new AdapterDemoRequest();
                try {
                    request.getIp(new ErrorHandlingAdapter.MyCallback<Ip>() {
                        @Override
                        public void success(Response<Ip> response) {
                            Log.e(AdapterActivity.class.getSimpleName(), ("SUCCESS! " + response.body().origin));
                        }

                        @Override
                        public void unauthenticated(Response<?> response) {
                            Log.e(AdapterActivity.class.getSimpleName(), "UNAUTHENTICATED");
                        }

                        @Override
                        public void clientError(Response<?> response) {
                            Log.e(AdapterActivity.class.getSimpleName(), "CLIENT ERROR " + response.code() + " " + response.message());
                        }

                        @Override
                        public void serverError(Response<?> response) {
                            Log.e(AdapterActivity.class.getSimpleName(), "SERVER ERROR " + response.code() + " " + response.message());
                        }

                        @Override
                        public void networkError(IOException e) {
                            Log.e(AdapterActivity.class.getSimpleName(), "NETWORK ERROR " + e.getMessage());
                        }

                        @Override
                        public void unexpectedError(Throwable t) {
                            Log.e(AdapterActivity.class.getSimpleName(), "FATAL ERROR " + t.getMessage());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
