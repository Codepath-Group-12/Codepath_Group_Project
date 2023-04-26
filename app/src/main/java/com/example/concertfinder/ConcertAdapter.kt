package com.example.concertfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConcertAdapter(private val concertInfoLists: MutableList<List<String>>) : RecyclerView.Adapter<ConcertAdapter.ViewHolder>() {
    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val concert_Name: TextView
        val concert_Location: TextView
        val concert_Date: TextView
        //val concert_Image: ImageView
        init {
            concert_Name = view.findViewById(R.id.concertName)
            concert_Location = view.findViewById(R.id.concertLocation)
            concert_Date = view.findViewById(R.id.concertDate)
            //concert_Image = view.findViewById(R.id.concertImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.concert_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = concertInfoLists.size

    //override fun onBindViewHolder(holder: Viewholder, position: Int){


}