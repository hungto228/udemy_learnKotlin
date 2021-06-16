package com.hungto.day1_kotlin.loopcontrol

fun main() {

//    for (count in 1..10) {
//        if (count == 4) {
//            break
//        }
//        println("Coun1t:$count ")
//    }
  loop@ for (count in 1..10) {
        for (count2 in 1..5) {
            println("Coun1t:$count ")
            if (count2 == 2) {
                break@loop
            }
        }
    }
}