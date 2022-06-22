package com.mjh.rxexam.compose

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class JcViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    val testFunc : String
)  :ViewModel(){

    fun printTest(){
        Log.d("test :",testFunc)
    }

}