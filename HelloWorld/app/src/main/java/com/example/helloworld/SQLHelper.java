package com.example.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String dbName = "";
    private static final int dbversion = 1;
    private static final String idcolumn = "id";
    private static final String tableName = "loginDetails";
    private static final String username = "username";
    private static final String password = "password";

    public SQLHelper(Context context) {
        super(context, dbName, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + dbName + "(" +
                idcolumn + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                username + " TEXT"+
                password+ "TEXT" + ")";
        db.execSQL(query);
    }

    public void addNewUser(String user, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(username, user);
        values.put(password, pass);
        db.insert(tableName, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + tableName);
        onCreate(db);
    }
}
