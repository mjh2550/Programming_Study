package com.mjh.rxexam.hilt

import javax.inject.Inject
import javax.inject.Named

class Data2 @Inject constructor(
    private val data3 : Data3
) {
    fun test() :String{
        return data3.test3()
    }


}