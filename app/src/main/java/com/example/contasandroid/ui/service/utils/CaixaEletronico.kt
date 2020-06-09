package com.example.contasandroid.ui.service.utils

import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.Operacao

class CaixaEletronico private constructor() {
    companion object {
        fun pagar(contaOrigem: Conta, valor: Double) {
            val op = Operacao(idOrigem = contaOrigem.contaId, valor = valor)
            contaOrigem.saldo -= valor
//            contaOrigem.listaOperacoes.add(op)
        }

        fun pagar(contaOrigem: Conta, contaDestino: Conta, valor: Double) {
            val op = Operacao(idOrigem = contaOrigem.contaId,valor = valor, idDestino = contaDestino.contaId)
            contaOrigem.saldo -= valor
            contaDestino.saldo += valor
//            contaOrigem.listaOperacoes.add(op)
//            contaDestino.listaOperacoes.add(op)
        }
    }
}