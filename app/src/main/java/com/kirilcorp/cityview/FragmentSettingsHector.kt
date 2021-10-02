package com.kirilcorp.cityview

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class FragmentSettingsHector : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

}