package com.ch.al_mirats.presentation.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.ch.al_mirats.R
import com.ch.al_mirats.databinding.FragmentSettingsDialogBinding
import com.ch.al_mirats.presentation.datastore.UserPreferenceDataSourceImpl
import com.ch.al_mirats.presentation.datastore.appDataStore
import com.ch.al_mirats.presentation.main.MainViewModel
import com.ch.al_mirats.utils.GenericViewModelFactory
import com.ch.al_mirats.utils.PreferenceDataStoreHelperImpl
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SettingsDialogFragment : BottomSheetDialogFragment() {


    private lateinit var binding: FragmentSettingsDialogBinding

    private val viewModel: SettingsViewModel by viewModels {
        val dataStore = this.requireContext().appDataStore
        val dataStoreHelper = PreferenceDataStoreHelperImpl(dataStore)
        val userPreferenceDataSource = UserPreferenceDataSourceImpl(dataStoreHelper)
        GenericViewModelFactory.create(SettingsViewModel(userPreferenceDataSource))
    }
    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSwitchAction()
        observeDarkModePref()
    }

    private fun observeDarkModePref() {
        mainViewModel.userDarkModeLiveData.observe(this) { isUsingDarkMode ->
            binding.swDarkMode.isChecked = isUsingDarkMode
        }
    }

    private fun setSwitchAction() {
        binding.swDarkMode.setOnCheckedChangeListener { _, isUsingDarkMode ->
            viewModel.setUserDarkModePref(isUsingDarkMode)
        }
    }
}