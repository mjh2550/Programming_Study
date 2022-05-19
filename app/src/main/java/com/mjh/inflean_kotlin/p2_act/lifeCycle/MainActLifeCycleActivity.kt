package com.mjh.inflean_kotlin.p2_act.lifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mjh.inflean_kotlin.R

class MainActLifeCycleActivity : AppCompatActivity() {
    //activity 생성 될 때 자동으로 호출된다.
    //화면 전환 발생 시 자동발생, 그때는 따로만들어야 함
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_act_life_cycle)

        /**
         * application은 안드로이드 OS에 의해 실행단위를 관리하는 개념이다
         * application은 4개의 구성요소를 가짐
         * Activity, Service, BroadCaste Receiver , Content Provider
         *
         * Activity
         * 현재보이는 화면
         */


        Log.d("test1", "onc")

    }

    //oncreate 이후 자동호출
    //activity 정지 상태 후 활동 상태일 때 호출
    override fun onStart() {
        super.onStart()
        Log.d("test1", "onSt")
    }

    //onstart 이후 자동호출
    //at가 일시정지 후 돌아올때 호출
    override fun onResume() {
        super.onResume()
        Log.d("test1", "onRm")
    }

    //at 가 정지후 활동일 때 onstart전 호출
    override fun onRestart() {
        super.onRestart()
        Log.d("test1", "onRs")
    }

    //at가 일시정지 상태일때 호출
    //화면상에서 사라지거나 팝업창 같은거 나타날때 호출
    override fun onPause() {
        super.onPause()
        Log.d("test1", "onPa")
    }

    //at가 화면에서 사라질 때 호출
    override fun onStop() {
        super.onStop()
        Log.d("test1", "onSp")
    }

    //현재 at의 수행이 완전히 종료되어 제거될 때 호출
    override fun onDestroy() {
        super.onDestroy()
        Log.d("test1", "onDe")
    }
}