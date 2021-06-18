package com.hungto.day1_kotlin.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

    }

    //number click
    fun onclick(view: View) {
        if (isnewOp) {
            edt_showname.setText("")
        }
        isnewOp = false
        val selected: Button = view as Button
        var number: String = edt_showname.text.toString()
        when (selected.id) {
            btn_0.id -> number += "0"
            btn_1.id -> number += "1"
            btn_2.id -> number += "2"
            btn_3.id -> number += "3"
            btn_4.id -> number += "4"
            btn_5.id -> number += "5"
            btn_6.id -> number += "6"
            btn_7.id -> number += "7"
            btn_8.id -> number += "8"
            btn_9.id -> number += "9"

            btn_dot.id -> number += "."
            btn_plusmin.id -> {
                number = "-" + number
            }

        }
        edt_showname.setText(number)

    }

    //marth click
    var op = "*"
    var oldNumber = ""
    var isnewOp = true
    fun mathClick(view: View) {
        val selected = view as Button
        when (selected.id) {
            btn_mul.id -> op = "*"
            btn_div.id -> op = "/"
            btn_sum.id -> op = "+"
            btn_sub.id -> op = "-"
        }
        oldNumber = edt_showname.text.toString()
        isnewOp = true
    }

    fun percent(view: View) {
        val number: Double = edt_showname.text.toString().toDouble() / 100
        edt_showname.setText(number.toString())
        isnewOp = true
    }

    fun clean(view: View) {
        edt_showname.setText("0")
        isnewOp = true
    }

    fun resultclick(view: View) {
        val newNumber = edt_showname.text.toString()
        var finalNumber: Double? = null
        when (op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            else-> {
                edt_showname.setText("")
            }
        }
        edt_showname.setText(finalNumber.toString())
        isnewOp = true
    }

}