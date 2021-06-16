package com.hungto.day1_kotlin.objectOritentedObject

var fulname="hung"// global var
fun display():Unit{
    println(fulname)
}
fun main(args: Array<String>) {
    var name="hung1" //local var
    println(fulname)
    println("name+"+name)
}
