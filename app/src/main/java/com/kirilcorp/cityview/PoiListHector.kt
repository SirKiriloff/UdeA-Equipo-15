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

    private lateinit var poiList: ArrayList<POI_object>
    private lateinit var poiAdapter: POI_Adapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_list_hector)

        recycler = findViewById(R.id.POI_list)
        setupRecyclerView()
        generatePoiItems()
        poiList = generatePoiItems()
    }

    private fun setupRecyclerView(){
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        poiAdapter = POI_Adapter(poiList)
        recycler.adapter = poiAdapter
    }

    private fun generatePoiItems(): ArrayList<POI_object> {
        val poiString = readPoiItemsJson()
        try{
            val poisJson = JSONArray(poiString)
            for (i in 0 until poisJson.length()){
                val poiJson = poisJson.getJSONObject(i)
                val poiItem = POI_object(
                    poiJson.getString("name"),
                    poiJson.getString("descriptio"),
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

    private fun readPoiItemsJson(): String? {
        var poiString = String?= null
        try{
            val inputStream = assets.open("mock_data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            poiString = String(buffer)
        }catch (e: IOException) {
            e.printStackTrace()
        }
        return poiString

    }

    companion object {
        private val TAG = PoiListHector::class.java.simpleName
    }

}

