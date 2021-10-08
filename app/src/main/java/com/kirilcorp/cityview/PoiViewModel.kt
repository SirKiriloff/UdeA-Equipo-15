package com.kirilcorp.cityview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PoiViewModel : ViewModel() {

    private var apiService = PoiFactory.apiService()
    private val poiClicked = MutableLiveData<PoiModel>()
    private var poiList = MutableLiveData<List<PoiModel>>()
    var poisLiveData: LiveData<List<PoiModel>> = poiList

    init {
        getPois()
    }

    private fun getPois() {
        viewModelScope.launch {
            poiList.value = requestPois()
        }
    }

    private suspend fun requestPois(): List<PoiModel>? {
        return withContext(Dispatchers.IO) {
            apiService.requestPois()
        }
    }

    fun setPoiClicked(poi: PoiModel) {
        poiClicked.value = poi
    }

    fun getPoiClicked(): LiveData<PoiModel> = poiClicked

}