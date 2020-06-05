package com.example.contasandroid.ui.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.contasandroid.ui.service.constants.ContaConstants

abstract class Conta() {

    lateinit var nomeCliente: String
    lateinit var nomeBanco: String
    var saldo: Double = 0.0
    var id: Int = 0
        private set

    var listaOperacoes = arrayListOf<Operacao>()

    constructor(nomeCliente: String, nomeBanco: String, saldo: Double) : this(){
        this.nomeBanco = nomeBanco
        this.nomeCliente = nomeCliente
        this.saldo = saldo
    }
    init {
        id = ContaConstants.CONTA.IDCONTA
        ContaConstants.CONTA.IDCONTA++
    }
    abstract fun valorMax(): Double
}
