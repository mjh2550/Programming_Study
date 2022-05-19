package com.mjh.inflean_kotlin.p2_act.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjh.inflean_kotlin.R

class MainActIntentFilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_intent_filter)

        /**
         * 14.
         * 인텐트 필터에서 다른 앱 띄울 화면 activity에
         * 해당 패키지명을 적어놓으면
         * 해당 패키지명의 앱 실행이 가능하다.
         * <action android:name ="packageName"/>
         * <category android:name ="안드로이드 intent 라이브러리 패키지.Default"/>
         *
         * 주의할 것. 안드로이드 앱의 패키지명이 정의되지 않았다면 호출할 수 없다.
         */
    }
}