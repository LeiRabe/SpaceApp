package com.example.spaceapp

import android.app.ActionBar
import android.os.Bundle
import android.widget.Toast
import android.text.Layout
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.spaceapp.apiFetch.ApiClient
import com.example.spaceapp.databinding.ActivityMainBinding

import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    // --------------------------- Navigation ---------------------- //
    private lateinit var binding: ActivityMainBinding

    // --------------------------- onCreate ---------------------- //

import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_iss,
                R.id.navigation_favorite,
                R.id.navigation_quiz
            )
        )
        setupActionBarWithNavController(navHostFragment!!.findNavController(), appBarConfiguration)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_iss, R.id.navigation_favorite, R.id.navigation_quiz))

        navView.setupWithNavController(navHostFragment!!.findNavController())


        navView.itemIconSize = 130;
    }

    // ----------------------  Retrofit call ------------------- //

    //Coroutine
    private fun executeCall() {

        GlobalScope.launch(Dispatchers.Main) {
            try {

                val response = ApiClient.apiService.getUpcomingEvent();

                if (response.isSuccessful && response.body() != null) {
                    val content = response.body()
                    Toast.makeText(
                        this@MainActivity,
                        "Body: ${response.body()}",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${response.message()}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}