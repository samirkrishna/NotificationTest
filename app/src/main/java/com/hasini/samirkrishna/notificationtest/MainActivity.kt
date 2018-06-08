package com.hasini.samirkrishna.notificationtest

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun notify(v:View)
    {
        var nManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var nBuilder=NotificationCompat.Builder(this,"")
        nBuilder.setTicker("Welcome To JNTUHCEJ")
        nBuilder.setSmallIcon(R.drawable.ic_launcher_background)
        nBuilder.setContentTitle("Emergency Meeting")
        nBuilder.setSubText("Administrative Block")
        nBuilder.setContentText("Emergency Meeting")
        nBuilder.setAutoCancel(true)


        var i =Intent(this,MainActivity::class.java)
        var pIntent=PendingIntent.getActivity(this,0,i,0)
        nBuilder.setContentIntent(pIntent)

        nBuilder.addAction(R.drawable.notification_icon_background,"cancel",pIntent)

        nManager.notify(System.currentTimeMillis().toInt(),nBuilder.build())//to set notification to status bar
    }
    
}
