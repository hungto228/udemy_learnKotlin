package com.hungto.day1_kotlin

fun main(args: Array<String>) {
    println("enter your garage: ")
    var grade= readLine()!!.toDouble()
    if(grade>=90){
        grade+=3
        println("lever a")
    }else{
        println("lever b")
    }
    println("your enter garadde $grade")
}