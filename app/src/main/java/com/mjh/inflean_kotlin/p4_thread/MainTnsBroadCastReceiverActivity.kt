package com.mjh.inflean_kotlin.p4_thread

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_tns_broad_cast_receiver.*
import java.security.Provider
import java.util.jar.Manifest

class MainTnsBroadCastReceiverActivity : AppCompatActivity() {

    val br = TestReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tns_broad_cast_receiver)

        /**
         * 29. BroadcastReceiver
         * 특정상황에서 조건을 받아들여 동작하는 실행단위이다.
         * 반드시 외부에서 접근할수있는 이름을 가져야 함
         *
         * 8.0 부터는 일부 Receiver는 코드를 통해서만 등록 가능(보안상의 이유로 내부동작을 위함)
         */

        registerReceiver(br,IntentFilter("android.intent.action.BOOT_COMPLETED"))
        registerReceiver(br,IntentFilter("android.provider.Telephony.SMS_RECEIVED"))

        //8.0+ 일때는 구독자 추가, 해제
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
         val filter = IntentFilter("com.mjh.inflean_kotlin.receiver")
            registerReceiver(br,filter)
        }

        //IntentFilter xml등록후 실행은 7.0 이하로만 가능
        br_btn_01.setOnClickListener {
//            var brIntent = Intent(this,TestReceiver::class.java)
            var brIntent = Intent("com.mjh.inflean_kotlin.receiver")

            sendBroadcast(brIntent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            unregisterReceiver(br)
        }
    }
}