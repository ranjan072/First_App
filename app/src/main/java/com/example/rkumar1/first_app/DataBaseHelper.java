package com.example.rkumar1.first_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {


    public DataBaseHelper( Context context) {
        //super(context, name, factory, version);
        super(context,"login db",  null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(email text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }

    //inserting the database
    public boolean insert(String email, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long l =db.insert( "user", null,contentValues );
        if(l==-1)
            return false;
        else{
            return true;
        }


    }

    // check email exists
    public boolean checkEmail(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else{
            return true;
        }

    }
    //check the email and password
    public boolean emailPass(String email,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else{
            return false;
        }

    }
}
