package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            SQLiteDatabase sqLiteDatabase= this.openOrCreateDatabase("Contacts", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");

            sqLiteDatabase.execSQL("CREATE TABLE contacts (name VARCHAR, number INT(2))");
            sqLiteDatabase.execSQL("INSERT INTO contacts (name,number) VALUES('Sercan', 5439292076)");

            Cursor cursor= sqLiteDatabase.rawQuery("Select * From contacts", null);

            int name= cursor.getColumnIndex("name");
            int number= cursor.getColumnIndex("number");

            while (cursor.moveToNext())
            {
                System.out.println("Name " + cursor.getString(name));
                System.out.println("Number " + cursor.getString(number));
            }
            cursor.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
