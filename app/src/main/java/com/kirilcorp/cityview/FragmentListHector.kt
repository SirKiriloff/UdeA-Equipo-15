package com.kirilcorp.cityview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.kirilcorp.cityview.databinding.FragmentListHectorBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class FragmentListHector : Fragment() {

    private lateinit var poiList: ArrayList<PoiObject>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentListHectorBinding>(inflater,
            R.layout.fragment_list_hector, container, false)

        recycler = binding.POIList
        setupRecyclerView()
        poiList = generatePoiItems()


        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.option_menu, menu);
//
//        super.onCreateOptionsMenu(menu, inflater)
//    }

    private fun setupRecyclerView() {
        poiList = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                requireActivity(),
                DividerItemDecoration.VERTICAL
            )
        )
        poiAdapter = PoiAdapter(poiList) { poi ->
            poiOnClick(poi)}
        recycler.adapter = poiAdapter
    }

    fun poiOnClick(poi: PoiObject) {
// Este es el que esta funcionando :D
        Log.d(TAG, "Click on Fragment poiOnClick: $poi")

        view?.findNavController()?.navigate(R.id.action_fragmentListHector_to_fragmentDetailHector)
    }

    private fun generatePoiItems(): ArrayList<PoiObject> {
        val poiString = readPointsJsonFile()
        try {
            val poisJson = JSONArray(poiString)
            for (i in 0 until poisJson.length()) {
                val poiJson = poisJson.getJSONObject(i)
                val poiItem = PoiObject(
                    poiJson.getString("name"),
                    poiJson.getString("description"),
                    poiJson.getString("score"),
                    poiJson.getString("image")
                )
                Log.d(PoiListHector.TAG, "Generate Item: $poiItem")
                poiList.add(poiItem)
            }
            poiAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return poiList
    }

    private fun readPointsJsonFile(): String? {
        var pointsString: String? = null
        try {
            val inputStream = requireActivity().assets.open("mock_data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            pointsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return pointsString
    }

    companion object {

        val TAG = FragmentListHector::class.java.simpleName

//        fun newInstance(param1: String, param2: String) =
//                FragmentListHector().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
//                }
    }
}



