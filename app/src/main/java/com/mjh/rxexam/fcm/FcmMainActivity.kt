package com.mjh.rxexam.fcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.mjh.rxexam.R

class FcmMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcm_main)

        val tv_01 = findViewById<TextView>(R.id.tv_01)
        val btn_02 = findViewById<Button>(R.id.btn_02)
        val firebaseMessaging = FirebaseMessaging.getInstance()

        btn_02.setOnClickListener {
            //TODO FCM TOKEN 받기
            firebaseMessaging.token.addOnCompleteListener(OnCompleteListener {
                    task ->
                if(!task.isSuccessful){
                    Log.d("fcmT","Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result
                Toast.makeText(baseContext,token.toString(),Toast.LENGTH_SHORT).show()
                Log.d("fcmToken",token.toString())
                tv_01.text=token.toString()
            })
        }



    }
}