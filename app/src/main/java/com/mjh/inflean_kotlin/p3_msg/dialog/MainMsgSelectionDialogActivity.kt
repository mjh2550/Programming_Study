package com.mjh.inflean_kotlin.p3_msg.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_msg_list_dialog.*
import kotlinx.android.synthetic.main.activity_main_msg_selection_dialog.*

class MainMsgSelectionDialogActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "항목1" , "항목2" , "항목3" , "항목4" , "항목5" , "항목6" , "항목7" , "항목8"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_msg_selection_dialog)

        /**
         * 20.
         *  단일 선택 Dialog
         *  -setSingleChoiceItems 메서드로 구현
         *  -라디오버튼 형태
         */

        //단일선택 dialog
     /*   dia_sel_bt.setOnClickListener {
            val builder = AlertDialog.Builder(this).apply {
                setTitle("single Choice List")
                setSingleChoiceItems(data1, 3){it, i ->
                    val t1 = Toast.makeText(this@MainMsgSelectionDialogActivity, data1[i],Toast.LENGTH_SHORT)
                    t1.show()
                }

                setNegativeButton("취소",null)
                setPositiveButton("확인"){it, i ->

                    //DialogInterface 형변환환
                    val alert = it as AlertDialog

                   //선택된 idx
                    val idx = alert.listView.checkedItemPosition

                    dia_sel_tv.text = "선택된 항목 : ${data1[idx]}"
                }
            }.show()
        }*/

        /**
         * 다중선택 Dialog
         * -체크박스
         */

        dia_sel_bt.setOnClickListener {
            val booleanArray = booleanArrayOf(true,false,false,true,false,false,false,false)
            val builder = AlertDialog.Builder(this).apply {
                setTitle("multi Choice List")

                //체크변경시 바로 동작하는 리스너 세팅
                setMultiChoiceItems(data1,booleanArray){it,i,b ->
                    if(b==true){
                        Toast.makeText(this@MainMsgSelectionDialogActivity,"${data1[i]}가 체크 되었습니다.",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainMsgSelectionDialogActivity,"${data1[i]}가 체크해제되었습니다.",Toast.LENGTH_SHORT).show()
                    }

                }
                setNegativeButton("취소",null)
                setPositiveButton("확인"){it, i ->

                    //DialogInterface 형변환환
                    val alert = it as AlertDialog

                    dia_sel_tv.text = ""

                    //boolean array
                    val positions = alert.listView.checkedItemPositions

                    for(i in 0 until positions.size()){
                        //체크상태가 변경된 항목의 인덱스 번호를 추출
                        val index = positions.keyAt(i) //인덱스번호
                        if(positions.get(index) ==true){//t일때만 추출
                            dia_sel_tv.append("${data1[index]},")
                        }
                    }
                }
            }.show()
        }
    }
}