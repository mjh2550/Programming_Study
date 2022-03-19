package com.example.testingapp.MVC.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.testingapp.MVC.model.DataBase;
import com.example.testingapp.MVC.model.Person;
import com.example.testingapp.MVC.view.MVCMainViewHolder;
import com.example.testingapp.R;

import java.util.Random;

public class MVCMainActivity extends AppCompatActivity implements MVCMainViewHolder.HolderClickListener{


    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MVCMainAdapter adapter;
    DataBase database = DataBase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcmain);
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MVCMainAdapter((MVCMainViewHolder.HolderClickListener) this);
        recyclerView.setAdapter(adapter);
        adapter.setItems(database.getPersonArrayList());
        database.setOnDatabaseListener(new DataBase.DatabaseListener(){

            @Override
            public void onChanged() {
                adapter.setItems(database.getPersonArrayList());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        database.add(new Person(System.currentTimeMillis(),String.format("new Charles %d",new Random().nextInt(1000))));
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDeleteClick(Person person) {
        database.remove(person);
    }
}