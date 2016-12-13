package com.ali.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonNormal = (Button)findViewById(R.id.btn_normal);
        buttonNormal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendNormalBroadcast();
            }
        });

        Button button2 = (Button)findViewById(R.id.btn_order);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendOneOrderedBroadcast();
            }
        });

        Button button = (Button)findViewById(R.id.btn_order_withpermission);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendOrderBroadcastWithPermission();
            }
        });
    }


    public  void sendNormalBroadcast(){
        Intent intent = new Intent("MyReceiver.showAMessage");
        Bundle bundle = new Bundle();
        bundle.putString("msg", "This normal broadcast is from main activity");
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }

    public  void sendOneOrderedBroadcast(){
        Intent intent = new Intent("MyReceiver.showAMessage");
        Bundle bundle = new Bundle();
        bundle.putString("msg", "This order broadcast is from main activity");
        intent.putExtras(bundle);
        sendOrderedBroadcast(intent,null);
    }
    public void sendOrderBroadcastWithPermission(){
        Intent intent = new Intent("MyReceiver.showAMessage");
        intent.putExtra("msg", "This order broadcast with permission is from main activity");
        sendOrderedBroadcast(intent, "broadcast.permission");
    }
}
