package com.example.rquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

public class ScoreDatabase extends SQLiteOpenHelper {
        //Database name
        public static final String DB_NAME = "score.db";

        public ScoreDatabase (Context context) {
            super(context, DB_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase MyDB) {
            //Create table with headings
            String createTable = "create Table score_history(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, subject TEXT, score TEXT)";
            MyDB.execSQL(createTable);
        }


        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
            //Drop table if exists
            MyDB.execSQL("drop Table if exists score_history");
            onCreate(MyDB);
        }

        public boolean insertData(String username, String subject, String score)
        {
            //Add data into database table
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username", username);
            contentValues.put("subject", subject);
            contentValues.put("score" , score);
            long result = MyDB.insert("score_history" , null , contentValues);
            if(result==-1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        //Get content list based on username
        public Cursor getListContents(String username) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("Select * from score_history where username = ? order by ID desc", new String[] {username});
            return data;
        }
}


