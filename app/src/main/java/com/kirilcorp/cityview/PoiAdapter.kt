package com.kirilcorp.cityview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PoiAdapter(
    private val poiList: ArrayList<PoiObject>,
    private val onClick: (PoiObject) -> Unit
) : RecyclerView.Adapter<PoiAdapter.PoiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_poi_list_hector, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holderPoi: PoiViewHolder, position: Int) {
        val (poi_name, poi_description, poi_score, poi_image) = poiList[position]
        holderPoi.poiName.text = poi_name
        holderPoi.poiDescription.text = poi_description
        holderPoi.poiScore.text = poi_score
//        holder.poiImage.text = poi_image todo("Traer Imagen")
    }

    override fun getItemCount(): Int {
        return poiList.size
    }

    inner class PoiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poiName: TextView = itemView.findViewById(R.id.poi_name)
        var poiDescription: TextView = itemView.findViewById(R.id.poi_short_description)
        var poiScore: TextView = itemView.findViewById(R.id.poi_score)

        //        var poiImage: ImageGetter = itemView.findViewById(R.id.imageview_poi) todo("Traer Imagen")
        private var currentPoi: PoiObject? = null

        init {
            itemView.setOnClickListener {
                currentPoi?.let {
                    onClick(it)
                }
            }
        }
    }
}