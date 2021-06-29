package com.hungto.day1_kotlin.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action.equals("com.test.alarmmanege")) {
            var b = intent.extras
            Toast.makeText(context, b!!.getString("message"), Toast.LENGTH_SHORT).show()
            val notification = Notification()
            notification.Notify(context!!, b.getString("message")!!,10)
        } else if (intent!!.action.equals("android.intent.action.BOOT_COMPLETED")) {
            val savaData = SavaData(context!!)
            savaData.setAlarm()

        }
    }

}