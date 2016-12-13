package com.ali.android.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class ShowHelloWorldActivity extends AppCompatActivity {

    String TAG="Activity 1.2 of App1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hello_world);
        Intent preIntent = getIntent();
         String message = preIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        System.out.println("-----" +TAG +"----onCreate-----!!taskid:"+ getTaskId()+ "------");

        EditText editText = (EditText)findViewById(R.id.activity_show_hello1) ;
        editText.setText(message);

        Button btn = (Button) findViewById(R.id.next_button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ShowHelloWorldActivity.this, DisplayMessageActivity.class);
                intent.putExtra(MainActivity.EXTRA_MESSAGE, "Hello World");
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
