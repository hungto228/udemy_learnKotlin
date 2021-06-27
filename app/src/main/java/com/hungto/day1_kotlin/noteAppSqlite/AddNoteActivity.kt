package com.hungto.day1_kotlin.noteAppSqlite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
    var listNote = ArrayList<NoteModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        listNote.add(NoteModel(1,edt_title.text.toString(),edt_title.text.toString()))

    }
}