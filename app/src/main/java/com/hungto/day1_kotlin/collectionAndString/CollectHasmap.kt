package com.hungto.day1_kotlin.collectionAndString

fun main(args: Array<String>) {
    var map= hashMapOf(1 to "hung",2 to "hung2")
    map.put(3,"hung3")
//    for (k in map.keys){
//        println("index"+map.get(k))
//    }
    println(map[3])
    println(map.get(3))

    var ar= arrayOf(1,10,22,11)
    println(ar[0])
    val l= mutableListOf(11,22,33,22)
    l[0]=22
    for (item in l){
        println(item)
    }
}