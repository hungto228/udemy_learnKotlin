package com.hungto.day1_kotlin

fun show(name: String): Unit {
    print("Name" + name)
}

fun show(numberI: Int):Unit {
    print("numberI" + numberI)
}

fun show(numberD: Double): Unit {
    print("numberD:" + numberD)
}

fun main(args: Array<String>) {
show("hung1")
    show(100)
    show(10.5)
}