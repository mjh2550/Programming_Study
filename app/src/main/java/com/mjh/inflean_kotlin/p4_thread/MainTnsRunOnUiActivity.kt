package com.mjh.inflean_kotlin.p4_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_act_intent_second.*
import kotlinx.android.synthetic.main.activity_main_tns_run_on_ui.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainTnsRunOnUiActivity : AppCompatActivity() {

    var isRunning = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tns_run_on_ui)

        /**
         * 28. RunOnUIThread
         * 작업스레드에서 처리 중 화면처리를 해야할 때
         * handler보다 간단하게 처리할 수 있다.
         *
         */




        isRunning = true
        
        //스레드
        /* thread {
            while (isRunning){
                SystemClock.sleep(500)
                val now2 = System.currentTimeMillis()
                Log.d("test","thread : $now2")

                runOnUiThread(object :Thread(){
                    override fun run() {
                        super.run()
                        th_tv_05.text = "runOnUithread : ${now2}"
                    }
                })
                //람다
                runOnUiThread{
                    th_tv_05.text = "runOnUiThread : $now2"
                }

                SystemClock.sleep(500)

                runOnUiThread{
                    th_tv_05.text = "runOnUiThread2222 : $now2"
                }

            }
        }*/

        //코루틴
        val coroutineScope = CoroutineScope(Dispatchers.Default)
            val co1 = coroutineScope.launch {
                while (isRunning) {
                    delay(500)
                    val now2 = System.currentTimeMillis()
                    Log.d("test", "thread : $now2")

                    runOnUiThread {
                        th_tv_05.text = "runOnUiThread : $now2"
                    }

                    delay(500)

                    runOnUiThread {
                        th_tv_05.text = "runOnUiThread2222 : $now2"

                    }
                }
        }

        th_btn_03.setOnClickListener {
            val now = System.currentTimeMillis()
            th_tv_06.text = "버튼 클릭 : $now"
            isRunning = !isRunning
        }
    }
}