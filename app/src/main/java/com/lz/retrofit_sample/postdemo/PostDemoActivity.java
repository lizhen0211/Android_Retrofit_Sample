package com.lz.retrofit_sample.postdemo;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lz.retrofit_sample.R;
import com.lz.retrofit_sample.getdemo.GetDemoActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class PostDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_demo);
    }

    public void onJsonPostClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PostDemoRequest request = new PostDemoRequest();
                try {
                    PersonBody personBody = new PersonBody();
                    personBody.setAge(20);
                    personBody.setGender(1);
                    personBody.setName("Jack");
                    Response<ResponseBean> responseBeanResponse = request.postWithBody(personBody);
                    String resultStr = new Gson().toJson(responseBeanResponse.body());
                    Log.e(GetDemoActivity.class.getSimpleName(), resultStr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onFormUrlPostClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PostDemoRequest request = new PostDemoRequest();
                try {
                    Response<JsonObject> responseBeanResponse = request.postFormUrlEncoded();
                    Log.e(GetDemoActivity.class.getSimpleName(), responseBeanResponse.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onMultipartRequestClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PostDemoRequest request = new PostDemoRequest();
                try {
                    List<String> imageURIs = getImageURIs(PostDemoActivity.this);
                    List<String> strings = filterImages(PostDemoActivity.this, imageURIs);
                    File file = new File(strings.get(0));
                    Response<JsonObject> responseBeanResponse = request.multipartRequests(file);
                    Log.e(GetDemoActivity.class.getSimpleName(), responseBeanResponse.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public static List<String> getImageURIs(Context context) {
        List<String> list = new ArrayList<String>();
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, null, null, MediaStore.Images.Media.DATE_ADDED);
        while (cursor.moveToNext()) {
            String uri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            list.add(uri);
        }
        return list;
    }

    public static List<String> filterImages(Context context, List<String> imageURIsTemp) {
        List<String> imageURIs = new ArrayList<String>();
        for (String uri : imageURIsTemp) {
            if (!TextUtils.isEmpty(uri) && isImageExist(uri)) {
                int index = uri.lastIndexOf(".");
                if (index != -1) {
                    String suffix = uri.substring(index + 1);
                    if ("bmp".equalsIgnoreCase(suffix)
                            || "jpg".equalsIgnoreCase(suffix)
                            || "png".equalsIgnoreCase(suffix)
                            || "jpeg".equalsIgnoreCase(suffix)
                            || "webp".equalsIgnoreCase(suffix)) {
                        imageURIs.add(uri);
                    }
                }
            }
        }
        return imageURIs;
    }

    public static boolean isImageExist(String url) {
        boolean flag = false;
        if (!TextUtils.isEmpty(url)) {
            File file = new File(url);
            if (file.exists()) {
                flag = true;
            }
        }
        return flag;
    }
}
