package com.mjh.inflean_kotlin.p2_act.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mjh.inflean_kotlin.R

class MainActIntentSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_intent_second)


        /**
         * 10.
         * 11.
         */
      /*  val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            finish()
        }*/

        /**
         * 11-1.
         */
        val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(applicationContext, MainActIntentActivity::class.java).apply {
                putExtra("KEY1","testData")
            }
            setResult(RESULT_OK,intent)

            if(! isFinishing)finish()
        }


    }
}