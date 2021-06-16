package com.hungto.day1_kotlin.objectOritentedObject

class Singleton {
    var name:String?=null
   private constructor(){
        println("intance")
    }
    companion object{
        val instances: Singleton by lazy { Singleton() }
    }
}

fun main(args: Array<String>) {
    var s1=
        Singleton.instances
    s1.name="hung"
    println(s1.name)

    var s2=
        Singleton.instances
    println(s2.name)
}