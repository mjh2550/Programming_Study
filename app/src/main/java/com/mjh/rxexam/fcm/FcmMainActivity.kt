package com.mjh.rxexam.fcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mjh.rxexam.R

class FcmMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcm_main)

        val tv_01 = findViewById<TextView>(R.id.tv_01)
        val btn_01 = findViewById<Button>(R.id.btn_01)
        btn_01.setOnClickListener{
            //TODO FCM 푸시보내기
        }



    }
}