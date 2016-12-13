package com.ali.android.simplefragment;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        if(display.getWidth()>display.getHeight()){
            Fragment fragment3 = new Fragment3();
            getFragmentManager().beginTransaction().replace(R.id.main, fragment3).commit();
        }
    }
}
