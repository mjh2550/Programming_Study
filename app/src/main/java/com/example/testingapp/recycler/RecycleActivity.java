package com.example.testingapp.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testingapp.R;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        // 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<500; i++) {
            list.add(String.format("TEXT %d", i)) ;
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view01);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerManager recyclerManager = new RecyclerManager(list);
        recyclerView.setAdapter(recyclerManager);

    }
}