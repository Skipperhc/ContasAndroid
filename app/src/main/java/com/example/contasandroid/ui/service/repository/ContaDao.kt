package com.example.contasandroid.ui.service.repository

import androidx.room.*
import com.example.contasandroid.ui.service.model.*

@Dao
interface  ContaDao {
    @Insert
    fun save(conta: Conta)
//
//    @Insert
//    fun save(operacao: Operacao) : Int

    @Query("SELECT * FROM conta WHERE contaId = :id")
    fun getConta(id: Int) : Conta

    @Query("SELECT * FROM conta")
    fun listContas() : List<Conta>

    @Update
    fun update(conta: Conta) : Int

//    @Update
//    fun update(operacao: Operacao) : Int

    @Delete
    fun delete(conta: Conta)

//    @Delete
//    fun delete(operacao: Operacao)
}