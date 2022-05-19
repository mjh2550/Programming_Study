package com.mjh.inflean_kotlin.p2_act.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mjh.inflean_kotlin.R

class MainActActionActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button

    val permission_list = arrayOf(
        android.Manifest.permission.CALL_PHONE
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_action)

        textView = findViewById(R.id.ac_textView)
        button = findViewById(R.id.ac_button)

        requestPermissions(permission_list,0)

        /**
         * 15.
         * 안드로이드 기본 제공하는 다양한 액티비티들
         *
         * a.구글지도 실행시키기
         * b.(단말기 내에 설치된) 웹 브라우저 실행시키기
         *
         *
         */

        //지도 앱
//            val uri = Uri.parse("geo:37.243243,131.861601")
//            textView.text = "지도 실행"


        //웹 실행
        textView.text = "웹 실행"
//        val uri = Uri.parse("https://developer.android.com")


        //다이얼 실행
//        textView.text = "다이얼 실행"
//        val uri = Uri.parse("tel:12341244")

        //전화걸기
        textView.text = "전화걸기"
        val uri = Uri.parse("tel:12341244")


        //url보고 actionView가 실행을 결정
        // 스키마가 geo이면 지도 앱을 실행시킴
//        val intent = Intent(Intent(Intent.ACTION_VIEW, uri)) //연결 프로그램 팝업 띄우기
//        val intent = Intent(Intent(Intent.ACTION_DIAL, uri))//다이얼화면 띄우기
        val intent = Intent(Intent(Intent.ACTION_CALL, uri)) //전화걸기 //권한 거부시 에러

        button.setOnClickListener {

            startActivity(intent)
        }




    }
}