package com.mjh.rxexam.rx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mjh.rxexam.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.observers.TestObserver
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.TimeUnit


class MainRxSubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_rx_subject)

        /**
         * https://tourspace.tistory.com/281
         *
         * Hot observable을 구현시 publish() 이외에 subject를 이용할 수 도 있습니다.
         * Subject는 Observer 역할을 하기 때문에 여러 Observable에 구독을 신청할 수 있고,
         * Overvable의 역할도 하기 때문에 받은 item을 재배출 하거나,
         * 새로운 값을 배출할 수 있습니다.
         * Observable이면서 Observer인거죠.
         *
         */


//        publishSubject()
//        behaviorSubject()
//        asyncSubject()
//        replaySubject()
        etcSubject()


    }

    private fun publishSubject() {
        /**
         * 1.PublishSubject
         * PublishSubject를 등록할 경우 등록 시점부터 이후 데이터를 전달 받습니다.
         */
        val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
        val subject = PublishSubject.create<Long>()
        observable.subscribe(subject)
        runBlocking { delay(300) }
        subject.subscribe { println("1st: $it") }
        runBlocking { delay(300) }
        subject.subscribe { println("2nd: $it") }
        runBlocking { delay(300) }
    }

    private fun behaviorSubject() {
        /**
         * 2.BehaviorSubject
         * BehaviorSubject의 경우 등록 시점에 이전에 배출된 직전값 하나를 전달받고 시작합니다.
         * 위와 동일한 예제에서 subject만 교체합니다.
         */
        val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
        val subject = BehaviorSubject.create<Long>()
        observable.subscribe(subject)
        runBlocking { delay(300) }
        subject.subscribe { println("1st: $it") }
        runBlocking { delay(300) }
        subject.subscribe { println("2nd: $it") }
        runBlocking { delay(300) }
    }

    private fun asyncSubject() {
        /**
         * 3.AsyncSubject
         * AsyncSubject는 Observable의 마지막값을 한번만 배출합니다.
         * 위와 동일한 예제를 사용할 경우 Observable을 interval로 생성하여, 마지막 값이 존재 하지 않습니다. (시간단위로 무한으로 아이템을 생성하기 때문입니다.)
         * 따라서 interval 대신 just를 이용하여 지정된 배출 개수를 갖는 Observable을 생성하여 동작을 확인합니다.
         */
        val observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val subject = AsyncSubject.create<Int>()
        observable.subscribe(subject)
        subject.subscribe { println("1st: $it") }
        subject.subscribe { println("2nd: $it") }
    }

    private fun replaySubject() {
        /**
         * 4.ReplaySubject
         * ReplaySubject 는 cold observable과 유사하게 등록 시점 이전값을 모두 전달받은후 새로 배출되는 값을 전달 받습니다.
         */
        val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
        val subject = ReplaySubject.create<Long>()
        observable.subscribe(subject)
        runBlocking { delay(300) }
        subject.subscribe { println("1st: $it") }
        runBlocking { delay(300) }
        subject.subscribe { println("2nd: $it") }
        runBlocking { delay(300) }
    }

    private fun etcSubject() {
        /**
         * Subject를 Observable로 활용
         * 위 예제의 경우 Observable에 subscriber로 subject를 등록하여 사용합니다.
         * 하지만 Observable없이 단독으로 subject만으로 Observable역할을 수행하도록 할 수 있습니다.
         */
        val observer = object : Observer<String> {
            override fun onComplete() {}
            override fun onNext(item: String) = println("onNext() - $item")
            override fun onError(e: Throwable) {}
            override fun onSubscribe(d: Disposable) {}
        }

        val publicSubject = PublishSubject.create<String>()
        publicSubject.subscribe(observer)

        val asyncSubject = AsyncSubject.create<String>()
        asyncSubject.subscribe(observer)

        val behaviorSubject = BehaviorSubject.create<String>()
        behaviorSubject.subscribe(observer)

        val replaySubject = ReplaySubject.create<String>()
        replaySubject.subscribe(observer)

        (1..3).forEach {
            publicSubject.onNext("public: $it")
            asyncSubject.onNext("async: $it")
            behaviorSubject.onNext("behavior: $it")
            replaySubject.onNext("replay: $it")
        }
        asyncSubject.onComplete()
    }
}