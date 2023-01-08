package com.example.laborator4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView studentList;
    private Button addButton, deleteButton;
    private ArrayList<String> dynamicList;
    private ArrayAdapter<String> listAdapter;
    private EditText editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = findViewById(R.id.listView);
        dynamicList = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dynamicList);
        studentList.setAdapter(listAdapter);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        editTextName = findViewById(R.id.textEditName);

    }

    public void onClickAdd(View view) {
        String name = editTextName.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Add the students name first", Toast.LENGTH_LONG).show();
        } else {
            listAdapter.add(name);
            listAdapter.notifyDataSetChanged();
        }

    }

    public void onClickDel(View view) {
        if (dynamicList.size() > 0) {
            dynamicList.remove(dynamicList.size() - 1);
            Toast.makeText(MainActivity.this, "Student deleted", Toast.LENGTH_LONG).show();
            listAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(MainActivity.this, "Nothing to delete", Toast.LENGTH_LONG).show();
        }
    }
}