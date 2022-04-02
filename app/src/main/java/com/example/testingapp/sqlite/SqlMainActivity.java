package com.example.testingapp.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.testingapp.R;

import java.util.ArrayList;

public class SqlMainActivity extends AppCompatActivity {

    SQLitePersonDao dao = null;
    ArrayList<PersonVo> p_list = null;
    RecyclerView rv_list = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_main);

        rv_list = findViewById(R.id.recycler_view);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
       // rv_list.setAdapter(new Recy);



    }
}