package com.ch.al_mirats.presentation.kalkulator.data_waris

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WarisDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(warisData: WarisDataEntity)

    @Query("SELECT * FROM waris_data_table")
    fun getAllWarisData(): List<WarisDataEntity>

    @Query("SELECT COUNT(*) FROM waris_data_table")
    fun isDataExist(): Int
}

