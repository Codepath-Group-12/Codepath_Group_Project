package com.example.concertfinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ConcertAdapter(private val concertInfoLists: List<ConcertData>) : RecyclerView.Adapter<ConcertAdapter.ViewHolder>() {
    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val concert_Name: TextView
        val concert_Location: TextView
        val concert_Date: TextView
        val concert_Image: ImageView

        init {
            concert_Name = view.findViewById(R.id.concertName)
            concert_Location = view.findViewById(R.id.concertLocation)
            concert_Date = view.findViewById(R.id.concertDate)
            concert_Image = view.findViewById(R.id.concertImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.concert_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val concert: ConcertData = concertInfoLists[position]

        holder.concert_Name.text = concert.concertName
        holder.concert_Location.text = concert.concertLocation
        holder.concert_Date.text = concert.concertDate
        Glide.with(holder.itemView)
            .load(concert.concertImage)
            .centerCrop()
            .into(holder.concert_Image)

    }


    override fun getItemCount() = concertInfoLists.size




}