package com.kirilcorp.cityview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class PoiListHector : AppCompatActivity() {

    private lateinit var poiList: ArrayList<PoiObject>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_list_hector)

        recycler = findViewById(R.id.POI_list)
        setupRecyclerView()
        generatePoiItems()
        poiList = generatePoiItems()
    }

    private fun setupRecyclerView() {
        poiList = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        poiAdapter = PoiAdapter(poiList)
        recycler.adapter = poiAdapter
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
                Log.d(TAG, "Generate Item: $poiItem")
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
            val inputStream = assets.open("mock_data.json")
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
        private val TAG = PoiListHector::class.java.simpleName
    }

}

