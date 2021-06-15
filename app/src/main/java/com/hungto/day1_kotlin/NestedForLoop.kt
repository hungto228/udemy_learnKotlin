package com.hungto.day1_kotlin

fun main(args: Array<String>) {
  for (count1 in 1..5){
      println("Count:$count1")
      for (count2 in 1..7){
          println("Count2:$count2")
      }
      println("loop nested done")
  }
    println("loop done")
}