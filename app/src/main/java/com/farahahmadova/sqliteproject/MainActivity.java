package com.farahahmadova.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            SQLiteDatabase database=this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians( id INTEGER PRIMARY KEY,name VARCHAR,age INT)");

            //database.execSQL("INSERT INTO musicians(name,age)Values('Farah',24)");
           // database.execSQL("INSERT INTO musicians(name,age)Values('Omar',22)");
            database.execSQL("INSERT INTO musicians(name,age)Values('Farah',24)");
            database.execSQL("INSERT INTO musicians(name,age)Values('Omar',22)");
            database.execSQL("INSERT INTO musicians(name,age)Values('Lina',26)");

            //Update
           // database.execSQL("UPDATE musicians SET age=34 WHERE name='Omar'");

            //Delete
          //  database.execSQL("DELETE musicians  WHERE id=2");


            Cursor cursor=database.rawQuery("SELECT *FROM musicians",null);
            int nameIx=cursor.getColumnIndex("name");
            int ageIx=cursor.getColumnIndex("age");
            int idIx=cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name:"+cursor.getString(nameIx));
                System.out.println("Age:"+cursor.getString(ageIx));
                System.out.println("Id:"+cursor.getString(idIx));
            }
            cursor.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
