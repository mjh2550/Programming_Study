package com.mjh.inflean_kotlin.act_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.mjh.inflean_kotlin.R

class MainActIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_intent)

        /**
         * 10.
         * Intent함수에 세팅하고
         * StartActivity함수로 AOS에 전달시
         * AOS가 Activity찾아서 동작시킴
         *
         * Activity 전환시 실행중인 Activity는 BackStack에 담긴다
         * finish()로 현재 activity를 pop시킬수 있다
         */

        /*
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActIntentSecondActivity::class.java)
            startActivity(intent)
        }
        */

        /**
         * 11.
         * activity에서 다른 activity를 실행하고 다시 돌아왔을 때 어떤 처리가 필요하다면
         * startActivityForResult()를 사용한다
         *
         * startActivityForResult()사용하고 전환한 activity가 종료되면
         * OnactivityResult()가 실행된다
         */

        /*val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActIntentSecondActivity::class.java)
//            startActivity(intent)

            //deprecated
            startActivityForResult(intent,0)
        }*/
            /**
             * 11-1.startActivityForResult의 deprecated로 인한
             * registerForActivityResult 사용
             */
            val activityResultLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback<ActivityResult>() {
                    if(it.resultCode == RESULT_OK){
                        val myData : Intent? = it.data
                        val address = it.data?.getStringExtra("KEY1") ?: ""
                        Log.e("ERR",address)

                    }
                }
            )

            val button = findViewById<Button>(R.id.button)
            button.setOnClickListener {
                val intent = Intent(this, MainActIntentSecondActivity::class.java)
                activityResultLauncher.launch(intent)
            }




    }

}