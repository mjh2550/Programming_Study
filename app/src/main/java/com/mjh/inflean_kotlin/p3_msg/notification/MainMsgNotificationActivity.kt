package com.mjh.inflean_kotlin.p3_msg.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ContentView
import androidx.core.app.NotificationCompat
import com.mjh.inflean_kotlin.R
import kotlinx.android.synthetic.main.activity_main_msg_notification.*

class MainMsgNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_msg_notification)

        /**
         * 21.
         * Notification
         * 화면 가지지않는 실행단위에서 알림
         * 상단 상태창에 표시되는 알림창
         *
         * 사용자가 메시지 확인 ,제거 전까지 메시지 유지
         * 터치시 액티비티 앱실행 유도 가능
         */


       /* noti_btn.setOnClickListener {
            val builder1 = getNotificationBuilder("channerl1","첫번째 채널").apply {
                //작은아이콘(수신 시 상단 아이콘)
                setSmallIcon(android.R.drawable.ic_menu_search)
                //큰아이콘(본문 표시할 메시지 BitMap 객체
                val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
                setLargeIcon(bitmap)

                setNumber(100)
                setContentTitle("Content Title 1")
                setContentText("Content Text 1")

                //메시지 객체 생성
                val notification = build()
                //알림 메시지 관리하는 매니저 객체를 추출
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                //출력 //id값에 따라서 메시지 나타남
                manager.notify(10,notification)

            }
        }*/

        /*noti_btn2.setOnClickListener {
            val builder1 = getNotificationBuilder("channerl2","2번째 채널").apply {
                //작은아이콘(수신 시 상단 아이콘)
                setSmallIcon(android.R.drawable.ic_menu_search)
                //큰아이콘(본문 표시할 메시지 BitMap 객체
                val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
                setLargeIcon(bitmap)

                setNumber(100)
                setContentTitle("Content Title 2")
                setContentText("Content Text 2")

                //메시지 객체 생성
                val notification = build()
                //알림 메시지 관리하는 매니저 객체를 추출
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                //출력 //id값에 따라서 메시지 나타남
                manager.notify(20,notification)

            }
        }*/


        /**
         * 22.
         * Pending Intent 를통해 Notification으로 앱 실행
         *
         */

        noti_btn.setOnClickListener {
            val builder1 = getNotificationBuilder("pending","pending intent").apply {
                //작은아이콘(수신 시 상단 아이콘)
                setSmallIcon(android.R.drawable.ic_menu_search)
                //큰아이콘(본문 표시할 메시지 BitMap 객체
                val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
                setLargeIcon(bitmap)

                setNumber(100)
                setContentTitle("Noti Title 1")
                setContentText("Noti Text 1")

                //메시지터치시 사라짐
                setAutoCancel(true)

                /**
                 * 22-1.
                 * Pending setting
                 */
                //메시지 터치 시 실행할 Activity 관리할 Intent 생성
                val intent1 = Intent(this@MainMsgNotificationActivity, MainMsgPendingIntentActivity::class.java)
                intent1.putExtra("data1",10)
                intent1.putExtra("data2",20)

                val pending1 = PendingIntent.getActivity(this@MainMsgNotificationActivity,10,intent1,PendingIntent.FLAG_IMMUTABLE)
                setContentIntent(pending1)

                //메시지 객체 생성
                val notification = build()
                //알림 메시지 관리하는 매니저 객체를 추출
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                //출력 //id값에 따라서 메시지 나타남
                manager.notify(10,notification)

            }
        }

        noti_btn2.setOnClickListener {
            val builder1 = getNotificationBuilder("channerl2","2번째 채널").apply {
                //작은아이콘(수신 시 상단 아이콘)
                setSmallIcon(android.R.drawable.ic_menu_search)
                //큰아이콘(본문 표시할 메시지 BitMap 객체
                val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher)
                setLargeIcon(bitmap)

                setNumber(100)
                setContentTitle("Content Title 2")
                setContentText("Content Text 2")

                /**
                 * 22-2.
                 * Action 버튼
                 * 알림시 클릭 가능한 버튼
                 */

                val intent2 = Intent(this@MainMsgNotificationActivity,MainMsgPendingIntentActivity::class.java)
                val pending2 = PendingIntent.getActivity(this@MainMsgNotificationActivity, 10, intent2, PendingIntent.FLAG_IMMUTABLE)
                val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "ACtion 1", pending2)
                val action2 = builder2.build()
                addAction(action2)


                //메시지 객체 생성
                val notification = build()
                //알림 메시지 관리하는 매니저 객체를 추출
                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                //출력 //id값에 따라서 메시지 나타남
                manager.notify(20,notification)

            }
        }


    }

    /**
     * 21.
     * Notification Channel(android 8.0+)
     * 채널 별 관리가능 (기존에는 어플별 이였음)
     */

    private fun getNotificationBuilder(id:String , name:String) : NotificationCompat.Builder{

        //OS버전별 분기
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //알림 메시지 관리하는 객체 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //채널 객체 생성           //id : 기본키 name : 사용자에게 노출하는 메시지 이름
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH).apply {
                //LED 색상변경 여부
                enableLights(true)
                //진동 사용 여부
                enableVibration(true)
            }

            //알림 메시지 관리하는 객체에 채널 등록
            manager.createNotificationChannel(channel)

            return  NotificationCompat.Builder(this, id)

        }else{
            return  NotificationCompat.Builder(this)
        }
    }
}