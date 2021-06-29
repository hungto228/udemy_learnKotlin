package com.hungto.day1_kotlin.alarm

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.hungto.day1_kotlin.R

class PopTime : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var myview = inflater.inflate(R.layout.pop_time, container, false)
        var mDoneBtn = myview.findViewById<Button>(R.id.btn_done)
        var timepicker = myview.findViewById<TimePicker>(R.id.time_picker)
        mDoneBtn.setOnClickListener {
            val mainActivity = activity as AlarmActivity

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mainActivity.SetTime(timepicker.hour, timepicker.minute)
            } else {
                mainActivity.SetTime(timepicker.currentHour, timepicker.currentMinute)
            }
            this.dismiss()
        }
        return myview
    }
}