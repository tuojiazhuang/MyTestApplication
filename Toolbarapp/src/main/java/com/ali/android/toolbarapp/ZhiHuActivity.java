package com.ali.android.toolbarapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ZhiHuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_zhihu);
        setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.zhihu_toolbar_menu);

        toolbar.setNavigationIcon(R.drawable.refresh);

        toolbar.setTitle(R.string.zhihu);
        //toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        Button button = (Button)findViewById(R.id.changebtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println("++++++++++++zhihuactivity++++");
                Intent intent = new Intent("com.ali.android.toolbarapp.curtoobaractivity");
                startActivity(intent);

            }
        });



    }
}
