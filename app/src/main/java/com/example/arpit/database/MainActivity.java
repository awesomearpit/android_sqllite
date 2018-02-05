package com.example.arpit.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile,et_email,et_technology;
    Button btn_save,btn_fetch;
    String sname,smobile,semail,stechnology;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_email=findViewById(R.id.et_email);
        et_mobile=findViewById(R.id.et_mobile);
        et_technology=findViewById(R.id.et_technology);
        et_name=findViewById(R.id.et_name);
        btn_fetch=findViewById(R.id.Btn_fetch);
        btn_save=findViewById(R.id.Btn_save);

        //to create or open database

        CreateDatabase();

        //to create table in a database

        createtable();
// click on btn save to insert the data

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // insert the data into table
                insertintotable();
            }
        });

        // to fetch the data click on buttonfetch

        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fetch data from database
                fetchdata();
            }
        });
    }

    private void fetchdata()
    {
        Cursor cursor= sqLiteDatabase .rawQuery("select * from students", null);
        cursor.moveToLast();
        Toast.makeText(getApplicationContext(),cursor.getString(0).toString()+cursor.getString(1).toString()+cursor.getString(2).toString()+cursor.getString(3).toString() , Toast.LENGTH_SHORT).show();
    }

    private void insertintotable()
    {

        //convert java objectinto string object

        sname= et_name.getText().toString();
        smobile= et_mobile.getText().toString();
        semail= et_email.getText().toString();
        stechnology= et_technology.getText().toString();


        sqLiteDatabase .execSQL("insert into students values ('"+sname+"','"+smobile+"','"+semail+"','"+stechnology+"')");

    }


    private void createtable()
    {
        sqLiteDatabase.execSQL("create table if not exists students (name varchar(150),mobile integer(150),email varchar(150),technology varchar(250))");

    }

    private void CreateDatabase()
    {
        //to create new database
        sqLiteDatabase=openOrCreateDatabase("Mitrc", Context.MODE_PRIVATE,null);


    }
}
