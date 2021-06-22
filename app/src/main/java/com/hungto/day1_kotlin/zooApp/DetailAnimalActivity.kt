package com.hungto.day1_kotlin.zooApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_detail_animal.*

class DetailAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_animal)
        val bundle: Bundle = intent.extras!!
        var title = bundle.getString("title")
        var desc = bundle.getString("desc")
        val image = bundle.getInt("image")
        tv_title.text = title
        tv_desc.text = desc
        Glide.with(this).load(image).into(image_animal)
        // image_animal.setImageResource(image)

    }
}


