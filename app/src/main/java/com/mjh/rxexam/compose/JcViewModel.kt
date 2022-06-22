package com.mjh.rxexam.compose

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class JcViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    @Named("testFun") val testFunc : String
)  :ViewModel(){

    fun printTest(){
        Log.d("test :",testFunc)
    }

}