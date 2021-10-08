package com.kirilcorp.cityview

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.kirilcorp.cityview.databinding.FragmentListHectorBinding


class FragmentListHector : Fragment() {

    private lateinit var poiAdapter: PoiAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var model: PoiViewModel
    private lateinit var binding: FragmentListHectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentListHectorBinding>(
            inflater,
            R.layout.fragment_list_hector, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = binding.POIList
        val poiList = createMockContacts()
        setupRecyclerView(poiList)

        model = ViewModelProvider(requireActivity()).get(PoiViewModel::class.java)
        model.poisLiveData.observe(viewLifecycleOwner, Observer {
            poiAdapter.updatePoiList(it)
        })
        model.getPoiClicked().observe(viewLifecycleOwner, Observer {
        })
    }

    private fun setupRecyclerView(poiList: MutableList<PoiModel>) {

        recycler.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                DividerItemDecoration.VERTICAL
            )
        )
        poiAdapter = PoiAdapter(poiList) { poi ->
            poiOnClick(poi)
//            Log.d(TAG,"Click en el setupRecyclerView" )
        }
        recycler.adapter = poiAdapter
    }

    fun poiOnClick(poi: PoiModel) {
// Este es el que esta funcionando :D
        Log.d(TAG, "Click on Fragment poiOnClick: $poi")
        model.setPoiClicked(poi)
        view?.findNavController()?.navigate(R.id.action_fragmentListHector_to_fragmentDetailHector)
    }

    private fun createMockContacts(): ArrayList<PoiModel> {
        return arrayListOf(
            PoiModel(
                1, "Please Wait ...", "retrieving items", "",
                "", "", "", "", null
            ),
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    companion object {

        val TAG = FragmentListHector::class.java.simpleName
    }
}



