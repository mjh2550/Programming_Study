package com.mjh.inflean_kotlin.p2_act.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mjh.inflean_kotlin.R

class MainActIntentDataActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_act_intent_data)

        /**
         * 12.
         */
        /*val data_button = findViewById<Button>(R.id.data_button)
        data_button.setOnClickListener {
            val intent = Intent(this, MainActIntentSecondActivity::class.java)
            intent.putExtra("ta","ta")
            startActivity(intent)
//            startActivityForResult(intent,0)
        }*/


        /**
         * 13.
         *
         * Intent를 통해 객체를 전달 할 때는 객체 직렬화를 해야하는데
         * 안드로이드 Parcelable인터페이스를 사용한다.
         *
         * 객체 직렬화를 해야 전달할 수 있다.(직렬화는 Byte data로 변환하는 것)
         *
         * 객체를 전달할 때 객체 내부의 Parcel에 객체의 data들을 담고,
         * 이동한 객체에서 Parcel에 담긴 data를 추출하여 새로운 객체에 담는다.
         * 그러므로 객체 자체를 전달하는 것은 아니다.
         *
         */
        textView = findViewById(R.id.data_textView)

        val data_button = findViewById<Button>(R.id.data_button)
        data_button.setOnClickListener {
            val intent = Intent(this, MainActIntentDataSecondActivity::class.java)

            val t1 = parcelableClass().apply {
                data1 = 100
                data2 = "문자열1"
            }

            intent.putExtra("obj1",t1)

//            startActivity(intent)
            startActivityForResult(intent,0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==0){
            if(resultCode== RESULT_OK){
                val obj2 = data?.getParcelableExtra<parcelableClass>("obj2")
                textView.apply {
                    text = "obj2.data1 : ${obj2?.data1}\n"
                    append("obj2.data1 : ${obj2?.data2}\n")

                }


            }


        }

    }
}