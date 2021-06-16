package com.hungto.day1_kotlin.loopcontrol

fun main(args: Array<String>) {
    var count=1
    do {
        if(count==2){
            println("count: $count")
        }
        count++
     }while (count<=5)
    println("loop done")
}