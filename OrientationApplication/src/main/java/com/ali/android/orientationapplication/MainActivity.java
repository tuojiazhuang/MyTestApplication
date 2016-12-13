package com.ali.android.orientationapplication;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Log.i(TAG,"-----------------------onCreate");
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"-----------------------onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"-----------------------onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"-----------------------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"-----------------------onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"-----------------------onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"-----------------------onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"-----------------------onSaveInstanceState");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"-----------------------onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG,"-----------------------onConfigurationChanged");
    }
}
