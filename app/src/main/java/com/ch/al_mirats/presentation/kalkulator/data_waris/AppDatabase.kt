package com.ch.al_mirats.presentation.kalkulator.data_waris

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ch.al_mirats.model.WarisDataEntity

@Database(entities = [WarisDataEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun warisDataDao(): WarisDataDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database1"
                ).addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // Migrasi dari versi 1 ke versi 2
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Menambahkan kolom 'cucuPerempuan' ke tabel yang sudah ada
                database.execSQL("ALTER TABLE waris_data_table ADD COLUMN cucuPerempuan INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE waris_data_table ADD COLUMN cucuLaki INTEGER NOT NULL DEFAULT 0")
                database.execSQL("ALTER TABLE waris_data_table\n" +
                        "ADD COLUMN ayahnya_ayah BOOLEAN NOT NULL DEFAULT false,\n" +
                        "ADD COLUMN ibunya_ayah BOOLEAN NOT NULL DEFAULT false,\n" +
                        "ADD COLUMN saudara_seayah_seibu INTEGER NOT NULL DEFAULT 0,\n" +
                        "ADD COLUMN saudari_seayah_seibu INTEGER NOT NULL DEFAULT 0,\n" +
                        "ADD COLUMN ibunya_ibu BOOLEAN NOT NULL DEFAULT false;\n")
            }
        }
    }
}
