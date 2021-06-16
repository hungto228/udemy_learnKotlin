package com.hungto.day1_kotlin.objectOritentedObject

open class operations() {
    public var processName: String? = "dadad"
    fun sum(n1: Int, n2: Int): Int {
        return n1 + n2
    }

    fun div(n1: Int, n2: Int): Int {
        return n1 / n2
    }
}

class MultiOperation() : operations() {


    fun sub(n1: Int, n2: Int): Int {
        return n1 - n2
    }

    fun muli(n1: Int, n2: Int): Int {
        return n1 * n2
    }

    fun GetName():Unit {
        super.processName
    }

}


fun main(args: Array<String>) {
    var op = operations()
    var sum = op.sum(10, 15)
    println("sum" + sum)
    var div = op.div(12, 11)
    println("div" + div)
    println("onprogress name" + op.processName)
    //sercond
    var op2 = MultiOperation()
    var sum2 = op2.sum(20, 15)
    println("sum2" + sum2)
}
