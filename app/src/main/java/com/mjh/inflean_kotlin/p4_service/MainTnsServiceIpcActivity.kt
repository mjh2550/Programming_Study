package com.mjh.inflean_kotlin.p4_service

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_tns_service_ipc.*

class MainTnsServiceIpcActivity : AppCompatActivity() {

    //접속중인 서비스 객체
    var ipcService:TestService? = null

    val connection = object : ServiceConnection{
        //서비스 접속 성공시 호출되는 매서드
        //IBinder : 서비스의 onBind메서드가 반환하는 객체를 받는다.
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            //서비스 추출한다
            val binder = p1 as TestService.LocalBinder
            ipcService = binder.getService()
        }

        //서비스 접속 해제시
        override fun onServiceDisconnected(p0: ComponentName?) {
            ipcService = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tns_service_ipc)

        /**
         * 32. IPC
         * Activity에서 실행중인 서비스를 제어하거나 데이터를 사용하는 등의 작업이 필요할때 사용하는 개념
         * 현재 실행중인 서비스에 접속하고 서비스가 가지고 있는 메서드를 호출할 수 있는 개념
         */

        val serviceIntent = Intent(this,TestService::class.java)


        //서비스가 가동중이 아니라면 서비스를 갇홍
        val chk = isServiceRunning("com.mjh.inflean_kotlin.p4_service.TestService")
        if(chk ==false){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(serviceIntent)
            }else{
                startService(serviceIntent)
            }
        }

        //서비스 접속
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)

        ipc_btn_01.setOnClickListener {
            var value =  ipcService?.getNumber()
            ipc_tv_01.text = "value : $value"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }

    /**
     * 서비스 실행여부 체크 함수
     */
    fun isServiceRunning(name : String) : Boolean{
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        //현재 실행중인 서비스들을 가져온다 //보안상의 이유로 다른 서비스를 가져오지 못하게 deprecated 됨
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

        for (serviceInfo in serviceList){
            if(serviceInfo.service.className == name)
                return true
        }
        return false
    }
}