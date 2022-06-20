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


    @Inject lateinit var prStr : String
    @Inject lateinit var data: Data
    @Inject lateinit var data2 : Data2
    @Inject lateinit var repository: HiltRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt_main)
        data.set(33333)

        println("prStr : $prStr")
        println("prData : ${data.getData()}")
//        println("prData2 : ${data2.getData2()}")
        println("prData3 : ${data2.test()}")


    }
}