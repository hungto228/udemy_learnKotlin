package com.hungto.day1_kotlin.nimbizzPhoneShake

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R

class PhoneShakeActivity : AppCompatActivity(), SensorEventListener {
    var sensor: Sensor? = null
    var sensorManager: SensorManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_shake)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    var xold = 0
    var yold = 0
    var zold = 0
    var threadShowld = 3000
    var oldItem: Long = 0
    override fun onSensorChanged(event: SensorEvent?) {
        var x = event!!.values[0]
        var y = event!!.values[1]
        var z = event!!.values[2]
        var currentTime = System.currentTimeMillis()
        if ((currentTime - oldItem) > 100) {
            var timeDiff = currentTime - oldItem
            oldItem = currentTime
            var speed = Math.abs((x + y + z - xold - yold - zold)) / timeDiff * 10000
            if (speed > threadShowld) {
                var v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                v.vibrate(500)
                Toast.makeText(applicationContext, "Shock", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
}