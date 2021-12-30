package com.example.spaceapp

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.spaceapp.databinding.ActivityMainBinding
import com.example.spaceapp.repository.Repository

class MainActivity : AppCompatActivity() {

    // --------------------------- Navigation ---------------------- //
    private lateinit var binding: ActivityMainBinding

    // -------------------------- View Model ---------------------- //
    private lateinit var viewModel: MainViewModel

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

        // ----------------------  Retrofit call ------------------- //
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getUpcomingEvents()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("response", response.body()?.count.toString())
            }
            else{
                Log.d("Response", response.errorBody().toString())
            }
        })
    }






}