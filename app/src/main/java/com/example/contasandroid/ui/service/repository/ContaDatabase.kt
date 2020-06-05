package com.example.contasandroid.ui.service.repository

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ContaDatabase : RoomDatabase() {

    companion object {

        private lateinit var INSTANCE: ContaDatabase
        fun getDatabase(context: Context): ContaDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context, ContaDatabase::class.java, "projetoDB")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE
        }
    }
}