package com.mjh.inflean_kotlin.p2_act.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mjh.inflean_kotlin.R

class MainActIntentDataSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_intent_data_second)

        /**
         * 12강은 간단하여 생략
         * 13.
         */

        val obj1 = intent.getParcelableExtra<parcelableClass>("obj1")
        //companion CREATOR 의 createFromParcel 호출

        val textView = findViewById<TextView>(R.id.second_data_textView)
        textView.apply {
            text = "obj1?.data2 : ${obj1?.data1}\n"
            append("obj1?.data2 : ${obj1?.data2}\n")
        }


        val button = findViewById<Button>(R.id.second_data_button)
        button.setOnClickListener {

            val t2 = parcelableClass().apply {
                data1 = 33
                data2 = "data2입니다"
            }

            val result_intent = Intent(this, MainActIntentDataActivity::class.java).apply {
                putExtra("obj2",t2)
            }
            setResult(RESULT_OK,result_intent)

            finish()
        }
    }
}