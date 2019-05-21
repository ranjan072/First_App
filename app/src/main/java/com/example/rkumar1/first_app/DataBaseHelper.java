package com.example.rkumar1.first_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final String CREATE_TABLE_USER = " create table USERS ( email text PRIMARY KEY , password text );";
    private static final String DB_NAME = "USERS.DB";
    public static final String TABLE_NAME_USER ="USERS";
    private static final String Column_Email = "email";
    private static final String Column_Password = "password";

    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        Log.e("SQLITE", "table reated");
        db.execSQL(CREATE_TABLE_USER);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }



    //inserting the database
   /* public boolean insert(String email, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long l =db.insert( "TABLE_NAME_USER", null,contentValues );
        if(l==-1)
            return false;
        else{
            return true;
        }


    }*/

    public long insert(String email, String password) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("Email", email);
        contentValue.put("Password", password);
        long l=db.insert(TABLE_NAME_USER, null, contentValue);
        /*if(l==-1)
            return false;
        else{
            return true;
        }*/
        return l;


    }

   public Cursor fetch(String email) {
        SQLiteDatabase db=this.getReadableDatabase();
        //Cursor cursor =db.rawQuery(TABLE_NAME_USER, new String[]{(email)});

       Cursor cursor =db.rawQuery("select * from "+TABLE_NAME_USER+" ",new String[]{String.valueOf(email)});
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Users users=new Users();
        users.setEmail(cursor.getString(cursor.getColumnIndex(Column_Email)));
        //users.setPassword(cursor.getString(0));
        return (Cursor) users;
    }


    // check email exists
   public boolean checkEmail(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from TABLE_NAME_USER where email=?",new String[]{email});
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
        Cursor cursor=db.rawQuery("select * from TABLE_NAME_USER where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else{
            return false;
        }

    }
}