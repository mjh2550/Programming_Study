package com.mjh.rxexam.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.mjh.rxexam.R
import java.util.concurrent.Executor

class BioActivity : AppCompatActivity() {
    private lateinit var executor : Executor
    private lateinit var bioMetricPrompt : BiometricPrompt
    private lateinit var promptInfo : BiometricPrompt.PromptInfo
    val TAG = "TEST"
    private lateinit var tv_0101 : TextView
    private lateinit var btn_0101 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio)

        initBinding()
    }

    private fun initBinding() {
        tv_0101 = findViewById(R.id.tv_0101)
        btn_0101 = findViewById(R.id.btn_0101)
        btn_0101.setOnClickListener {
            tv_0101.text="지문인식 중...."
            bioMetricPrompt.authenticate(promptInfo)
        }



        executor = ContextCompat.getMainExecutor(this@BioActivity)
        bioMetricPrompt = BiometricPrompt(this@BioActivity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext, "에러", Toast.LENGTH_SHORT).show()
                        tv_0101.text = "에러 발생!"
                    Log.d(TAG, "에러 발생!")
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(applicationContext, "성공", Toast.LENGTH_SHORT).show()
                        tv_0101.text = "지문인식에 성공하였습니다!"
                    Log.d(TAG, "지문인식에 성공하였습니다!")
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "실패", Toast.LENGTH_SHORT).show()
                        tv_0101.text = "지문인식에 실패하였습니다..."
                    Log.d(TAG, "지문인식에 실패하였습니다...")
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("지문 인증")
            .setSubtitle("기기에 등록된 지문을 이용하여 지문을 인증해주세요.")
            .setNegativeButtonText("취소")
            .build()
    }
}