package com.example.spaceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    private var titles = arrayOf("Hello","this","is","a","test","because","we","do","not","have","data","yet","yeah")
    private var details = arrayOf(
        "The family’s excitement over going to Disneyland was crazier than she anticipated.",
        "There are over 500 starfish in the bathroom drawer.",
        "Two seats were vacant.",
        "The trick to getting kids to eat anything is to put catchup on it.",
        "It was the first time he had ever seen someone cook dinner on an elephant.",
        "He kept telling himself that one day it would all somehow make sense.",
        "The waitress was not amused when he ordered green eggs and ham.",
        "Waffles are always better without fire ants and fleas.",
        "He dreamed of leaving his law firm to open a portable dog wash.",
        "It caught him off guard that space smelled of seared steak.",
        "She did a happy dance because all of the socks from the dryer matched.",
        "This is the last random sentence I will be writing and I am going to stop mid-sent",
        "Too many prisons have become early coffins."
        )
    private var images = intArrayOf(
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche,
        R.drawable.launche
    )

    //Todo: create function that dynamically add images into array

    fun addElement(arr: IntArray, element: Int): IntArray {
        val mutableArray = arr.toMutableList()
        mutableArray.add(element)
        return mutableArray.toIntArray()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_upcoming_events, parent, false)
        return ViewHolder(v)
    }

    //populate our data to our card view
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.intemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    //identify how many items are we passing to our view holder
    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var intemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            intemTitle= itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }
}