package com.hungto.day1_kotlin.zooApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_zoo.*

class ZooActivity : AppCompatActivity() {
    var listAnimalModel=ArrayList<AnimalModel>()
    var adapter:AnimalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoo)
        LoadAnimal()
        //set adapter
        adapter= AnimalAdapter(this,listAnimalModel)
        listViewZoo.adapter=adapter
    }


    private fun LoadAnimal() {
        listAnimalModel.add(AnimalModel("11111","dhahdjajfjajjfjadjajd",R.drawable.squirtle,true))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,false))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,false))
        listAnimalModel.add(AnimalModel("cho11","dhahdjajfjajjfjadjajd",R.drawable.squirtle,true))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,false))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,true))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,true))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,true))
        listAnimalModel.add(AnimalModel("cho","dhahdjajfjajjfjadjajd",R.drawable.squirtle,true))
        listAnimalModel.add(AnimalModel("11","dhahdjajfjajjfjadjajd",R.drawable.squirtle,false))

    }
}