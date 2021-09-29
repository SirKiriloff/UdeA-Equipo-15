package com.kirilcorp.cityview

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.kirilcorp.cityview.databinding.FragmentDetailHectorBinding





class FragmentDetailHector : Fragment() {

    private var poi_name : String? = null
    private var poi_description: String? = null
    private var poi_score: String? = null
    private var poi_image : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            poi_name = it.getString("poi_name", "")
            poi_description = it.getString("poi_description", "")
            poi_score = it.getString("poi_score", "")
            poi_image = it.getString("poi_image", "")
        }
        Log.d(TAG, "onCreate")
//        newInstance(poi_name, poi_description, poi_score, poi_image)
//          Esto no debe ir aqui, sino en el onClick, y recibiendo el poi
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailHectorBinding>(inflater,
            R.layout.fragment_detail_hector, container, false)

        setHasOptionsMenu(true)
        binding.infoGeneral.text = poi_description
        binding.title.text = poi_name
        binding.placeData.text = poi_score

        return binding.root
    }



    companion object{
        var TAG : String = "Fragment Detail Debug"
    }

    fun newInstance(poiName: String?, poiDescription:String?, poiScore : String?, poiImage: String?) =
        FragmentDetailHector().apply {
            arguments = Bundle().apply {
                putString("poi_name",  poiName)
                putString("poi_description", poiDescription)
                putString("poi_score", poiScore)
                putString("poi_image", poiImage)
            }
        }


}