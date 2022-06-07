package com.mjh.rxexam.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mjh.rxexam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.newThread
import java.util.*

class BasicRxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_rx)

        /**
         * Reactive Programing
         * Reference : dev-daddy.tistory.com
         *
         * RxJava를 써보자.
         *
         *
        Rx = Observable + Observer + Scheduler

        Observable
        데이터 스트림, 생애주기동안 한번만 데이터 방출,
        얘는 공급자라고 생각하자, 데이터를 처리하고 다른 구성요소에 전달함.

        Observers
        Observable 에 의해 방출된 데이터 스트림을 소비한다.
        subscribeOn() 메서드를 사용해서 observable 을 구독하고 Observable이 방출하는 데이터를 수신할 수 있다.
        Observable이 데이터를 방출 할 때마다 등록 된 모든 observer는 onNext() 콜백으로 데이터를 수신한다.

        Schedulers
        Observable와 observer에게 실행되어야 할 스레드를 알려주는 Rx구성요소
        observerOn()으로 observers에게 관찰해야 할 스레드를 알려줄 수 있다.
        scheduleOn()으로 observable에게 실행해야 할 스레드를 알려줄 수 있다.
        RxJava에서 제공 된 메인 기본 스레드는 새로운 백그라운드를 생성한다.
        Schedulers.io()는 IO 스레드에서 코드를 실행할 것이다.

         */


        //1.Observable 데이터를 공급한다(방류(emit)한다)
        // just로 데이터 바로 보낼 수 있고, filter로 데이터 필터, map으로 데이터 가공이 가능하다.
        val observable = Observable
            .create<Int>{
              it.onNext(333)
              it.onNext(320)
              it.onNext(99)
              it.onComplete()
            }.filter{
                it > 100
            }

        //2.Observer onNext()콜백으로 데이터를 수신한다.
        val observer = object : Observer<Int>{
            override fun onSubscribe(d: Disposable) {
                Log.d("onSubscribe"," : $d")
            }

            override fun onNext(t: Int) {
                Log.d("onNext"," : $t")
            }

            override fun onError(e: Throwable) {
                Log.d("onError"," : $e")
            }

            override fun onComplete() {
                Log.d("onComplete","Rx")
            }

        }

        //3.Scheduler로 스레드 스코프를 정한다.
        //subscribOn 공급자의 스레드, observeOn 수신자의 스레드
        observable
//            .subscribeOn(Schedulers.newThread())      //백그라운드 스레드
            .subscribeOn(Schedulers.io())               //IO 스레드
            .observeOn(AndroidSchedulers.mainThread()) //메인 스레드
            .subscribe(observer)

    }
}
