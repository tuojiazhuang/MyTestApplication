package com.ali.android.progressbardownloadmanagerapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ali.android.progressbardownloadmanagerapp.R;

public class MainActivity extends AppCompatActivity {
    Intent intent = null;

    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControl();

        initButton();

    }

    private void initControl() {
        b1 = (Button) findViewById(R.id.button1);
    }

    private void initButton() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,
                        DownloadManagerDemo.class);
                startActivity(intent);
            }
        });
    }
}
