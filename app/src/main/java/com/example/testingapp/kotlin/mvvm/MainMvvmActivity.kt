package com.example.testingapp.kotlin.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import com.example.testingapp.R
import com.example.testingapp.databinding.ActivityMainMvvmBinding
import com.example.testingapp.kotlin.mvvm.viewmodel.ActionType
import com.example.testingapp.kotlin.mvvm.viewmodel.MainViewModel
import com.example.testingapp.kotlin.mvvm.viewmodel.MainViewModel.Companion.TAG
import java.util.logging.Logger

class MainMvvmActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_mvvm)

        //view binding
        binding = ActivityMainMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel
        //뷰모델 프로바이더를 이용해 뷰모델 데이터 가져오기
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.currentValue.observe(this, Observer {
            Log.d(TAG,"MainActivity - mainViewModel - CurrentValue 라이브 데이터 값 변경 : $it")
            binding.tvView.text = it.toString()
        })


        binding.btnMinus.setOnClickListener(this)
        binding.btnPlus.setOnClickListener(this)
        Log.d("Test","mvvmTest")




    }

    override fun onClick(v: View?) {

        var _userInput: String  = binding.edtTpyText.text.toString()

        var result = chkIsNum(_userInput)

        if(!result){
            Toast.makeText(this,"숫자만 입력해 주세요",Toast.LENGTH_SHORT).show()
            Log.d(TAG,"숫자만")
            return
        }

        val userInput = _userInput.toLong()

        when(v?.id){
            R.id.btn_plus -> viewModel.updateValue(ActionType.PLUS, userInput)
            R.id.btn_minus ->viewModel.updateValue(ActionType.MINUS, userInput)
        }

    }

    private fun chkIsNum(_userInput: String): Boolean {
        var temp: Char
        var result = true

        for (i in _userInput.indices) {
            temp = _userInput.elementAt(i)
            if (!temp.isDigit()) {
                result = false
            }
        }
        return result
    }
}