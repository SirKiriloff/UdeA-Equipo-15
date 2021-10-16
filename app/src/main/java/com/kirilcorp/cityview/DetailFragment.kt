package com.kirilcorp.cityview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kirilcorp.cityview.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var model: SitiesViewModel
    private lateinit var titleView: TextView
    private lateinit var descriptionView: TextView
    private lateinit var temperatureView: TextView
    private lateinit var scheduleView: TextView
    private lateinit var priceView: TextView
    private lateinit var imgView: ImageView
    private lateinit var ubicationBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,
            R.layout.fragment_detail,container,false)
        descriptionView=binding.infoGeneral
        titleView=binding.titleDetail
        temperatureView=binding.temperatureDetail
        scheduleView=binding.scheduleDetail
        priceView=binding.priceDetail
        imgView=binding.placeImg
        ubicationBtn=binding.btnUbication
        ubicationBtn.setOnClickListener {
            ubicationClick(ubicationBtn.text as String)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProvider(requireActivity()).get(SitiesViewModel::class.java)
        observeLiveData()
    }

    private fun observeLiveData() {
        model.getSelected().observe(viewLifecycleOwner, { site ->
            titleView.text = site.name
            descriptionView.text = site.descriptio
            temperatureView.text = site.temperature
            scheduleView.text = site.schedule
            priceView.text = site.price
            ubicationBtn.text = site.ubication
            Picasso.get().load(site.image).into(imgView)
        })
    }

    private fun ubicationClick(ubi: String){
        val gmmIntentUri = Uri.parse("geo:$ubi")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}
