package com.example.contasandroid.ui.service.model

import androidx.room.Entity

@Entity(primaryKeys = ["contaId","operacaoId"])
data class ContaOperacaoRef(
    val contaId: Int,
    val operacaoId: Int
)