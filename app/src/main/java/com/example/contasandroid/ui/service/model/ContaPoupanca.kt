package com.example.contasandroid.ui.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conta_poupanca")
class ContaPoupanca(nomeCliente: String, nomeBanco: String, saldo: Double = 0.0)
    : Conta(nomeCliente = nomeCliente, nomeBanco = nomeBanco, saldo = saldo) {

    override fun valorMax() : Double {
        return saldo
    }
}