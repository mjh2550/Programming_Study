package com.example.section1_clone.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.section1_clone.MainActivity
import com.example.section1_clone.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btn_01 : Button = findViewById(R.id.btn_01)
        val btn_02 : Button = findViewById(R.id.btn_02)

        btn_01.setOnClickListener(ButtonListener01())
        btn_02.setOnClickListener(ButtonListener02())




    }
    inner class ButtonListener01 : View.OnClickListener {
        override fun onClick(v: View?) {
            val intent = Intent(this@IntroActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }

    inner class ButtonListener02 : View.OnClickListener {
        override fun onClick(v: View?) {
            
        }
    }
}