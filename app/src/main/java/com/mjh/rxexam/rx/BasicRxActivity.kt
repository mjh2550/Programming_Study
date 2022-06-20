package com.mjh.rxexam.rx

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mjh.rxexam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.newThread
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.*

class BasicRxActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
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
                Log.d("onNext",Thread.currentThread().name)

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
//            .subscribeOn(Schedulers.newThread())      //백그라운드 스레드 //UI 갱신 작업 시 사용
//            .subscribeOn(Schedulers.io())               //IO 스레드  //외부 API 호출 시 사용
//            .observeOn(AndroidSchedulers.mainThread()) //메인 스레드
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .subscribe(observer)

//       observable.unsubscribeOn(Schedulers.io())

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
        list.toObservable()
            .filter { it.length >= 5 }
            .subscribeBy(
                onNext = { println(it) },
                onError = { it.printStackTrace() },
                onComplete = { println("Done!") }
            )

        /**
         * subject 사용하기
         * Subject는 Observable과 Observer의 성격을 동시에 가진 Cold Observable이다.(multicast)
         * Hot Observable은 구독하면 데이터 방출하지만 Cold Observable은 바로 데이터를 방출한다.
         * RxKotlin의 문법으로 subscribe() 대신 더 편리한 subscribeBy() 문법을 사용한다
         */
        var testSubject = BehaviorSubject.createDefault(1)
        var test2Subject = BehaviorSubject.createDefault(2)
        var test3Subject = BehaviorSubject.createDefault(3)

        var testCSubject = BehaviorSubject.createDefault(4)
        var testC2Subject = BehaviorSubject.createDefault(5)

        //람다형식
        testSubject.map { 4 }
            .filter { it != 0 }
            .subscribeBy {
                println("test1 sub $it")//onNext
                test2Subject.onNext(it)
            }

        //괄호 형식
        test2Subject.subscribeBy(
            onNext = {
                println("test2 sub $it")
                test3Subject.onNext(it)
                testCSubject.onNext(it)
                testC2Subject.onNext(it)
            },
            onError = {
                println("test2 error")
            },
            onComplete = {
                println("test2 sub complete")
            }
        )


        //두 값을 비교할 때는 combineLatest 사용
        test3Subject.subscribeBy{
            param -> println("test3 sub $param")
                Observable.combineLatest(
                    testCSubject,
                    testC2Subject
                ){t1,t2 ->
                    println("compare t1 t2 : $t1 $t2")

                }.subscribeBy {
                    println("ok")
                }
        }

    }
}
