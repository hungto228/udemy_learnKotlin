package com.hungto.day1_kotlin

fun sum(n1: Double, n2: Double): Double {
    //block
    var sum = n1 + n2
    return sum

}

fun main(args: Array<String>) {
    var r = sum(10.0, 20.0)
    println("r:$r")
    r = sum(5.0, 20.0)
    println("r:$r")
    r = sum(17.0, 20.0)
    println("r:$r")
}