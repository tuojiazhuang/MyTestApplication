package com.ali.android.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {

    String TAG = "Activity 1.4 of App1:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        System.out.println("-----" +TAG +"----onCreate-----!!taskid:"+ getTaskId()+ "------");

        Button button =(Button)findViewById(R.id.brought_to_front) ;
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.showhello");
                intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                startActivity(intent);
            }

        });
        Button button2 =(Button)findViewById(R.id.cleartopbtn) ;
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.showhello");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Button button3 =(Button)findViewById(R.id.newtask) ;
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.showhello");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
