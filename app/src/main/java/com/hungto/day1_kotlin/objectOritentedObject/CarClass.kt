package com.hungto.day1_kotlin.objectOritentedObject


class Car(
    type: String,
    model: Int,
    price: Double,
    miliesDrive: Double,
    owner: String
) {
    var Owner: String? = null
    var Price: Double? = null
    var MilesDriver: Double? = null
    var Type: String? = null
    var Model: Int? = null

    init {
        println("type:$type")
        println("model:$model")
        println("price:$price")
        println("miliesDrive:$miliesDrive")
        println("owner:$owner")
        this.Owner=owner
        this.Price=price
        this.MilesDriver=miliesDrive
        this.Model=model
        this.Type=type
    }
    fun GetPrice():Double?{
        return this.Price!!-(this.MilesDriver!!.toDouble()*10)
    }
    fun GetOwner():String?{
        return this.Owner
    }

}

fun main(args: Array<String>) {
    var newCar = Car(
        "den",
        2021,
        100000.0,
        50.0,
        "hung"
    )
    println("get owrner"+newCar.GetOwner())
    println("get price"+newCar.GetPrice())
}