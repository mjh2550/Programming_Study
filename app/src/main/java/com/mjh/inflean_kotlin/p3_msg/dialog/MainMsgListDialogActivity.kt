package com.mjh.inflean_kotlin.p3_msg.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_msg_list_dialog.*

class MainMsgListDialogActivity : AppCompatActivity() {

//    val data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6","항목7","항목8")

    val data2 = arrayOf("토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국")
    val data3 = intArrayOf(
        R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
        ,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_msg_list_dialog)

        /**
         * 19.
         * List Dialog
         *
         */

        //기본 리스트 다이얼로그
        /*dia_list_bt.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("리스트 다이얼로그")
                setNegativeButton("취소",null)
                setItems(data1){it, i ->
                    dia_lit_tv.text = "기본 리스트 다이얼로그 : ${data1[i]}"
                }
            }.show()
        }*/


        //커스텀 리스트 다이얼로그
        dia_list_bt.setOnClickListener {
            val list1 = ArrayList<HashMap<String,Any?>>()

            for(idx in data2.indices){
                val map = HashMap<String,Any?>()
                map["data2"] = data2[idx] //In Java : map.put("data2",data2[idx])
                map["data3"] = data3[idx]

                list1.add(map)
            }

            val keys = arrayOf("data2","data3")
            val ids = intArrayOf(R.id.custom_tv, R.id.custom_img)

            val adapter =  SimpleAdapter(this,list1,R.layout.custom_list,keys,ids)

            AlertDialog.Builder(this).apply {
                setAdapter(adapter){
                    it, i ->
                    dia_lit_tv.text = "커스텀 다이얼로그 : ${data2[i]}"

                }
                setTitle("커스텀 리스트 다이얼로그")
                setNegativeButton("취소",null)
            }.show()
        }


    }
}