package com.example.contasandroid.ui.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

class Operacao(val idOrigem: Int, val valor: Double) {

    var id: Int = 0
    var idDestino: Int = 0

    val date: Date = Calendar.getInstance().time

    constructor(idOrigem: Int, valor: Double, idDestino: Int) : this(idOrigem, valor) {
        this.idDestino = idDestino
    }

//    override fun toString(): String = when (this.idDestino) {
//        0 -> "Pagou um boleto no valor de ${this.valor}"
//        else -> "Transferiu ${this.valor} para a conta ${this.idDestino}"
//    }
}