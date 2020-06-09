package com.example.contasandroid.ui.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contasandroid.ui.service.model.Conta

@Database(entities = arrayOf(Conta::class), version = 1)
abstract class ContaDatabase : RoomDatabase() {
    abstract fun contaDao(): ContaDao

    companion object {

        private lateinit var INSTANCE: ContaDatabase
        fun getDatabase(context: Context): ContaDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context, ContaDatabase::class.java, "projetoDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}