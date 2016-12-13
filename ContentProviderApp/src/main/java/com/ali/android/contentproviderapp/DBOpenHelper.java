package com.ali.android.contentproviderapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/11/9.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    // 在SQLiteOepnHelper的子类当中，必须有该构造函数，用来创建一个数据库；
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // 必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
    /**
     * 只有当数据库执行创建 的时候，才会执行这个方法。如果更改表名，也不会创建，只有当创建数据库的时候，才会创建改表名之后 的数据表
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("-----DBOpenHelper----onCreate-----");
        sqLiteDatabase.execSQL("create table " + ContentData.UserTableData.TABLE_NAME
                + "(" + ContentData.UserTableData._ID
                + " INTEGER PRIMARY KEY autoincrement,"
                + ContentData.UserTableData.NAME + " varchar(20),"
                + ContentData.UserTableData.TITLE + " varchar(20),"
                + ContentData.UserTableData.DATE_ADDED + " long,"
                + ContentData.UserTableData.SEX + " boolean)" + ";");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("-----DBOpenHelper----onUpgrade-----");
        sqLiteDatabase.execSQL("");

    }
}
