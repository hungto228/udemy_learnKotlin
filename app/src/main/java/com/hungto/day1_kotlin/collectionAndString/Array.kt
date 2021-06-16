package com.hungto.day1_kotlin.collectionAndString

fun main(args: Array<String>) {
    var arrayInt = Array<Int>(5) { 0 }
    arrayInt[3] = 55
    println("array [3]= " + arrayInt[3])

    println("al element")
    for (element in arrayInt) {
        println(element)
    }
    println("al element index")
    for (index in 0..4) {
        println(arrayInt[index])
    }
    var arrayStr=Array<String>(4){""}
    for (index in 0..3){
        print("array [$index]=")
        arrayStr[index]= readLine()!!
    }
    for (index in 0..3){
        print("arrayStr[$index]="+arrayStr[index])
    }
}