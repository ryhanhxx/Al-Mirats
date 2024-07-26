package com.ch.al_mirats.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ch.al_mirats.presentation.datastore.UserPreferenceDataSource
import kotlinx.coroutines.launch

class SettingsViewModel(private val userPreferenceDataSource: UserPreferenceDataSource) : ViewModel() {

    fun setUserDarkModePref(isUsingDarkMode: Boolean) {
        viewModelScope.launch {
            userPreferenceDataSource.setUserDarkModePref(isUsingDarkMode)
        }
    }
}