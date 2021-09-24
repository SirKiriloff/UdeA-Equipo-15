package com.kirilcorp.cityview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PoiAdapter(
    private val poiList: ArrayList<PoiObject>
) : RecyclerView.Adapter<PoiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_poi_list_hector, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (poi_name, poi_description, poi_score, poi_image) = poiList[position]
        holder.poiName.text = poi_name
        holder.poiDescription.text = poi_description
        holder.poiScore.text = poi_score
//        holder.poiImage.text = poi_image todo("Traer Imagen")
    }

    override fun getItemCount(): Int {
        return poiList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poiName: TextView = itemView.findViewById(R.id.poi_name)
        var poiDescription: TextView = itemView.findViewById(R.id.poi_short_description)
        var poiScore: TextView = itemView.findViewById(R.id.poi_score)
//        var poiImage: ImageGetter = itemView.findViewById(R.id.imageview_poi) todo("Traer Imagen")
    }

}