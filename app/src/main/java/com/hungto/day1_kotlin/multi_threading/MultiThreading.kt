package com.hungto.day1_kotlin.multi_threading

fun main(args: Array<String>) {
    var t1 = thread("thread1")
    t1.start()
    var t2 = thread("thread2")
    t2.start()
    println("thread is  run")
}

class thread : Thread {
    var ThreaName: String = ""

    constructor(ThreaName: String) : super() {
        this.ThreaName = ThreaName
        println(this.ThreaName+"is stated")
    }


    override fun run() {
        //write thread
        var count = 0
        while (count < 10) {
            println(this.ThreaName + "count:$count")
            count++
            try {
                Thread.sleep(1000)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}