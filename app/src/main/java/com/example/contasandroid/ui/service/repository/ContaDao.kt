package com.example.contasandroid.ui.service.repository

import androidx.room.*
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente

@Dao
interface  ContaDao {

    @Insert
    fun save(conta: Conta) : Int

    @Update
    fun update(conta: Conta) : Int

    @Delete
    fun delete(conta: Conta)

    @Query("Select * From conta_corrente WHERE id = :id")
    fun getContaCorrente(id: Int): ContaCorrente
}