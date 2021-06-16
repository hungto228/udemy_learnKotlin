package com.hungto.day1_kotlin.objectOritentedObject

class userAdmin<A>(credit: A){
    init {
        println(credit)
    }
}

fun main(args: Array<String>) {
    var admin=
        userAdmin<String>("hungto")
}