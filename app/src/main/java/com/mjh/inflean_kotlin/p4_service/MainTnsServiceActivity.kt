package com.mjh.inflean_kotlin.p4_service

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_tns_service.*
import kotlin.concurrent.thread

class MainTnsServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tns_service)

        /**
         * 31. Service
         *  백그라운드에서 돌아감
         *  보통 서비스에서 스레드 많이 쓴다
         *
         *  8.0+ 부터 장시간 이용되는 백그라운드 서비스는 중지시키기도 함
         *  포그라운드 서비스로 방지가 가능 (서비스 운영중임을 notification을 통해 사용자에게 알림)
         */

        val serviceIntent = Intent(this,TestService::class.java)

        svi_btn_01.setOnClickListener {

            //8.0+ 는 startForegroundService 권장
            //FOREGROUND_SERVICE 권한이 있어야 한다.
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            }else {
                startService(serviceIntent)
            }
        }

        svi_btn_02.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}