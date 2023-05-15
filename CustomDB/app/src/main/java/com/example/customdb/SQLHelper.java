package com.example.customdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String dbname = "newdb";
    private static final int dbversion = 1;
    private static final String table = "courses";
    private static final String nameCol = "name";
    private static final String emailCol = "email";
    public SQLHelper(Context context){
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table + " (" + nameCol +" TEXT " + "," + emailCol + " TEXT "+ ")");
    }

    public void addNewUser(String username, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nameCol, username);
        values.put(emailCol, email);
        db.insert(table, null, values);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + table);
        onCreate(db);

    }
}
