package com.kirilcorp.cityview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kirilcorp.cityview.databinding.FragmentRecyclerBinding
import androidx.lifecycle.Observer

class RecyclerFragment : Fragment() {

    private lateinit var mAdapter: SitiesAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var model: SitiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRecyclerBinding>(inflater,
            R.layout.fragment_recycler,container,false)
        model = ViewModelProvider(requireActivity()).get(SitiesViewModel::class.java)
        recycler = binding.sitiesListF
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.poisLiveData.observe(viewLifecycleOwner, Observer {
            setupRecyclerView(it as MutableList<Sities>)
        })
    }

    private fun setupRecyclerView(poisList: MutableList<Sities>) {
        mAdapter = SitiesAdapter(poisList){ site ->
            sitiesOnClick(site)}
        recycler.adapter = mAdapter
    }

    fun sitiesOnClick(site: Sities) {
        model.select(site)
        findNavController()?.navigate(R.id.action_recyclerFragment_to_detailFragment)
    }
}
