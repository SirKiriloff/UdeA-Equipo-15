package com.kirilcorp.cityview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kirilcorp.cityview.databinding.FragmentRecyclerBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class RecyclerFragment : Fragment() {

    private lateinit var mSities: ArrayList<Sities>
    private lateinit var mAdapter: SitiesAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRecyclerBinding>(inflater,
            R.layout.fragment_recycler,container,false)
        recycler = binding.sitiesListF
        setupRecyclerView()
        generateSities()
        return binding.root
    }
    private fun setupRecyclerView() {
        mSities = arrayListOf()
        mAdapter = SitiesAdapter(mSities){ site ->
            sitiesOnClick(site)}
        recycler.adapter = mAdapter
    }

    fun sitiesOnClick(site: Sities) {
        view?.findNavController()?.navigate(R.id.action_recyclerFragment_to_detailFragment)
    }

    private fun generateSities() {
        val sitiesString = readSitiesJsonFile()
        try {
            val sitiesJson = JSONArray(sitiesString)
            for (i in 0 until sitiesJson.length()) {
                val siteJson = sitiesJson.getJSONObject(i)
                val site = Sities(
                    siteJson.getString("name"),
                    siteJson.getString("descriptio"),
                    siteJson.getString("score"),
                    siteJson.getString("image")
                )
                mSities.add(site)
            }
            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun readSitiesJsonFile(): String? {
        var sitiesString: String? = null
        try {
            val inputStream = requireActivity().assets.open("mock_sities.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            sitiesString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return sitiesString
    }
}
