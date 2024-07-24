package com.ch.al_mirats

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.appDataStore by preferencesDataStore(
    //TODO : Change with your own preference app name
    name = "DataStoreExample"
)