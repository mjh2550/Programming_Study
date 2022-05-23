package com.mjh.inflean_kotlin.p3_msg.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_msg_pending_intent.*

class MainMsgPendingIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_msg_pending_intent)

        val data1 = intent.getIntExtra("data1",0)
        val data2 = intent.getIntExtra("data2",0)

        pend_tv1.text = "data 1 : ${data1}, data 2: ${data2}"
    }
}