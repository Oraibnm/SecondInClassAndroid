package com.example.secondinclassandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText title , author_name , pages ;
    Button add , saveAll ;
    SharedPreferences sharedPreferences ; // for read
    SharedPreferences.Editor editor ; //for write
    boolean save = false;
    List<Books> booksList = new ArrayList<>();
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews ();




    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    private void setupViews (){

        title = findViewById(R.id.editTitle);
        author_name  = findViewById(R.id.authorName);
        pages =findViewById(R.id.pages);
        add = findViewById(R.id.addBtn);
        saveAll = findViewById(R.id.saveBtn);


    }

    public void AddBook(View view) {

//        booksList.add(view);
    }

    public void SaveAll(View view) {
        save= true ;
    }
}