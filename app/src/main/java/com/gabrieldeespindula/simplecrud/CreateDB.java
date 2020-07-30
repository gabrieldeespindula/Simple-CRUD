package com.gabrieldeespindula.simplecrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CreateDB extends SQLiteOpenHelper {
    private static final String NAME_DATABASE = "DataBase.db";
    private static final String TABLE_NAME = "Books";
    private static final String ID = "_id";
    private static final String TITLE = "Title";
    private static final String AUTHOR = "Author";
    private static final String COMPANY = "Company";
    private static final int VERSION = 1;

    public CreateDB(Context context, @Nullable @Nullable String name, @Nullable @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
