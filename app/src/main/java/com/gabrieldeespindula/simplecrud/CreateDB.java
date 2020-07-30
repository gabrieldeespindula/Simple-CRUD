package com.gabrieldeespindula.simplecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDB extends SQLiteOpenHelper {
    private static final String NAME_DATABASE = "DataBase.db";
    private static final String TABLE_NAME = "Books";
    private static final String ID = "_id";
    private static final String TITLE = "Title";
    private static final String AUTHOR = "Author";
    private static final String COMPANY = "Company";
    private static final int VERSION = 1;

    public CreateDB(Context context) {
        super(context, NAME_DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_NAME+" ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TITLE + " text,"
                + AUTHOR + " text,"
                + COMPANY + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
