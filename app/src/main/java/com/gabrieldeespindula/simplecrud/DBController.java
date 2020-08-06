package com.gabrieldeespindula.simplecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public Cursor loadingDB(){
        Cursor cursor;
        String[] spaces =  {dbHelper.ID,dbHelper.TITLE};
        db = dbHelper.getReadableDatabase();
        cursor = db.query(dbHelper.TABLE_NAME, spaces, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public Cursor loadingDBById(int id){
        Cursor cursor;
        String[] campos =  {dbHelper.ID,dbHelper.TITLE,dbHelper.AUTHOR,dbHelper.COMPANY};
        String where = CreateDB.ID + "=" + id;
        db = dbHelper.getReadableDatabase();
        cursor = db.query(CreateDB.TABLE_NAME,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void updateDB(int id, String title, String author, String company){
        ContentValues values;
        String where;

        db = dbHelper.getWritableDatabase();

        where = CreateDB.ID + "=" + id;

        values = new ContentValues();
        values.put(CreateDB.TITLE, title);
        values.put(CreateDB.AUTHOR, author);
        values.put(CreateDB.COMPANY, company);

        db.update(CreateDB.TABLE_NAME,values,where,null);
        db.close();
    }
    public void deleteByID(int id){
        String where = CreateDB.ID + "=" + id;
        db = dbHelper.getReadableDatabase();
        db.delete(CreateDB.TABLE_NAME,where,null);
        db.close();
    }
}
