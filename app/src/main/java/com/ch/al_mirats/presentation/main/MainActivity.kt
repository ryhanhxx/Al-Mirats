package com.ch.al_mirats.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.ActivityMainBinding
import com.ch.al_mirats.presentation.datastore.UserPreferenceDataSourceImpl
import com.ch.al_mirats.presentation.datastore.appDataStore
import com.ch.al_mirats.utils.GenericViewModelFactory
import com.ch.al_mirats.utils.PreferenceDataStoreHelperImpl
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        val dataStore = this.appDataStore
        val dataStoreHelper = PreferenceDataStoreHelperImpl(dataStore)
        val userPreferenceDataSource = UserPreferenceDataSourceImpl(dataStoreHelper)
        GenericViewModelFactory.create(MainViewModel(userPreferenceDataSource))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_materi, R.id.navigation_fatwa
            )
        )
        observeDarkModePref()
        navView.setupWithNavController(navController)
    }

    private fun observeDarkModePref() {
        viewModel.userDarkModeLiveData.observe(this) { isUsingDarkMode ->
            AppCompatDelegate.setDefaultNightMode(if (isUsingDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}