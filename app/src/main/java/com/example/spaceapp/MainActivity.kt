package com.example.spaceapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.apiFetch.ApiClient
import com.example.spaceapp.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // --------------------------- Navigation ---------------------- //
    private lateinit var binding: ActivityMainBinding

    // --------------------------- onCreate ---------------------- //

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
        navView.setupWithNavController(navHostFragment!!.findNavController())
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