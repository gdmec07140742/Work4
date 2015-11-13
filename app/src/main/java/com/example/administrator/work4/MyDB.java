package com.example.administrator.work4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/11/8.
 */
public class MyDB extends SQLiteOpenHelper {
    private static String DB_NAME="My_DB.db";
    private static int DB_VERSION=2;
    private SQLiteDatabase db;
    //构造方法
    public MyDB(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        db=getWritableDatabase();
    }
    //连接数据库
    public SQLiteDatabase openConnection(){
        if(!db.isOpen()) {
            db = getWritableDatabase();
        }
        return db;
    }
    //关闭数据库连接
    public void closeConnection(){
        try {
            if(db!=null&&db.isOpen())
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    //创建数据表
    public boolean createTable(String createTableSql) {
        try {
            openConnection();
            db.execSQL(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
    //保存数据
    public boolean save(String tableName,ContentValues values){
        try {
            openConnection();
            db.insert(tableName, null, values);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
    //更新数据
    public boolean update(String table,ContentValues values,String whereClause,String whereArgs[]){
        try {
            openConnection();
            db.update(table, values, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
    //删除数据
    public boolean delete(String table,String deleteSql,String obj[]){
        try {
            openConnection();
            db.delete(table, deleteSql, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
        return true;
    }
    //查找数据
    public Cursor find(String findSql,String obj[]){
        try {
            openConnection();
            Cursor cursor = db.rawQuery(findSql,obj);
            return cursor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //检查数据表是否存在
    public boolean isTableExits(String tablename){
        try {
            openConnection();
            String str = "select count(*)xcount from "+tablename;
            db.rawQuery(str,null).close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
    }
}
