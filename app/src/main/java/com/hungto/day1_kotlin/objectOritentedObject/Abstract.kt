package com.hungto.day1_kotlin.objectOritentedObject

abstract class Credit() {
    fun creditID(): String {
        return "112324"
    }
    abstract fun newCredit()
}

class userInfo(): Credit(){
    fun  getInfo():String{
        return creditID()
    }

    override fun newCredit() {
        println("new card")
    }

}
fun main(args: Array<String>) {
//    var credit = Credit();
//    println(credit.creditID())
    var userInfo= userInfo()
    println(userInfo.getInfo())

}