package com.example.testingapp.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.testingapp.R;

import java.util.ArrayList;

public class SqlMainActivity extends AppCompatActivity {

    SQLitePersonDao dao = null;
    ArrayList<PersonVo> p_list = null;
    //RecyclerView rv_list = null;
    ListView lv_list = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_main);

        Button button = findViewById(R.id.button2);
        lv_list = findViewById(R.id.lv_list);
        dao = new SQLitePersonDao(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //리스트 데이터 불러오기
        display_person_list();

        // rv_list = findViewById(R.id.recycler_view);
        // rv_list.setLayoutManager(new LinearLayoutManager(this));
        // rv_list.setAdapter(new Recy);

    }

    /**
     * 리스트 데이터 바인드 메서드
     */
    public void display_person_list(){
        p_list = dao.selectList();
        lv_list.setAdapter(new PersonAdapter());
    }
}