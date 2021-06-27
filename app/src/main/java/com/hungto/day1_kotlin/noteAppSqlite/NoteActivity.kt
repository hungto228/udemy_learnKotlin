package com.hungto.day1_kotlin.noteAppSqlite

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {
    private var lisNotes = ArrayList<NoteModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        setSupportActionBar(toolbar)
        //add data
      lisNotes.add(NoteModel(1, "to vanhung", "afhalksfhalkdhfaldhfadhfla"))
//        lisNotes.add(NoteModel(2, "to vanhung", "afhalksfhalkdhfaldhssssssssssssssfadhfla"))
        recycleView_Note.layoutManager = LinearLayoutManager(this)
        recycleView_Note.setHasFixedSize(true)
        recycleView_Note.itemAnimator = DefaultItemAnimator()
        recycleView_Note.addItemDecoration(
            DividerItemDecoration(
                recycleView_Note.context,
                DividerItemDecoration.VERTICAL
            )
        )
      //  recycleView_Note.adapter = NoteAdapter(this,lisNotes)
       LoadNote()
    }

    private fun LoadNote() {
        var db=DatabaseHandle(this)
        val noteModelList:List<NoteModel> = db.viewDataNote()
        val noteArrayId=Array(noteModelList.size){"0"}
        val noteArrayTitle=Array(noteModelList.size){"Null"}
        val noteArrayDesc=Array(noteModelList.size){"Null"}
        var  index=0
        for (n in noteModelList){
            noteArrayId[index]=n.id.toString()
            noteArrayTitle[index]= n.tiltle.toString()
            noteArrayDesc[index]=n.desc.toString()
            index++
        }
        recycleView_Note.adapter = NoteAdapter(this, lisNotes)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_note, menu)
        val sv=menu!!.findItem(R.id.menu_search).actionView as SearchView
        val sm=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@NoteActivity, query, Toast.LENGTH_SHORT).show()
                //search db
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_addNote -> {
                val intent=Intent(this,AddNoteActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "add note", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menu_search -> {
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}