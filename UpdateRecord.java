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


public class UpdateRecord extends AppCompatActivity {
    List<Student> studentsList;
    SQLiteDatabase mDatabase;
    Student student;
    ListView listViewStudents;
    StudentAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        EditText id=findViewById(R.id.studentID);
        EditText name=findViewById(R.id.studentName);
        EditText email=findViewById(R.id.studentEmail);

        Button buttonUpdate = findViewById(R.id.updateButton);

        mDatabase=openOrCreateDatabase("db_STUDENTS.db", MODE_PRIVATE, null);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id1 = id.getText().toString();
                String name1 = name.getText().toString();
                String email1 = email.getText().toString();

                String sql = "UPDATE STUDENTS SET name = " + name1 + "," + " email ="  + email1 + "WHERE id =" + id1;


                mDatabase.execSQL(sql,new String[]{student.getID()});

                adapter.reloadStudentsFromDatabase();
            }
        });
    }
}