package com.hungto.day1_kotlin.objectOritentedObject

interface op{
    fun sum(n1:Int,n2:Int)
    fun div(n1:Int,n2:Int)
}
class user: op {
    override fun sum(n1: Int, n2: Int) {
        println("sum"+n1+n2)
    }

    override fun div(n1: Int, n2: Int) {
        println("sum"+n1/n2)
    }

}
class  Admin: op {
    override fun sum(n1: Int, n2: Int) {
        println("sum"+n1+n2)
    }

    override fun div(n1: Int, n2: Int) {
        println("sum"+n1/n2)
    }

}


fun main(args: Array<String>) {
    var adminop= Admin()
    adminop.sum(1,2)
}