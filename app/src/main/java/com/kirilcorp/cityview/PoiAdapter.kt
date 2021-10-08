package com.kirilcorp.cityview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PoiAdapter(
    private var poiList: MutableList<PoiModel>,
    private val onClick: (PoiModel) -> Unit
) : RecyclerView.Adapter<PoiAdapter.PoiViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_poi_list_hector, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holderPoi: PoiViewHolder, position: Int) {

        holderPoi.bind(poiList[position])
        holderPoi.itemView.setOnClickListener(View.OnClickListener {
            poiList.get(position).let {
                onClick(it)
                Log.d(TAG, "Click en el adapter")
            }
        })
    }

    override fun getItemCount(): Int {
        return poiList.size
    }

    fun updatePoiList(pois: List<PoiModel>?) {
        this.poiList.clear()
        pois?.let { this.poiList.addAll(it) }
        notifyDataSetChanged()
    }

    inner class PoiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var poiName: TextView = itemView.findViewById(R.id.poi_name)
        var poiDescription: TextView = itemView.findViewById(R.id.poi_short_description)
        var poiScore: TextView = itemView.findViewById(R.id.poi_score)
        var poiImage: ImageView = itemView.findViewById(R.id.imageview_poi)

        private var currentPoi: PoiModel? = null

        init {
            itemView.setOnClickListener {
                currentPoi?.let {
                    onClick(it)
                }
            }
        }

        fun bind(poi: PoiModel) {
            poiName.text = poi.poiName
            poiDescription.text = poi.poiDescription
            poiScore.text = poi.poiScore

            Glide.with(itemView)
                .load(poi.poiImage)
                .fitCenter()
                .into(poiImage)
        }
    }

    companion object {
        val TAG = PoiAdapter::class.java.simpleName
    }
}


