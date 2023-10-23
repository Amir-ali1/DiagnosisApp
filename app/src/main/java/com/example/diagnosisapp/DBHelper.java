package com.example.diagnosisapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context)
    {
        super(context, "SymptomsDatas.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Db)
    {

        Db.execSQL("create Table UserDetailss(title TEXT primary key, des TEXT, formula TEXT, link TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int i1) {

        Db.execSQL("drop Table if exists UserDetailss");
    }

    public Boolean insertuserdata(String title, String des, String formula, String link)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", String.valueOf(title));
        contentValues.put("des", String.valueOf(des));
        contentValues.put("formula", String.valueOf(formula));
        contentValues.put("link", String.valueOf(link));
        long result=DB.insert("UserDetailss", null, contentValues);
        if(result==-1)
        {
            return false;
        }
        else
            {
                return true;
        }
    }

    public Boolean updateuserdata(String title, String des, String formula,String link) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("des",des);
        contentValues.put("formula",formula);
        contentValues.put("link",link);
        Cursor cursor = DB.rawQuery("Select * from UserDetailss where title = ?", new String[]{title});
        if (cursor.getCount() > 0)
        {
            long result = DB.update("UserDetailss", contentValues, "title=?", new String[]{title});

            if (result == -1)
            {
                return false;
            }
            else
                {
                return true;
            }
        }
        else
            {
            return false;
        }
    }


    public Boolean deletedata (String title)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from UserDetailss where title = ?", new String[]{title});
        if (cursor.getCount() > 0)
        {
            long result = DB.delete("UserDetailss", "title=?", new String[]{title});
            if (result == -1)
            {
                return false;
            }
            else
                {
                return true;
            }
        }
        else
            {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from UserDetailss", null);
        return cursor;
    }

    Cursor readAllData()
    {
        String query ="SELECT  * FROM UserDetailss";
        SQLiteDatabase DB= this.getReadableDatabase();

        Cursor cursor=null;
        if(DB!=null)
        {
            cursor = DB.rawQuery(query,null);

        }
        return cursor;
    }

}
