package com.ali.android.secondapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayActivity extends AppCompatActivity {
String TAG="Activity 2.2 of App2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        System.out.println("-----" +TAG +"----onCreate-----!!taskid:"+ getTaskId()+ "------");
        Button btn = (Button) findViewById(R.id.newTask);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("android.intent.action.showhello");

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        Button btn2 = (Button) findViewById(R.id.button_to_front);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("android.intent.action.showhello");
                intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent);
            }
        });
        Button btn3 = (Button) findViewById(R.id.normalButton);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("android.intent.action.showhello");
                startActivity(intent);
            }
        });
        Button btn4 = (Button) findViewById(R.id.cleartopbtn);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("android.intent.action.showhello");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("-------"+ TAG + "-----onStart--------taskid:"+ getTaskId()+"------");
    }

    @Override
    protected void onResume(){
        super.onResume();
        System.out.println("-------"+ TAG + "-----onResume--------taskid:"+ getTaskId()+"------");
    }

    @Override
    protected  void onPause() {
        super.onPause();
        System.out.println("-------" + TAG + "-----onPause--------taskid:" + getTaskId() + "------");
    }
    @Override
    protected  void onStop(){

        super.onStop();

        System.out.println("-------"+ TAG + "-----onStop--------taskid:"+ getTaskId()+"------");

    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        System.out.println("-------"+ TAG + "-----onDestroy--------taskid:"+ getTaskId()+"------");
    }

    @Override
    public   void onConfigurationChanged(Configuration conf){
        super.onConfigurationChanged(conf);
        System.out.println("-------"+ TAG + "&&&&&&onConfigurationChanged&&&&");


    }

    @Override
    public void onRestart(){
        super.onRestart();
        System.out.println("******onRestart---" + TAG +"------");
    }
}
