package com.example.contasandroid.ui.service.utils

import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.Operacao
import com.example.contasandroid.ui.service.repository.ContaRepository

class CaixaEletronico private constructor() {
    companion object {
        val mRepository = ContaRepository(ContaConstants.GAMBI.CONTEXT)
        fun pagar(contaOrigem: Conta, valor: Double) {
            val op = Operacao(idOrigem = contaOrigem.contaId, valor = valor)
            contaOrigem.saldo -= valor
            mRepository.editConta(contaOrigem)
//            contaOrigem.listaOperacoes.add(op)
        }

        fun pagar(contaOrigem: Conta, contaDestino: Conta, valor: Double) {
            val op = Operacao(idOrigem = contaOrigem.contaId,valor = valor, idDestino = contaDestino.contaId)
            contaOrigem.saldo -= valor
            contaDestino.saldo += valor
            mRepository.editConta(contaOrigem)
            mRepository.editConta(contaDestino)

//            contaOrigem.listaOperacoes.add(op)
//            contaDestino.listaOperacoes.add(op)
        }
    }
}