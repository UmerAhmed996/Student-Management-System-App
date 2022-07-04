package com.example.crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DisplayRecords extends AppCompatActivity {

    List<Student> studentsList;
    SQLiteDatabase mDatabase;
    ListView listViewStudents;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        listViewStudents = (ListView) findViewById(R.id.listView);
        studentsList = new ArrayList<>();
        mDatabase = openOrCreateDatabase("db_STUDENTS.db", MODE_PRIVATE, null);
        showEmployeesFromDatabase();
    }
    private void showEmployeesFromDatabase() {
        Cursor cursorStudents = mDatabase.rawQuery("SELECT * FROM STUDENTS", null);
        if (cursorStudents.moveToFirst()) {
            do {
                studentsList.add(new Student(
                        cursorStudents.getString(0),
                        cursorStudents.getString(1),
                        cursorStudents.getString(2)
                ));
            } while (cursorStudents.moveToNext());
        }
        cursorStudents.close();
        adapter = new StudentAdapter(this, R.layout.custom_layout, studentsList);
        listViewStudents.setAdapter(adapter);
    }
}