package com.kirilcorp.cityview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class POI_Adapter (
    private val poi_list: ArrayList<POI_object>
        ) : RecyclerView.Adapter<POI_Adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_poi_list_hector, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (poi_name, poi_description, poi_score, poi_image)= poi_list[position]
        holder.poi_name.text = poi_name
        holder.poi_description.text = poi_description
        holder.poi_score.text = poi_score
//        holder.poi_image.text = poi_image TODO
    }

    override fun getItemCount(): Int {
        return poi_list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poi_name: TextView = itemView.findViewById(R.id.poi_name)
        var poi_description: TextView = itemView.findViewById(R.id.poi_short_description)
        var poi_score: TextView = itemView.findViewById(R.id.poi_score)
//        var poi_image: todo
    }

}