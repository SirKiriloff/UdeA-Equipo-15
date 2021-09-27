package com.kirilcorp.cityview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.databinding.DataBindingUtil
import com.kirilcorp.cityview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        navController = this.findNavController(R.id.nav_host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

//    override fun onClickItem(poi: PoiObject) {
//        Log.d(FragmentListHector.TAG, "Click On MainActivity: $poi")
//        navController.navigate(R.id.action_fragmentListHector_to_fragmentDetailHector)
//    }
}