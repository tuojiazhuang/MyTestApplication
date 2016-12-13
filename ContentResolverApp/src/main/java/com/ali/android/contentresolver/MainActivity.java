package com.ali.android.contentresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button insert;
    Button query;
    Button update;
    Button delete;
    Button querys;
    TextView text;
    Uri uri = Uri.parse("content://com.ali.android.contentproviderapp/teacher");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initByid();


        View.OnClickListener myListener = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                System.out.println("####");
                ContentResolver cr = getContentResolver();
                switch (view.getId()){
                    case R.id.delete:
                        cr.delete(uri,"name=?",new String[]{"jiaoshi"});
                        System.out.println("-------deleted id =2========");
                        text.setText("Delete the content:---" + uri);
                        break;
                    case  R.id.insert:
                        ContentValues cv = new ContentValues();
                        cv.put("title", "jiaoshou");
                        cv.put("name", "jiaoshi");
                        cv.put("SEX", true);
                        Uri uri2 = cr.insert(uri, cv);
                        System.out.println("insert into one record:====="+uri2);
                        text.setText("Insert the content:---" + uri);
                        break;
                    case R.id.query:
                        // 查找id为1的数据
                        Cursor c = cr.query(uri,null,"name=?", new String[]{"jiaoshi"}, null);
                        if(c != null &&c.moveToFirst() == false){
                            // 为空的Cursor
                            return;

                        }
                        int name = c.getColumnIndex("name");
                        System.out.println("----query---name:===="+c.getString(name));
                        c.close();
                        text.setText("Query the content:---" + name);
                        break;
                    case R.id.querys:
                        System.out.println("----querys---count===");
                        Cursor cc = cr.query(uri,null,null,null, null);
                        System.out.println("----querys---count==="+cc.getCount());
                        cc.close();
                        text.setText("Querys the content:---" + uri);
                        break;
                    case R.id.update:
                        ContentValues cv1 = new ContentValues();
                        cv1.put("name", "huangbiao");
                        cv1.put("date_added", (new Date()).toString());
                        int uri3 = cr.update(uri, cv1, "_ID=?", new String[]{"3"});
                        System.out.println("------updated id =3======="+":"+uri3);
                        text.setText("Update the content:---" + uri);
                }
            }
        };
        insert.setOnClickListener(myListener);
        query.setOnClickListener(myListener);
        delete.setOnClickListener(myListener);
        update.setOnClickListener(myListener);
        querys.setOnClickListener(myListener);
    }
    public void initByid(){
        insert = (Button) findViewById(R.id.insert);
        query = (Button) findViewById(R.id.query);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        querys = (Button) findViewById(R.id.querys);
        text = (TextView)findViewById(R.id.showText);
    }
}
