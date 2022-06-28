package com.mjh.rxexam.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.mjh.rxexam.R
import com.mjh.rxexam.databinding.ActivityRxMainOneBinding
import io.reactivex.Observable
import io.reactivex.Observable.just
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.*

class RxMainOneActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityRxMainOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_rx_main_one)
        mBinding = ActivityRxMainOneBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //일반 pull 방식
    /*    var number = 4
        var isEve = isEven(number)
        println("num "+(if (isEve) "Even" else "Odd"))
        number = 9
        isEve = isEven(number)
        println("num "+(if (isEve) "Even" else "Odd"))*/


        //reactive 하게 바꿔보자
        val viewData =  mutableStateOf("")
        val subject : Subject<String> = PublishSubject.create()

        //binding
        subject.subscribeBy { viewData.value = it }

        /*subject.onNext(4)
        subject.onNext(9)*/

        mBinding.editTextTextPersonName.doAfterTextChanged {
            Log.d("changed","$it")
            subject.onNext(it.toString())
            mBinding.tvRx01.text = viewData.value
        }

        mBinding.btnRx01.setOnClickListener {

        }

        /**
         * 예제1.
         */

      /*  val list = listOf("One",2,"Three","Four",4.5,"Five",6.0f)
        val iterator = list.iterator()
        while (iterator.hasNext()){
            println(iterator.next())
        }

        val observable : Observable<Any> = list.toObservable()

        observable.subscribeBy (
            onNext = {println(it)},
            onError = {it.printStackTrace()},
            onComplete = { println("Done!")}
        )*/



    }

    fun isEven(n:Int):Boolean = (n%2 == 0)
}