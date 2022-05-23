package com.mjh.inflean_kotlin.p4_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_tns_thread.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainTnsThreadActivity : AppCompatActivity() {
    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tns_thread)

        /**
         * 25.
         * Thread
         *
         * 화면처리는 Main Thread에서만 하고 나머진 작업스레드에서 처리
         * Main Thread는 항상 유휴상태로 만들어 놔야 함.
         * 오래걸리는 작업은 무조껀 작업스레드에서 처리해야함
         *
         * 작업스레드 도중 중간 화면처리(프로그레스 바 같은) 역시 메인에서만 가능함.
         * 오레오(8.0+)에서는 발생시킨 Thread에서도 화면처리가 가능함.
         *
         */

        th_btn_01.setOnClickListener {
            val now = System.currentTimeMillis()
            th_tv_01.text = "버튼클릭 : $now"
        }

        //무한루프 //메인스레드가 이거 처리하느라 업데이트를 못함
        /*while (true){
            SystemClock.sleep(100)
            val now2 = System.currentTimeMillis()
            Log.d("test","while 문 : ${now2}")
        }*/

        isRunning = true

        val th1 = object : Thread (){
            override fun run() {
                super.run()
//                val coroutineScope = CoroutineScope(Dispatchers.Main)
//                val co1 = coroutineScope.launch {
                    while (isRunning){
                          SystemClock.sleep(100)
                          val now2 = System.currentTimeMillis()
                          Log.d("test","coroutine : ${now2}")

                        //화면처리 8.0+가능
                        th_tv_02.text = "Thread : ${now2}"
                    }

//                }
            }
        }
        th1.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}