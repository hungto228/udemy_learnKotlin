package com.hungto.day1_kotlin

fun main(args: Array<String>) {
    var n1=10
    var n2=20
    var  max=if(n1>n2)n1 else n2
    print("Max: $max")
    //when
    var age=31
    var isYoung=when(age){
        30->true
        else->false
    }
    print("isyoung: $isYoung")
}