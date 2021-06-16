package com.hungto.day1_kotlin.collectionAndString

fun main(args: Array<String>) {
    var arrayList=ArrayList<String>()
    arrayList.add("hung")
    arrayList.add("hung1")
    arrayList.add("hung12")
    arrayList.set(0,"to vab")
    for (index in arrayList){
        println(index)
    }
println("allElenemt by index")
    for (index in 0..arrayList.size-1){
        println(arrayList.get(index))
    }
    //search in arraylist
    if(arrayList.contains("hung")){
        println("name is  found")

    }else{
        println("name is no found")
    }
}