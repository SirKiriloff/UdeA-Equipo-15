package com.kirilcorp.cityview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kirilcorp.cityview.databinding.FragmentDetailHectorBinding


class FragmentDetailHector : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailHectorBinding>(inflater,
            R.layout.fragment_detail_hector, container, false)
        setHasOptionsMenu(true)

        return binding.root
    }


}