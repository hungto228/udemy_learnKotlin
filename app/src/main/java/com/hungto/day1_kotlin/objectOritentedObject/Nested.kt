package com.hungto.day1_kotlin.objectOritentedObject

//netsted
//class Outer{
//    private val name:String?=null
//    class Nested{
//        fun show()
//        {
//            println("nested")
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    var outer=Outer()
//    var nested=Outer.Nested()
//    nested.show()
//}
//innner
class Outer {
    private val name: String? = null

    inner class  Nested {
        fun show() {
            println("nested")
        }
    }
}

fun main(args: Array<String>) {
    var outer = Outer()
    outer.Nested().show()
//    var nested = Nested()
//    nested.show()
}