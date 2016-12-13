package com.ali.android.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("--33--");
        initById();

    }
    public  void initById(){
        System.out.println("----");
        findViewById(R.id.notification).setOnClickListener(this);
        findViewById(R.id.select).setOnClickListener(this);
        findViewById(R.id.single).setOnClickListener(this);
        findViewById(R.id.multiple).setOnClickListener(this);
        findViewById(R.id.list).setOnClickListener(this);
        findViewById(R.id.custom).setOnClickListener(this);
       findViewById(R.id.progress).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("----" +view.getId()+"-----" + R.id.notification);
        switch (view.getId()){
            case R.id.notification:
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Notificatioin");
                builder.setIcon(R.drawable.actionabout);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Click sure", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
                break;

            }
            case R.id.select:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Select");
                builder.setIcon(R.drawable.sortbysize);
                builder.setPositiveButton("喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "喜欢", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }

                });
                builder.setNegativeButton("不喜欢",null);
                builder.setNeutralButton("一点点", null);
                builder.create().show();
                break;
            }
            case R.id.single:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Choose one language");
                builder.setIcon(R.drawable.viewasgrid);
                builder.setSingleChoiceItems(R.array.languageArray,1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,i,Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                break;
            }
            case R.id.multiple:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Choose one or more language");
                builder.setMultiChoiceItems(R.array.languageArray, new boolean[]{true, false, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                break;
            }
            case R.id.list: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("A List");
                builder.setItems(R.array.languageArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                break;
            }
            case R.id.custom:{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Custom dialog");
                builder.setView(getLayoutInflater().inflate(R.layout.custom_dialogview, null));
                builder.create().show();
                break;
            }
            case R.id.progress:{
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Progress");
                progressDialog.setMessage("正在加载中");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();


            }
        }
    }
}
