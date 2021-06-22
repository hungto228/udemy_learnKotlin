package com.hungto.day1_kotlin.zooApp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.animal_item.view.*

class AnimalAdapter : BaseAdapter {
    val zooActivity=ZooActivity()
    var listAnimalModel = ArrayList<AnimalModel>()
    var context: Context? = null

    constructor(context: Context, listAnimalModel: ArrayList<AnimalModel>) : super() {
        this.listAnimalModel = listAnimalModel
        this.context = context
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val animal = listAnimalModel[position]
        if (animal.isKiller == true) {
            var layoutInflater = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.animal_item_killer, parent, false)
            layoutInflater.tv_title.text = animal.title
            layoutInflater.tv_desc.text = animal.desc
            //    layoutInflater.image_animal.setImageResource(animal.image!!)
            Glide.with(this.context!!).load(animal.image).into(layoutInflater.image_animal)
            layoutInflater.setOnClickListener {
                val intent = Intent(context, DetailAnimalActivity::class.java)
                intent.putExtra("title", animal.title)
                intent.putExtra("desc", animal.desc)
                intent.putExtra("image", animal.image)
                context!!.startActivity(intent)

            }



            return layoutInflater

        } else {
            var layoutInflater = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.animal_item, parent, false)
            layoutInflater.tv_title.text = animal.title
            layoutInflater.tv_desc.text = animal.desc
            //    layoutInflater.image_animal.setImageResource(animal.image!!)
            Glide.with(this.context!!).load(animal.image).into(layoutInflater.image_animal)
            layoutInflater.setOnClickListener {
//                val intent = Intent(context, DetailAnimalActivity::class.java)
//                intent.putExtra("title", animal.title)
//                intent.putExtra("desc", animal.desc)
//                intent.putExtra("image", animal.image)
//                context!!.startActivity(intent)
                add(position)

            }

            return layoutInflater
        }

    }
    fun delete(index:Int){
        listAnimalModel.removeAt(index)
        notifyDataSetChanged()
    }
    fun add(index:Int){
        listAnimalModel.add(index,listAnimalModel[index])
        notifyDataSetChanged()
    }
    override fun getItem(position: Int): Any {
        return listAnimalModel[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listAnimalModel.size
    }


}