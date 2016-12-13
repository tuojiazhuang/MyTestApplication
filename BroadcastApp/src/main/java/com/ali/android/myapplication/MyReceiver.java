package com.ali.android.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("MyReceiver当前线程：",Thread.currentThread().getName());

        String string = intent.getStringExtra("msg");
        if(string != null){
            Toast.makeText(context,string + " in MyReceiver", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Nothing in MyReceiver", Toast.LENGTH_SHORT).show();
        }

        Bundle bundle = new Bundle();
        bundle.putString("msg", "From MyReceiver");
        setResultExtras(bundle);
    }
}
