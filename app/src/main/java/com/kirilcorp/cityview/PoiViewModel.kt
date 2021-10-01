package com.kirilcorp.cityview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PoiViewModel : ViewModel() {
    private val poiClicked = MutableLiveData<PoiObject>()

    fun setPoiClicked(poi: PoiObject){
        poiClicked.value = poi
    }

    fun getPoiClicked() : LiveData<PoiObject> = poiClicked

}