package com.hungto.day1_kotlin.noteAppSqlite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hungto.day1_kotlin.R

class NoteAdapter(
    private val context: Context,
    private val listNote: ArrayList<NoteModel>
) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    // private var listNote = ArrayList<NoteModel>()


//    constructor(listNote: ArrayList<NoteModel>) : super() {
//        this.listNote = listNote
//    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = itemView.findViewById(R.id.tv_title)
        var desc: TextView = itemView.findViewById(R.id.tv_desc)
        var imageDelete: ImageView = itemView.findViewById(R.id.image_delete)
        var imageEdit: ImageView = itemView.findViewById(R.id.image_edit)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            return NoteViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
            )
        )
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        if (holder != null) {
            holder.title.text = listNote[position].tiltle
            holder.desc.text = listNote[position].desc
            holder.imageDelete.setOnClickListener {
                Toast.makeText(context, "clcik", Toast.LENGTH_SHORT).show()
            }
            holder.imageEdit.setOnClickListener {
                Toast.makeText(context, "clcik", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

