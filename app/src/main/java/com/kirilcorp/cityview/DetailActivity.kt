package com.kirilcorp.cityview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class DetailActivity : AppCompatActivity() {
    private lateinit var mSities: ArrayList<Sities>
    private lateinit var mAdapter: SitiesAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        recycler = findViewById(R.id.sities_list)
        setupRecyclerView()
        generateSities()
    }

    private fun setupRecyclerView() {
        mSities = arrayListOf()
        mAdapter = SitiesAdapter(mSities)
        recycler.adapter = mAdapter
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
            val inputStream = assets.open("mock_sities.json")
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
