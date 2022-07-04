package com.example.crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    List<Student> studentList;
    Context context;
    int resource;
    int listLayoutRes;
    SQLiteDatabase mDatabase;

    public StudentAdapter(Context context, int resource, List<Student> studentList) {
        super(context, resource, studentList);
        this.context = context;
        this.resource = resource;
        this.studentList = studentList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);
        TextView id = view.findViewById(R.id.studentID);
        TextView name = view.findViewById(R.id.studentName);
        TextView email = view.findViewById(R.id.studentEmail);
        Student student = studentList.get(position);
        id.setText(student.getID());
        name.setText(student.getName());
        email.setText(student.getEmail());

        return view;
    }

    public void reloadStudentsFromDatabase() {
        Cursor cursorStudents = mDatabase.rawQuery("SELECT * FROM STUDENTS", null);
        if (cursorStudents.moveToFirst()) {
            studentList.clear();
            do {
                studentList.add(new Student(
                        cursorStudents.getString(0),
                        cursorStudents.getString(1),
                        cursorStudents.getString(2)
                ));
            } while (cursorStudents.moveToNext());
        }
        cursorStudents.close();
        notifyDataSetChanged();
    }

}