package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView add=findViewById(R.id.add);
        add.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(),AddRecord.class);
            startActivity(in);
        });
        TextView update=findViewById(R.id.update);
        update.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(),UpdateRecord.class);
            startActivity(in);
        });
        TextView display=findViewById(R.id.display);
        display.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(),DisplayRecords.class);
            startActivity(in);
        });
        TextView search=findViewById(R.id.search);
        search.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(),SearchRecord.class);
            startActivity(in);
        });
        TextView delete=findViewById(R.id.delete);
        delete.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(),DeleteRecord.class);
            startActivity(in);
        });

    }
}