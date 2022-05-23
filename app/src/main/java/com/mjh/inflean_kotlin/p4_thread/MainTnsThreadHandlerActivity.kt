package com.mjh.inflean_kotlin.p4_thread

import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_act_intent_second.*
import kotlinx.android.synthetic.main.activity_main_tns_thread.*
import kotlinx.android.synthetic.main.activity_main_tns_thread_handler.*
import kotlin.concurrent.thread

class MainTnsThreadHandlerActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tns_thread_handler)

        /**
         * 26. handler
         * handler는 개발자가 안드로이드 OS에게 작업수행을 요청하는 역할을 한다.
         * 개발자가 작업 요청 시 OS는 작업안할 때 개발자의 요청작업을 처리함
         *
         * Main thread에서 처리하기 위해 사용
         * 5초이상 작업은 피하는게 좋다.
         * 화면처리도 가능
         *
         * 작업단위가 크면 메인이 업데이트 되는데 오래걸린다.
         */

        th_btn_02.setOnClickListener {
            val now = System.currentTimeMillis()
            th_tv_04.text = "버튼클릭 : $now"
        }

     /*   val handler = Handler(Looper.myLooper()!!)
        //처리 한번에 대한 작업을 구현해준다.
        val thread = object : Thread(){
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                th_tv_03.text = "handler : ${now2}"

                //쉬는 시간
                handler.postDelayed(this,100)
            }

        }
        */

        /**
         * 27.
         * 핸들러를 통해 데이터 넘기고 화면 업데이트 하기
         */
        val handler1 = object : Handler (Looper.myLooper()!!){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when(msg.what){
                    0->{
                        th_tv_03.text = "Handler : 0"
                    }
                    1-> {
                        th_tv_03.text = "Handler : 1"
                    }
                    2-> {
                        th_tv_03.text = "Handler : 2 : ${msg.arg1} , ${msg.arg2} , ${msg.obj}"
                    }
                }
            }
        }

        //오래걸리는 작업 - 쓰레드 발생
        isRunning = true
        thread {
            while (isRunning){
                val now2 = System.currentTimeMillis()
                Log.d("test","오래걸리는 작업 : ${now2}")
                SystemClock.sleep(500)
                handler1.sendEmptyMessage(0)
                SystemClock.sleep(500)
                handler1.sendEmptyMessage(1)

                SystemClock.sleep(500)
                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "객체"
                handler1.sendMessage(msg)
            }
        }


    }
    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}