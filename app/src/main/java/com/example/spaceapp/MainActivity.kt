package com.example.spaceapp

import android.os.Bundle
import android.widget.Toast
import android.view.Menu
import android.widget.Switch
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.spaceapp.apiFetch.ApiClient
import com.example.spaceapp.databinding.ActivityMainBinding

import kotlinx.coroutines.*

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

    @Override //switch between light mode and dark mode
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //retrieve the switch element
        menuInflater.inflate(R.menu.action_menu, menu)
        val item = menu!!.findItem(R.id.switch_action_bar)
        item.setActionView(R.layout.use_switch)

        val mySwitch : Switch = item.actionView.findViewById(R.id.switch2)

        //if it is the dark mode, check the switch because otherwise when reloading the theme,
        //the switch isn't checked
        mySwitch.isChecked = delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES

        //change the theme when the switch's stat changes
        mySwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    //Dark mode;
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                    Toast.makeText(this, "Dark mode activated", Toast.LENGTH_SHORT).show();

                } else {
                    //light mode
                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                    Toast.makeText(this, "Light mode activated", Toast.LENGTH_SHORT).show();
                }
        }

        return true
    }

}

