package com.hungto.day1_kotlin.collectionAndString

fun main(args: Array<String>) {
    var map=HashMap<Int,String>()
    map.put(1,"hung")
    map.put(2,"hung2")
    map.put(3,"hung3")
   // print(map.get(3))
    map.put(3,"hungdz")
    for (k in map.keys){
        println(map.get(k))
    }
}