package com.lz.retrofit_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lz.retrofit_sample.asyncdemo.AsyncActivity;
import com.lz.retrofit_sample.convertdemo.ConverterActivity;
import com.lz.retrofit_sample.getdemo.GetDemoActivity;
import com.lz.retrofit_sample.headerdemo.HeaderActivity;
import com.lz.retrofit_sample.postdemo.PostDemoActivity;
import com.lz.retrofit_sample.simpledemo.SimpleDemoActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSimpleDemoClick(View view) {
        Intent intent = new Intent(MainActivity.this, SimpleDemoActivity.class);
        startActivity(intent);
    }

    public void onGetDemoClick(View view) {
        Intent intent = new Intent(MainActivity.this, GetDemoActivity.class);
        startActivity(intent);
    }

    public void onPostDemoClick(View view) {
        Intent intent = new Intent(MainActivity.this, PostDemoActivity.class);
        startActivity(intent);
    }

    public void onHeaderDemoClick(View view) {
        Intent intent = new Intent(MainActivity.this, HeaderActivity.class);
        startActivity(intent);
    }

    public void onAsyncClick(View view) {
        Intent intent = new Intent(MainActivity.this, AsyncActivity.class);
        startActivity(intent);
    }

    public void onConvertDemoClick(View view) {
        Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
        startActivity(intent);
    }

}
