package com.ali.android.contentproviderapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class TeacherContentProvider extends ContentProvider {
    private DBOpenHelper dbOpenHelper;


    public TeacherContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        System.out.println("*************ContentProvider delete");
        // Implement this to handle requests to delete one or more rows.
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int count = 0;
        switch (ContentData.UserTableData.uriMatcher.match(uri)) {
            case ContentData.UserTableData.TEACHERS:
                System.out.println("*************ContentProvider delete**"+ selection +"---"+selectionArgs);
                count = db.delete(ContentData.UserTableData.TABLE_NAME, selection, selectionArgs);
                break;
            case ContentData.UserTableData.TEACHER:
                // 下面的方法用于从URI中解析出id，对这样的路径content://hb.android.teacherProvider/teacher/10
                // 进行解析，返回值为10
                long personid = ContentUris.parseId(uri);
                String where = "_ID=" + personid;
                System.out.println("*************ContentProvider delete**"+ uri);
                where += TextUtils.isEmpty(selection) ? "" : "and (" + selection + ")";

                count = db.delete(ContentData.UserTableData.TABLE_NAME, where, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown Uri" + uri);

        }
        db.close();
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        System.out.println("*************ContentProvider getType");
        switch (ContentData.UserTableData.uriMatcher.match(uri)){
            case ContentData.UserTableData.TEACHERS:
                return ContentData.UserTableData.CONTENT_TYPE;
            case ContentData.UserTableData.TEACHER:
                return ContentData.UserTableData.CONTENT_TYPE_ITME;
            default: throw new IllegalArgumentException("Unknown uri" + uri);
        }

    }

    /**
     * 当执行这个方法的时候，如果没有数据库，他会创建，同时也会创建表，但是如果没有表，下面在执行insert的时候就会出错
     * 这里的插入数据也完全可以用sql语句书写，然后调用 db.execSQL(sql)执行。
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        System.out.println("*************ContentProvider insert");
        SQLiteDatabase sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        long id;
        switch (ContentData.UserTableData.uriMatcher.match(uri)) {
            case ContentData.UserTableData.TEACHERS:
                id = sqLiteDatabase.insert(ContentData.UserTableData.TABLE_NAME, null, values);
                return ContentUris.withAppendedId(uri, id);
            case ContentData.UserTableData.TEACHER:
                id = sqLiteDatabase.insert(ContentData.UserTableData.TABLE_NAME, null, values);
                String path = uri.toString();
                return Uri.parse(path.substring(0, path.lastIndexOf("/")) + id);
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }


    /**
     * 是一个回调函数，在ContentProvider创建的时候，就会运行,第二个参数为指定数据库名称，如果不指定，就会找不到数据库；
     * 如果数据库存在的情况下是不会再创建一个数据库的。（当然首次调用 在这里也不会生成数据库必须调用SQLiteDatabase的 getWritableDatabase,getReadableDatabase两个方法中的一个才会创建数据库）
     */
    @Override
    public boolean onCreate() {
        System.out.println("*************ContentProvider onCreate");
        // TODO: Implement this to initialize your content provider on startup.
        dbOpenHelper = new DBOpenHelper(this.getContext(), ContentData.DATABASE_NAME, null, ContentData.DATABASE_VERSION);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        System.out.println("*************ContentProvider query");
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        switch (ContentData.UserTableData.uriMatcher.match(uri)){
            case ContentData.UserTableData.TEACHERS:
                return db.query(ContentData.UserTableData.TABLE_NAME, projection,selection,selectionArgs, null,null,sortOrder);
            case ContentData.UserTableData.TEACHER:
                long id = ContentUris.parseId(uri);
                String where = "_ID =" + id;
                where += !TextUtils.isEmpty(selection) ? "and (" + selection + ")" : "";
                return db.query(ContentData.UserTableData.TABLE_NAME, projection,where,selectionArgs,null,null,sortOrder);
            default:throw new IllegalArgumentException("Unknown uri"+uri);
        }

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        System.out.println("*************ContentProvider update");
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int count = 0;
        switch (ContentData.UserTableData.uriMatcher.match(uri)) {
            case ContentData.UserTableData.TEACHERS:
                count = db.update(ContentData.UserTableData.TABLE_NAME, values, selection, selectionArgs);
                break;
            case ContentData.UserTableData.TEACHER:
                long id = ContentUris.parseId(uri);
                String where = "_ID =" + id;
                where += !TextUtils.isEmpty(selection) ? "and (" + selection + ")" : "";
                count = db.update(ContentData.UserTableData.TABLE_NAME, values, where, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown Uri" + uri);
        }
        db.close();
        return count;
    }
}
