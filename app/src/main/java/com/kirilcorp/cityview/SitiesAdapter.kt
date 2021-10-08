package com.kirilcorp.cityview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SitiesAdapter(
    private val mSities: MutableList<Sities>,
    private val onClick: (Sities) -> Unit
) : RecyclerView.Adapter<SitiesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sities_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, descriptio, score, image) = mSities[position]
        holder.nameLabel.text = name
        holder.descriptionLabel.text = descriptio
        holder.scoreLabel.text = score
        holder.render(image)
        holder.itemView.setOnClickListener(View.OnClickListener() {
            mSities.get(position)?.let {
                onClick(it)
            }
        })
    }

    override fun getItemCount(): Int {
        return mSities.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameLabel: TextView = itemView.findViewById(R.id.textview_name)
        var descriptionLabel: TextView = itemView.findViewById(R.id.textview_description)
        var scoreLabel: TextView = itemView.findViewById(R.id.textview_score)
        var imgUrl: ImageView = itemView.findViewById(R.id.imageview_thumb)

        fun render(sities: String){
            Picasso.get().load(sities).into(imgUrl)
        }
    }
}
