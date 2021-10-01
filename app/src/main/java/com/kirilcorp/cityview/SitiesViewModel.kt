package com.kirilcorp.cityview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SitiesViewModel : ViewModel() {

    private val selected = MutableLiveData<Sities>()

    fun getSelected() : LiveData<Sities> = selected

    fun select(site: Sities) {
        selected.value = site
    }
}