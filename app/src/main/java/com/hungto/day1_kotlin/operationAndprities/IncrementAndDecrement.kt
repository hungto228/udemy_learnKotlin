package com.hungto.day1_kotlin.operationAndprities
/*
operation rule:priorites rule
1-()
2- ++,--(before var)
3-^
4-*,/
5- +,-
6-=
7- ++,-- (after var)
*/
fun main(args: Array<String>) {

    var x=11
    var y=11
    var z=--x+y  //++x=x+1
    println(z)

    var m=x++
}