package com.mjh.inflean_kotlin.p4_thread

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        /*
        val str = "Broad cast Reveiver ON"
        val t1 = Toast.makeText(context, str, Toast.LENGTH_SHORT)
        t1.show()*/

        when(intent.action){
            "android.intent.action.BOOT_COMPLETED"->{
                val t1 = Toast.makeText(context, "부팅완료",Toast.LENGTH_SHORT).show()
            }
            "android.provider.Telephony.SMS_RECEIVED"->{
                if(intent.extras != null){

                    val pduObject = intent.extras?.get("pdus") as Array<Any?>
                    if(pduObject != null){
                        for(obj in pduObject){
                            //문자메시지 양식 객체를 추출한다.
                            val format = intent.extras?.getString("format")
                            //문자메시지 객체를 생성한다.
                            val currentSMS = SmsMessage.createFromPdu(obj as ByteArray?, format)

                            val showMessage = "전화번호 ${currentSMS.displayOriginatingAddress}\n내용 : ${currentSMS.displayMessageBody}"

                            Toast.makeText(context,showMessage,Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }



    }
}