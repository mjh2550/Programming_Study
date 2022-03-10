package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.testingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Datac datac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        datac= new Datac();
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setActVar(datac);
        activityMainBinding.setLifecycleOwner(this);
      /*  activityMainBinding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       */


    }
}