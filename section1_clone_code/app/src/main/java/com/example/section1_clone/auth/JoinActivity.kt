package com.example.section1_clone.auth

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.section1_clone.MainActivity
import com.example.section1_clone.R
import com.example.section1_clone.model.UserInfo
import com.google.android.material.textfield.TextInputEditText

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val btnJoin = findViewById<Button>(R.id.btnJoin)
        btnJoin.setOnClickListener {
            setBinding()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }


    private fun setBinding() {
        val email = findViewById<TextInputEditText>(R.id.edt_email)

        val userInfo =  UserInfo(email =     email.text.toString()
                                ,pwd =       email.text.toString()
                                ,pwdCheck =  email.text.toString()
                                ,nickname =  email.text.toString()
                                ,sex =       email.text.toString()
                                ,location =  email.text.toString()
                                ,age =      29)

        Log.d(TAG, "setBinding: $userInfo" )

    }
}