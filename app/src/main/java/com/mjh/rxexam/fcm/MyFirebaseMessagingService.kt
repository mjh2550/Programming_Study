package com.mjh.rxexam.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService() : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if(message.data.isNotEmpty())Log.d("fcm","$message")
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("fcm","$token")
    }
}