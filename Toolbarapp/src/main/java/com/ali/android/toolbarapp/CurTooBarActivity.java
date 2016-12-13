package com.ali.android.toolbarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class CurTooBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.print("-----------------11111 join into CurTooBarActivity----");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cur_too_bar);
        System.out.print("-----------------22222join into CurTooBarActivity----");
        Toolbar toolbar = (Toolbar) findViewById(R.id.curtoolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.leftarrow);
        toolbar.findViewById(R.id.toolbar_imgbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CurTooBarActivity.this, "CurToolBar ImageButton", Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.findViewById(R.id.toolbar_search_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Toolbar Search Edittext", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CurTooBarActivity.this, MainActivity.class));
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CurTooBarActivity.this, "onNavigationOnClick", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
