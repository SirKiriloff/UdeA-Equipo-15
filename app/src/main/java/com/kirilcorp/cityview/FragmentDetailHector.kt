package com.kirilcorp.cityview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kirilcorp.cityview.databinding.FragmentDetailHectorBinding


class FragmentDetailHector : Fragment() {

    private lateinit var model: PoiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailHectorBinding>(
            inflater,
            R.layout.fragment_detail_hector, container, false
        )
        model = ViewModelProvider(requireActivity()).get(PoiViewModel::class.java)
        model.getPoiClicked().observe(viewLifecycleOwner, Observer {
            binding.infoGeneral.text = it.poiInfo
            binding.title.text = it.poiName
            binding.scoreData?.text = it.poiScore
            binding.temperatureData?.text = it.poiTemperature
            binding.locationData?.text = it.poiLocation.toString()
            binding.populationData?.text = it.poiPopulation
            Glide.with(this)
                .load(it.poiImage)
                .fitCenter()
                .into(binding.placeImg);
        })
        return binding.root
    }

    companion object {
        var TAG: String = "Fragment Detail Debug"
    }

}