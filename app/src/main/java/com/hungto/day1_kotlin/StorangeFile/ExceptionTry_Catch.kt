package com.hungto.day1_kotlin.StorangeFile

import java.lang.Exception

fun main(args: Array<String>) {
    try {
        print("enter n2")
        var n2:Int= readLine()!!.toInt()
        var Div=100/n2
        println("div:$Div")
        println("app is done")
    }catch (ex:Exception){
        println(ex.printStackTrace())
    }

}