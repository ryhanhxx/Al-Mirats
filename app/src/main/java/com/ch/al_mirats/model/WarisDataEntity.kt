package com.ch.al_mirats.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "waris_data_table")
data class WarisDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val harta: Long,
    val hutang: Long,
    val wasiat: Long,
    val biayaPerawatanJenazah: Long,
    val jenisKelamin: String,
    val ayah: Boolean,
    val ibu: Boolean,
    val istri: Int,
    val suami: Boolean,
    val ayahnya_ayah: Boolean,
    val ibunya_ayah: Boolean,
    val saudara_seayah_seibu: Int,
    val saudari_seayah_seibu: Int,
    val ibunya_ibu: Boolean,
    val anakLaki: Int,
    val anakPerempuan: Int,
    val cucuLaki: Int,
    val cucuPerempuan: Int
)
