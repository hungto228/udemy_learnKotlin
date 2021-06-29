package com.hungto.day1_kotlin.lightSensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R

class LightSensorActivity : AppCompatActivity(), SensorEventListener {
    var sensor: Sensor? = null
    var sensorManager: SensorManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light_sensor)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    var isRunning = false
    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.values[0] > 40 && isRunning == false) {
            isRunning = true
            try {
                var mp = MediaPlayer()
                mp.setDataSource("http://server6.mp3quran.net/thubti/001.mp3")
         //       mp.setDataSource("http://server6.mp3quran.net/thubti/001.mp3")
                mp.prepare()
                mp.start()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}