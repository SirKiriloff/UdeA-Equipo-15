package com.kirilcorp.cityview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kirilcorp.cityview.databinding.FragmentListHectorBinding


class FragmentDetailHector : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentListHectorBinding>(inflater,
            R.layout.fragment_detail_hector, container, false)

        return binding.root
    }


}