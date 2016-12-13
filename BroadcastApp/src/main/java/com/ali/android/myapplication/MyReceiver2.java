package com.ali.android.myapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {
    public MyReceiver2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("MyReceiver2当前线程：",Thread.currentThread().getName());
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Toast.makeText(context,bundle.getString("msg")+"in MyReceiver2", Toast.LENGTH_SHORT ).show();
        }else{
            Toast.makeText(context,"Nothing in MyReceiver2", Toast.LENGTH_SHORT ).show();
        }

        bundle = getResultExtras(true);
            Toast.makeText(context, bundle.getString("msg")+"------", Toast.LENGTH_SHORT).show();


    }
}
