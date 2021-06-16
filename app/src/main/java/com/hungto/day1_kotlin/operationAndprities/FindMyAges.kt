package com.hungto.day1_kotlin.operationAndprities

import java.util.*

fun main(args: Array<String>) {
    //input
    print("enter your")
    var  dob:Int= readLine()!!.toInt()

    //process
    var year=Calendar.getInstance().get(Calendar.YEAR)
    var age =year-dob
    //out put
    println("your age is $age year")
}