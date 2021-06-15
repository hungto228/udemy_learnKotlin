package com.hungto.day1_kotlin

fun main(args: Array<String>) {
    var setemenet = setOf(1, 2, 3, 11, 44, 55, 55)

//    setemenet.add(77)  not working in set ogg
    for (element in setemenet) {
        println(element)
    }
    var setemenetM = mutableSetOf(1, 2, 3, 11, 44, 55, 55)
    setemenetM.add(77)
    for (element in setemenetM) {
        println(element)
    }
}