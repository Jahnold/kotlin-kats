package com.jahnold.kotlinkats.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jahnold.kotlinkats.R
import com.jahnold.kotlinkats.data.entities.Cat

/**
 * Created by matthewarnold on 07/08/2017.
 */
class CatsAdapter(private val cats: MutableList<Cat>) : RecyclerView.Adapter<CatsViewHolder>() {


    override fun onBindViewHolder(holder: CatsViewHolder?, position: Int) {

        val cat = cats[position]
        holder?.bind(cat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder_cat, parent, false)

        return CatsViewHolder(view)
    }

    override fun getItemCount(): Int {

        return cats.size
    }

    fun setCats(cats : List<Cat>) {

        this.cats.clear()
        this.cats.addAll(cats)

        notifyDataSetChanged();
    }
}