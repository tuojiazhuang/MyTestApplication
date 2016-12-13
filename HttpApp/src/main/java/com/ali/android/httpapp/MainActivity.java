package com.ali.android.httpapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button getBtn;
    Button postBtn;
    Button next;
    TextView result_text;
    String URL = "https://www.baidu.com";
    String result="";
    HttpURLConnectionUtils connectionUtils;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1 || msg.what == 2) {
                Toast.makeText(MainActivity.this, (String) msg.obj, Toast.LENGTH_SHORT).show();
                result_text.setText((String) msg.obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        connectionUtils = HttpURLConnectionUtils.getInstance(URL);
        if(connectionUtils == null){
            System.out.println("~~~~~~~~~~~quit~~~~~~~~");

        }
        //检查网络是否连接
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo nwi = cm.getActiveNetworkInfo();
//        System.out.println("~~~~~~~~~~NetworkInfo~~~~~~~~~"+ nwi);
//
//        if(nwi != null && nwi.isConnected()){
//            System.out.println("~~~~~~~~~~NetworkInfo if~~~~~~~~~");
//
//
//        }else{
//            getBtn.setOnClickListener(null);
//            postBtn.setOnClickListener(null);
//        }

    }
    private void setListener() {
        getBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        connectionUtils.huc_initGet();
                        result = connectionUtils.doHttpURL();
                        Message.obtain(handler,1,result).sendToTarget();
                    }
                }).start();

            }
        });
        postBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        connectionUtils.huc_initPost();
                        result = connectionUtils.doHttpURL();
                        Message.obtain(handler,2,result).sendToTarget();
                    }
                }).start();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("SHOW_CONTENT_ACTIVITY");
                startActivity(intent);
            }
        });
    }

    private void initView() {
        getBtn = (Button) findViewById(R.id.getbtn);
        postBtn = (Button) findViewById(R.id.postbtn);
        next = (Button) findViewById(R.id.next);
        result_text = (TextView) findViewById(R.id.result);
    }





}
