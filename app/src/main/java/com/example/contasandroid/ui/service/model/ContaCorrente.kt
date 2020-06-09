package com.example.contasandroid.ui.service.model

import androidx.room.*

data class ContaCorrenteComOperacoes(
    @Embedded val conta: ContaCorrente,
    @Relation(
        parentColumn = "contaId",
        entityColumn = "operacaoId",
        associateBy = Junction(ContaOperacaoRef::class)
    )
    val operacoes: MutableList<Operacao>
)

class ContaCorrente(saldo: Double, valorMax: Double, nomeCliente: String, nomeBanco: String)
    : Conta(nomeCliente = nomeCliente, nomeBanco = nomeBanco , saldo = saldo, valorMax = valorMax)