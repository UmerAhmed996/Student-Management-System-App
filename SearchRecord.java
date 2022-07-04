package com.example.crud;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class SearchRecord extends AppCompatActivity {
    List<Student> studentsList;
    SQLiteDatabase mDatabase;
    Student student;
    ListView listViewStudents;
    StudentAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText id=findViewById(R.id.search);
        Button buttonSearch = findViewById(R.id.searchButton);
        mDatabase=openOrCreateDatabase("db_STUDENTS.db", MODE_PRIVATE, null);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sql = "SELECT * FROM STUDENTS WHERE id =" + id.toString();
                Cursor cursorStudents = mDatabase.rawQuery(sql, null);
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
                            }
        });
    }
}