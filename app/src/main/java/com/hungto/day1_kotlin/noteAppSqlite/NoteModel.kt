package com.hungto.day1_kotlin.noteAppSqlite

class NoteModel {
    var id: Int? = null
    var tiltle: String? = null
    var desc: String? = null

    constructor(id: Int, title: String, desc: String) {
        this.id = id
        this.tiltle = title
        this.desc=desc
    }

}