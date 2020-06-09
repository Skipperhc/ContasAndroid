package com.example.contasandroid.ui.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.contasandroid.ui.service.constants.ContaConstants

@Entity(tableName = "Conta")
open class Conta(
    @ColumnInfo(name = "saldo") var saldo: Double = 0.0,
    @ColumnInfo(name = "nome_banco") var nomeBanco: String,
    @ColumnInfo(name = "nome_cliente") var nomeCliente: String,
    @ColumnInfo(name = "valorMax") var valorMax: Double = 0.0
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo() var contaId: Int = 0
}
