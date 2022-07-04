package com.mjh.rxexam.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.mjh.rxexam.R
import com.mjh.rxexam.databinding.ActivityLiveListBinding

class LiveListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLiveListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var listItems = ArrayList<String>()
        listItems.add("test1")
        listItems.add("test2")
        listItems.add("test3")

        var cnt = 0;
        binding.lv01.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listItems)


        binding.btn001.setOnClickListener {
            listItems.add("${cnt++}")
            Log.d("ListSize","${listItems.size}")
        }

        binding.btn002.setOnClickListener {
            listItems.removeAll(listItems.toSet())
            Log.d("ListSize","${listItems.size}")
        }








    }
}