package com.hungto.day1_kotlin.objectOritentedObject

enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

fun main(args: Array<String>) {
    var userDirection =
        Direction.NORTH
    if (userDirection == Direction.NORTH) {
        println(" he wen to noth")
    } else {
        println("i do no noth")
    }
}