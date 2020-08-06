package com.gabrieldeespindula.simplecrud;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton newActivity =  findViewById(R.id.floatingActionButton);
        newActivity.setOnClickListener(this);

        DBController crud = new DBController(getBaseContext());
        Cursor cursor = crud.loadingDB();

        String[] nameSpaces = new String[] {CreateDB.ID, CreateDB.TITLE};
        int[] idViews = new int[] {R.id.idBook, R.id.nameBook};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.gridlayout,cursor,nameSpaces,idViews, 0);
        list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, Edit.class));
    }
}