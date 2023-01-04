package com.example.secondinclassandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText title , author_name , pages ;
    Button add , saveAll ;
    private  boolean save = false;
    private SharedPreferences sharedPreferences ; //for write
    private SharedPreferences.Editor editor ; // for write

    public static final String TEST1 = "test1";
    public static final String TEST2 = "test2";
    public static final String TEST3 = "test3";

    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews ();
        checkData ();
        setUpSharedPref ();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!save){
            String str_title = title.getText().toString().trim();
            String str_author = author_name.getText().toString();
            String str_pages = pages.getText().toString();

            editor.putString(TEST1 , str_title);
            editor.putString(TEST2 , str_author);
            editor.putString(TEST3 , str_pages);

            editor.putBoolean("FLAG" , flag);
            editor.commit();

        }
    }

    public void setupViews (){

        title = findViewById(R.id.editTitle);
        author_name  = findViewById(R.id.authorName);
        pages =findViewById(R.id.pages);
        add = findViewById(R.id.addBtn);
        saveAll = findViewById(R.id.saveBtn);


        saveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save = true;
            }
        });
    }

    public void AddBook(View view) {
        List<Books> list = new ArrayList<>();

        title.getText().toString();
        author_name.getText().toString();
        pages.getText().toString();
       // list.add(title, author_name, pages);

    }
    private  void setUpSharedPref () {
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    public void SaveAll(View view) {
        Books [] books = new Books[3];
        books[0] = new Books ("oraib" , "test1" , "12");
        books[1] = new Books ("test" , "test1" , "120");
        books[2] = new Books ("tes" , "test1" , "122");
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String usersString = gson.toJson(books);
        editor.putString("FLAG", usersString);
        editor.commit();

        Toast.makeText(this, " Saved All Books :\n" + usersString,
                Toast.LENGTH_SHORT).show();

    }

    private void checkData (){
        boolean f = sharedPreferences.getBoolean("FLAG", false);
        if (f){
            String t1 = sharedPreferences.getString(TEST1, "");
            String t2 = sharedPreferences.getString(TEST2, "");
            String t3 = sharedPreferences.getString(TEST3, "");

            title.setText(t1);
            author_name.setText(t2);
            pages.setText(t3);
        }
    }
}