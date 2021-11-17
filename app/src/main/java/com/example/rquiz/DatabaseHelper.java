package com.example.rquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Database name
    public static final String DB_NAME = "login.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //Create table with headings
        MyDB.execSQL("create Table users(username TEXT primary key , name TEXT, phone TEXT, password TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        //Drop table if it exists
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String username , String name, String phone, String password)
    {
        //Add data into database table
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" , username);
        contentValues.put("name" , name);
        contentValues.put("phone" , phone);
        contentValues.put("password" , password);
        long result = MyDB.insert("users" , null , contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean checkPhone(String phone)
    {
        //Check if phone exists in database
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where phone = ?", new String[] {phone});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkUsername(String username)
    {
        //Check if user exists in database
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean updatePassword(String phone, String password)
    {
        //Update password
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //Replace old password with new password
        contentValues.put("password" , password);
        long result = MyDB.update("users" , contentValues ,"phone = ?" , new String[] {phone});
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean checkLogin(String username , String password)
    {
        //Check if credentials are valid
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username , password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
