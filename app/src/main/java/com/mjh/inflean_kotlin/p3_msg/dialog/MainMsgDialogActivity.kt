package com.mjh.inflean_kotlin.p3_msg.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import com.mjh.inflean_kotlin.R
import com.mjh.inflean_kotlin.databinding.ActivityMainActActionBinding.inflate
import com.mjh.inflean_kotlin.databinding.ActivityMainActIntentBinding.inflate
import kotlinx.android.synthetic.main.activity_main_msg_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import java.util.*

class MainMsgDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_msg_dialog)

        /**
         * 17.
         *
         *  Dialog
         * -메시지 전달용도
         * -출력 시 View를 이용할 수 없다. (Activity는 onPause상태로 돌아감)
         */



        //1. 기본다이얼로그
      /*  dia_button.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("기본 다이얼로그")
                setMessage("기본 다얼로그 입니다.")
                setIcon(R.mipmap.ic_launcher)

                //버튼 위치에 따라서
                setPositiveButton("Positive"){dialogInterface, i ->
                    dia_textView.text = "Pos"
                }
                setNeutralButton("Neutral"){it, i ->
                    dia_textView.text = "Neu"
                }
                setNegativeButton("Negative"){it, i ->
                    dia_textView.text = "Neg"
                }
            }.show()
        }*/

        //2. 커스텀 다이얼로그
        dia_button.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("커스텀 다이얼로그")
                setIcon(R.mipmap.ic_launcher)
                /**
                Layout Inflater 사용법

                val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                context 에서 LayoutInflater 를 가져온다.

                val inflater : LayoutInflater = getLayoutInflater()
                activity 에서 LayoutInflater 를 얻어온다. (Activity 는 자신의 window의 LayoutInflater 를 사용)

                val inflater : LayoutInflater = LayoutInflater.from(context)
                LayoutInflater 에 static 으로 정의되어있는 LayoutInflater.from()을 이용해 LayoutInflater 를 만든다.


                출처: https://yejinson97gaegul.tistory.com/entry/안드로이드-Android-LayoutInflater [코딩하는 개굴이]
                 */

                val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val custom_view = inflater.inflate(R.layout.custom_dialog, null)
                setView(custom_view)

                //버튼 위치에 따라서
                setPositiveButton("확인"){dialogInterface, i ->
                    dia_textView.text = "Pos"
                    custom_view.run{
                        dia_textView.text="${custom_edit1.text}\n${custom_edit2.text}\n"
                    }
                }
                setNegativeButton("취소"){it, i ->
                    dia_textView.text = "Neg"
                }
            }.show()
        }


        //3.DatePicker
      /*  dia_pickerbt.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val listener = object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    dia_textView.text ="${p1}년 ${p2+1}월 ${p3}일"
                }
            }
            val picker = DatePickerDialog(this, listener,year,month,day).show()
        }*/

        //4.Timepicker
        dia_pickerbt.setOnClickListener {
            val calendar = Calendar.getInstance()

            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)
//            val second = calendar.get(Calendar.DAY_OF_MONTH)
            val listener = object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    dia_textView.text = "${p1}시 ${p2}분"
                }

            }
            val picker = TimePickerDialog(this, listener,hour,minute,true).show()
        }
    }
}