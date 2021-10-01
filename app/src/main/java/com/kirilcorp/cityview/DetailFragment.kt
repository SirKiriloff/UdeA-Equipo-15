package com.kirilcorp.cityview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private lateinit var imgView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,
            R.layout.fragment_detail,container,false)
        descriptionView=binding.infoGeneral
        titleView=binding.titleDetail
        imgView=binding.placeImg
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
            Picasso.get().load(site.image).into(imgView)
        })
    }
}
