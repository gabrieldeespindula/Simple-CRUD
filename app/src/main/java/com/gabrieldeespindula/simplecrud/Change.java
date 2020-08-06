package com.gabrieldeespindula.simplecrud;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Change extends AppCompatActivity {
    EditText book;
    EditText author;
    EditText company;
    Button update;
    Button delete;
    Cursor cursor;
    DBController crud;
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        code = this.getIntent().getStringExtra("code");

        crud = new DBController(getBaseContext());

        book = (EditText)findViewById(R.id.editTextBookTitleChange);
        author = (EditText)findViewById(R.id.editTextBookAuthorChange);
        company = (EditText)findViewById(R.id.editTextBookPublishingCompanyChange);

        update = findViewById(R.id.buttonChange);

        cursor = crud.loadingDBById(Integer.parseInt(code));
        book.setText(cursor.getString(cursor.getColumnIndexOrThrow(CreateDB.TITLE)));
        author.setText(cursor.getString(cursor.getColumnIndexOrThrow(CreateDB.AUTHOR)));
        company.setText(cursor.getString(cursor.getColumnIndexOrThrow(CreateDB.COMPANY)));
    }
}