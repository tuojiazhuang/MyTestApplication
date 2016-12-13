package com.ali.android.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class DisplayMessageActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

public String TAG = "Activity 1.3 of App1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_display_message1);
        layout.addView(textView);

        EditText editText = (EditText) findViewById(R.id.edit_message1);
        editText.setText("333");

        Button button = (Button)findViewById(R.id.last_button1);
        button.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DisplayMessageActivity.this, FourthActivity.class);
                startActivity(intent1);

            }
        });

        System.out.println("-----" +TAG +"----onCreate-----!!taskid:"+ getTaskId()+ "------");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
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
