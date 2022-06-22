package com.mjh.rxexam.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.mjh.rxexam.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class HiltMainActivity  : AppCompatActivity() {


//    @Inject lateinit var prStr : String
//    @Inject lateinit var data: Data
//    @Inject lateinit var data2 : Data2
//    @Inject lateinit var repository: HiltRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_main)

        /**
         * Dagger Hilt 사용
         *
         * Application 에 항상 @HiltAndroidApp 필수로 지정해야한다.
         * Module 클래스에서 데이터를 주입받는다.
         * Module 에서는 @Module 을 사용하고, @Installin 을 통해 Install 하려는 component 를 지정해야한다.
         * Module 에 @Named 를 사용하여 네이밍 할 수 있다.
         * Install 된 component 는 자신만의 lifetime 을 갖고있으므로, 고려하여 Install 한다.
         * Activity , fragment , view, service,BroadCastReceiver 에 주입 받을 수 있다.(3대 컴포넌트 + view)
         * 3대컴포넌트 외에 주입받으려면 @EntryPoint 와 @Installin 을 사용하여 주입할 수 있다.
         *
         */

//        data.set(33333) //데이터를 주입할 수 있지만, 객체지향 원칙에 어긋난다.(의존역전원칙)

//        println("prStr : $prStr")
//        println("prData : ${data.getData()}")
////        println("prData2 : ${data2.getData2()}")
//        println("prData3 : ${data2.test()}")


    }
}