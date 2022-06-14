package com.mjh.rxexam.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mjh.rxexam.R
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlinx.android.synthetic.main.activity_calculate.*
import kotlinx.android.synthetic.main.activity_calculate.view.*
import java.util.ArrayList

class CalculateActivity : AppCompatActivity() ,View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        initBinding()

    }

    private fun initBinding(){
        btn_num_00.setOnClickListener(this)
        btn_num_01.setOnClickListener(this)
        btn_num_02.setOnClickListener(this)
        btn_num_03.setOnClickListener(this)
        btn_num_04.setOnClickListener(this)
        btn_num_05.setOnClickListener(this)
        btn_num_06.setOnClickListener(this)
        btn_num_07.setOnClickListener(this)
        btn_num_08.setOnClickListener(this)
        btn_num_09.setOnClickListener(this)
        btn_calc_multi.setOnClickListener(this)
        btn_calc_division.setOnClickListener(this)
        btn_calc_minus.setOnClickListener(this)
        btn_calc_plus.setOnClickListener(this)
        btn_calc_c.setOnClickListener(this)
        btn_calc_result.setOnClickListener(this)
    }


    private fun calculate(t1 : String , t2 : String, op: String) :String{
        var result = 0
        when(op){
            "*" ->{result = t1.toInt() * t2.toInt()}
            "/" ->{result = t1.toInt() / t2.toInt()}
            "+" ->{result = t1.toInt() + t2.toInt()}
            "-" ->{result = t1.toInt() - t2.toInt()}
        }
        return result.toString()
    }


    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btn_num_00 ->{tv_num.append("0")}
            R.id.btn_num_01 ->{tv_num.append("1")}
            R.id.btn_num_02 ->{tv_num.append("2")}
            R.id.btn_num_03 ->{tv_num.append("3")}
            R.id.btn_num_04 ->{tv_num.append("4")}
            R.id.btn_num_05 ->{tv_num.append("5")}
            R.id.btn_num_06 ->{tv_num.append("6")}
            R.id.btn_num_07 ->{tv_num.append("7")}
            R.id.btn_num_08 ->{tv_num.append("8")}
            R.id.btn_num_09 ->{tv_num.append("9")}
            R.id.btn_calc_c ->{
                clear()
            }
            R.id.btn_calc_multi ->{
                //연산자가 있으면 계산을 해버림
                if(tv_num_operator.text!=""){
                    val t1 = tv_num_result.text.toString()
                    val t2 = tv_num.text.toString()
                    val op = tv_num_operator.text.toString()
                    val result = calculate(t1,t2,op)
                    tv_num_result.text = result
                    tv_num_operator.text = "*"
                    tv_num.text = ""
                } else {
                    tv_num_result.text = tv_num.text
                    tv_num_operator.text = "*"
                    tv_num.text =""
                }
            }
            R.id.btn_calc_division ->{
                //연산자가 있으면 계산을 해버림
                if(tv_num_operator.text!=""){
                    val t1 = tv_num_result.text.toString()
                    val t2 = tv_num.text.toString()
                    val op = tv_num_operator.text.toString()
                    val result = calculate(t1,t2,op)
                    tv_num_result.text = result
                    tv_num_operator.text = "/"
                    tv_num.text = ""
                } else {
                    tv_num_result.text = tv_num.text
                    tv_num_operator.text = "/"
                    tv_num.text =""
                }
            }
            R.id.btn_calc_minus ->{
                //연산자가 있으면 계산을 해버림
                if(tv_num_operator.text!=""){
                    val t1 = tv_num_result.text.toString()
                    val t2 = tv_num.text.toString()
                    val op = tv_num_operator.text.toString()
                    val result = calculate(t1,t2,op)
                    tv_num_result.text = result
                    tv_num_operator.text = "-"
                    tv_num.text = ""
                } else {
                    tv_num_result.text = tv_num.text
                    tv_num_operator.text = "-"
                    tv_num.text =""
                }
            }
            R.id.btn_calc_plus ->{
                //연산자가 있으면 계산을 해버림
                if(tv_num_operator.text!=""){
                    val t1 = tv_num_result.text.toString()
                    val t2 = tv_num.text.toString()
                    val op = tv_num_operator.text.toString()
                    val result = calculate(t1,t2,op)
                    tv_num_result.text = result
                    tv_num_operator.text = "+"
                    tv_num.text = ""
                } else {
                    tv_num_result.text = tv_num.text
                    tv_num_operator.text = "+"
                    tv_num.text =""
                }
            }
            R.id.btn_calc_result -> {
              if(tv_num_result.text!=null){
                  val t1 = tv_num_result.text.toString()
                  val t2 = tv_num.text.toString()
                  val op = tv_num_operator.text.toString()
                  val result = calculate(t1,t2,op)
                  tv_num_result.text = result
                  tv_num.text = ""
                  tv_num_operator.text = ""
              }
            }
        }
    }

    private fun clear() {
        tv_num.text = ""
        tv_num_result.text = ""
        tv_num_operator.text = ""
    }

    private fun checkLastText(): Boolean {
        val operation = "+-*/".toCharArray()
        var flag = false
        for (i in operation) {
            if (i == tv_num.text.last()) {
                flag = true
            }
        }
        return flag
    }
}