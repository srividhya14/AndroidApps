package com.example.db_models2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABSE_NAME="stud.db";
    public static final String TABLE_NAME="stud_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="MOB";
    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOB TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
          db.execSQL("drop table if exists "+TABLE_NAME);
          onCreate(db);
    }

    public boolean insert_data(String name,String mob)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,mob);
        long res=db.insert(TABLE_NAME,null,contentValues);
        if(res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor view()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select* from "+TABLE_NAME,null);
        return res;
    }

    public int update(String id,String name,String mob)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,mob);
        int res=db.update(TABLE_NAME,contentValues,"ID=?",new String[]{id});
        return res;

    }

    public int delete(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int res=db.delete(TABLE_NAME,"ID=?",new String[]{id});
        return res;
    }
}
