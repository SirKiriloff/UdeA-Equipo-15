package com.kirilcorp.cityview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kirilcorp.cityview.data.remote.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SitiesViewModel : ViewModel() {

    private val selected = MutableLiveData<Sities>()
    private var apiService = RetrofitFactory.apiService()
    private var pois = MutableLiveData<List<Sities>>()
    var poisLiveData: LiveData<List<Sities>> = pois

    init {
        getPois()
    }

    fun getPois() {
        viewModelScope.launch {
            pois.value = requestPois()
        }
    }

    private suspend fun requestPois(): List<Sities> {
        return withContext(Dispatchers.IO) {
            apiService.requestPois()
        }
    }

    fun getSelected() : LiveData<Sities> = selected

    fun select(site: Sities) {
        selected.value = site
    }
}
