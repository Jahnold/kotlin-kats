package com.jahnold.kotlinkats.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jahnold.kotlinkats.R
import com.jahnold.kotlinkats.data.entities.Cat
import com.squareup.picasso.Picasso

/**
 * Created by matthewarnold on 07/08/2017.
 */
class CatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image : ImageView = itemView.findViewById(R.id.cat_image)
    private val name : TextView = itemView.findViewById(R.id.cat_name)
    private val description : TextView = itemView.findViewById(R.id.cat_description)

    fun bind(cat : Cat) {

        Picasso.with(image.context)
                .load(cat.imageUrl)
                .into(image)

        name.text = cat.name
        description.text = cat.description
    }

}