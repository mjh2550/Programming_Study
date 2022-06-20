package com.mjh.rxexam.hilt

import javax.inject.Inject

class Data  {

    var a :Int = 0

    fun set(b : Int){
        a = b
    }

    fun getData() :String{
        return "get $a"
    }

}