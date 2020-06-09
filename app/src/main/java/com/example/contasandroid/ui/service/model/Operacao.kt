package com.example.contasandroid.ui.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "operacoes")
class Operacao(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val operacaoId: Int = 0,
               @ColumnInfo(name = "valor") val valor: Double = 0.0,
               @ColumnInfo(name = "origem") var idOrigem: Int = 0,
               @ColumnInfo(name = "destino") var idDestino: Int = 0
)