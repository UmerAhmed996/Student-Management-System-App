package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    Context view;
    public DBHandler(Context context) {
        super(context, "db_STUDENTS.db", null, 1);
        view=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table STUDENTS(id varchar(30) PRIMARY KEY NOT NULL, name varchar(30), email varchar(100));";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String q = "drop table STUDENTS";
        sqLiteDatabase.execSQL(q);
        onCreate(sqLiteDatabase);
    }

    public void addNewStudent(String studentID, String studentName, String studentEmail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", studentID);
        values.put("name", studentName);
        values.put("email", studentEmail);
        db.insert("STUDENTS", null, values);

        db.close();
    }


}
