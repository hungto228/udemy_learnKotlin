package com.hungto.day1_kotlin.StorangeFile

import java.io.FileReader
import java.io.FileWriter

fun main(args: Array<String>) {
    println("1-read\n 2-write\n")
    var op: Int = readLine()!!.toInt()
    when (op) {
        1 -> readTofile()
        2 -> {
            print("write to file text")
            var str: String = readLine().toString()
            writeTofile(str)
            readTofile()
        }

    }

}

fun writeTofile(str: String) {
    try {


        var fo = FileWriter("test.txt", true)
        fo.write(str + "\n")
        fo.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun readTofile() {
    try {
        var fin = FileReader("test.txt")
        var c: Int?
        do {
            c = fin.read()
            print(c.toChar())
        } while (c != -1)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}