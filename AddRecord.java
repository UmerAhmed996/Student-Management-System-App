package com.example.crud;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecord extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabaseObj;
    EditText studentID,studentName, studentEmail;
    String id, name,email;
    Button addStudentData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        addStudentData = (Button) findViewById(R.id.addStudent);
        studentID = (EditText) findViewById(R.id.studentID);
        studentName = (EditText) findViewById(R.id.studentName);
        studentEmail = (EditText) findViewById(R.id.studentEmail);

        addStudentData.setOnClickListener(view -> {
            DBHandler db = new DBHandler(getBaseContext());
            String id = studentID.getText().toString();
            String name = studentName.getText().toString();
            String email = studentEmail.getText().toString();
            db.addNewStudent(id,name,email);
            EmptyEditTextAfterDataInsert();
        });
    }

    public void EmptyEditTextAfterDataInsert(){
        studentID.getText().clear();
        studentName.getText().clear();
        studentEmail.getText().clear();
    }

}
