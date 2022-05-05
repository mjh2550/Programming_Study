package com.example.testingapp.kotlin.mvvm.viewmodel

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS, MINUS
}


class MainViewModel : ViewModel() {

    companion object{
        const val TAG : String = " TAG : "
    }

    private val _currentValue = MutableLiveData<Long>()

    // 변경되지 않는 데이터를 가져올 때 이름을 _언더스코어 없이 설정
    val currentValue : LiveData<Long>
        get() = _currentValue

    init {
        Log.d(TAG, "생성자 호출")
        _currentValue.value = 0
    }


    fun updateValue(actionType : ActionType , input : Long){
        when(actionType){
            ActionType.PLUS -> _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS -> _currentValue.value = _currentValue.value?.minus(input)
        }

    }

}