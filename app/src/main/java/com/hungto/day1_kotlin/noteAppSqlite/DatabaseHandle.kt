package com.hungto.day1_kotlin.noteAppSqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandle(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null,
    DATABASE_VERSION
) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "NOTEDATABSE"
        private val DATABASE_TABLE = "NOTETABLE"
        private val KEY_ID = "ID"
        private val KEY_TITLE = "TITLE"
        private val KEY_DESC = "DESC"
        val lisNotes=ArrayList<NoteModel>()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACT_TABLE =
            ("CREATE TABLE " + DATABASE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT," + KEY_DESC + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        db!!.execSQL("DROP TABLE IF EXISTS" + DATABASE_TABLE)
        onCreate(db)
    }

    //fun insert data
    fun addDataNote(noteModel: NoteModel): Long {

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, noteModel.id)
        contentValues.put(KEY_TITLE, noteModel.tiltle)
        contentValues.put(KEY_DESC, noteModel.desc)
        //insert row
        val success = db.insert(DATABASE_NAME, null, contentValues)
        //close database
        db.close()
        return success
    }

    //read data
    fun viewDataNote(): List<NoteModel> {
        val list: ArrayList<NoteModel> = ArrayList()
        val selectQuery = "select * from $DATABASE_NAME"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id:Int
        var  title:String
        var desc:String
        if(cursor.moveToFirst()){
            do {
                id=cursor.getInt(cursor.getColumnIndex("ID"))
                title=cursor.getString(cursor.getColumnIndex("TITLE"))
                desc=cursor.getString(cursor.getColumnIndex("DESC"))
                var note=NoteModel(id=id,title =title,desc =desc)
                list.add(note)
            }while (cursor.moveToNext())
        }
        return list
    }
    //update data
    fun updateNote(noteModel: NoteModel):Int{
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(KEY_ID, noteModel.id)
        contentValues.put(KEY_TITLE, noteModel.tiltle)
        contentValues.put(KEY_DESC, noteModel.desc)
        //update row
        val success=db.update(DATABASE_NAME,contentValues,"ID="+noteModel.id,null)
        db.close()
        return success
    }
    //deteteNote
    fun deleteNote(noteModel: NoteModel):Int{
        val db=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(KEY_ID, noteModel.id)

        //delete row
        val success=db.delete(DATABASE_TABLE,"ID="+noteModel.id,null)
        db.close()
        return  success
    }

}