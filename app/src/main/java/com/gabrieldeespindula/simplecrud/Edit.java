package com.gabrieldeespindula.simplecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity implements View.OnClickListener {
    EditText bookTitle;
    EditText bookAuthor;
    EditText bookPublishingCompany;
    Button buttonSave;
    Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        bookTitle = findViewById(R.id.editTextBookTitle);
        bookAuthor = findViewById(R.id.editTextBookAuthor);
        bookPublishingCompany = findViewById(R.id.editTextBookPublishingCompany);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDelete = findViewById(R.id.buttonDelete);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.buttonSave){

        }if (v.getId()==R.id.buttonDelete){

        }
    }
}