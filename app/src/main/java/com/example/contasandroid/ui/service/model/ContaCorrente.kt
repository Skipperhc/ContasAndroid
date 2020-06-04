package com.example.contasandroid.ui.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class ContaCorrente (limiteConta: Double, nomeCliente: String, nomeBanco: String, saldo: Double)
    : Conta(nomeCliente = nomeCliente, saldo = saldo, nomeBanco = nomeBanco) {

    var limite: Double = 0.0

    init {
        this.limite = limiteConta
    }

    override fun valorMax(): Double {
        return saldo + limite
    }
}