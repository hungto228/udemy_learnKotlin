package com.hungto.day1_kotlin.zooApp

class AnimalModel {
    var title: String? = null
    var desc: String? = null
    var image: Int? = null
    var isKiller: Boolean? =null

    constructor(title: String, desc: String, image: Int,isKiller:Boolean) {
        this.title = title
        this.desc = desc
        this.image = image
        this.isKiller=isKiller
    }
}