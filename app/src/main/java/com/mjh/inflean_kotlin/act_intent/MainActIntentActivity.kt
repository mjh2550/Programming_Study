package com.mjh.inflean_kotlin.act_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mjh.inflean_kotlin.R

class MainActIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_intent)

        /**
         * Intent함수에 세팅하고
         * StartActivity함수로 AOS에 전달시
         * AOS가 Activity찾아서 동작시킴
         *
         * Activity 전환시 실행중인 Activity는 BackStack에 담긴다
         * finish()로 현재 activity를 pop시킬수 있다
         */

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActIntentSecondActivity::class.java)
            startActivity(intent)
        }
    }
}