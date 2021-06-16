package com.hungto.day1_kotlin.collectionAndString

fun main(args: Array<String>) {
    var title = " Whelo Chao hung"
    println(title)
    println("title:$title")
    println("title:" + title)
    var name = "hunto " + "chao"
    println("name:$name")
    println("sercond char:" + title[3])
    println("title:" + title.toLowerCase())
    println("title:" + title.toUpperCase())
    println("title:" + title.split("C"))
    println("title:" + title.trim())
}