package com.gabrieldeespindula.simplecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBController {
    private SQLiteDatabase db;
    private CreateDB dbHelper;

    public DBController(Context context){
        dbHelper = new CreateDB(context);
    }

    public String insertDB(String title, String author, String company){
        ContentValues values;
        long result;

        db = dbHelper.getWritableDatabase();
        values = new ContentValues();
        values.put(CreateDB.TITLE, title);
        values.put(CreateDB.AUTHOR, author);
        values.put(CreateDB.COMPANY, company);

        result = db.insert(CreateDB.TABLE_NAME, null, values);
        db.close();

        if (result ==-1) {
            return "Error inserting data.";
        }else {
            return "Data inserted successfully.";
        }
    }
}
