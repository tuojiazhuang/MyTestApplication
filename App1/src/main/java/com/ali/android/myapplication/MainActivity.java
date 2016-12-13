package com.ali.android.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.ali.android.myapplication.MESSAGE";
public String TAG= "Activity 1.1 of App1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Uri website = Uri.parse("http://www.baidu.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, website);

        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe )
            startActivity(webIntent);
            */

        System.out.println("-------"+ TAG + "-----onCreate--------taskid:"+ getTaskId()+"------");
       // ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE);
        //ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS);
    }

        /** Called when the user clicks the Send button */
        public void sendMessage(View view) {
            Log.i("Test-------", "running");

            Intent intent = new Intent(this, ShowHelloWorldActivity.class);
            EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
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
