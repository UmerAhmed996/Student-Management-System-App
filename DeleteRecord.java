package com.example.crud;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DeleteRecord extends AppCompatActivity {
    Student student;
    StudentAdapter adapter;
    SQLiteDatabase mDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        mDatabase=openOrCreateDatabase("db_STUDENTS.db", MODE_PRIVATE, null);
        EditText id=findViewById(R.id.studentID);
        Button deleteButton=findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(v -> {
            String sql = "DELETE FROM STUDENTS WHERE id = " + id.toString() ;
            mDatabase.execSQL(sql,new String[]{student.getID()});
            adapter.reloadStudentsFromDatabase();
        });
    }
}
