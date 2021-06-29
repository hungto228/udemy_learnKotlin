package com.hungto.day1_kotlin.alarm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        btn_setTime.setOnClickListener {
            val popTime = PopTime()
            val fm = supportFragmentManager
            popTime.show(fm, "select time")

        }
    }

    fun SetTime(Hours: Int, Minute: Int) {
        tv_showTime.text = Hours.toString() + ":" + Minute.toString()
        val savaData=SavaData(applicationContext)
        savaData.setAlarm()
        savaData.SavaData(Hours,Minute)
    }
}