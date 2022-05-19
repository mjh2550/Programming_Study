package com.mjh.inflean_kotlin.p3_msg

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_msg_toast_snackbar.*

class MainMsgToastSnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_msg_toast_snackbar)

        /**
         * 16.
         *
         *  toast
         * -일정시간 지나면 자동으로 사라지는 메시지
         * -OS요청하고 OS가 띄워줌
         * -모든 구성요소가 요청할 수 있다.
         *
         * dialog : Activity 위에 나타나는 메시지
         * Notification : 알림창에 표시되는 메시지
         * 메시지 일부는 Activity ,Service 와 관련이 있다.
         *
         * 17.
         *
         *  snackbar
         * -toast의 업그레이드 버전
         * -activity위에 표시된다.
         * -기본Toast메시지 외의 customising 부분은 snackbar를 사용하도록 권장한다.
         */

        msg_button.setOnClickListener {
            //Indefineite 는 액션 누를때까지 기다림
                Snackbar.make(it,"snack bar",Snackbar.LENGTH_INDEFINITE).apply{
                setTextColor(Color.RED)
                setBackgroundTint(Color.BLUE)
                animationMode = Snackbar.ANIMATION_MODE_FADE

                //callback setting
                val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>(){
                    override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                        super.onDismissed(transientBottomBar, event)
                    }

                    override fun onShown(transientBottomBar: Snackbar?) {
                        super.onShown(transientBottomBar)
                    }
                }

                //우측 액션버튼
                setAction("Action"){
                    msg_textView.text = "Action Click"
                }
            }.show()

            /**
            * 커스텀 스낵바는 생략
             */

        }

    }
}