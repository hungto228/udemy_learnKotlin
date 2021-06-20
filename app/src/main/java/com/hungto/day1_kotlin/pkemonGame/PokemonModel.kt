package com.hungto.day1_kotlin.pkemonGame

import android.location.Location

class PokemonModel {
    var name:String?=null
    var desc:String?=null
    var image:Int?=null
    var power:Double?=null
    var location:Location?=null
    var isCatch:Boolean?=null

    constructor(image:Int,name:String,desc:String,power:Double,lat:Double,log:Double){
        this.name=name
        this.desc=desc
        this.power=power
        this.location!!.latitude=lat
        this.location!!.longitude=log
        this.isCatch=false
    }
}