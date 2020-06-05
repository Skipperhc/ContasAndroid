package com.example.contasandroid.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.utils.CaixaEletronico
import com.example.contasandroid.ui.service.utils.InsuficientValueException
import java.lang.NumberFormatException

class TransferenciaViewModel : ViewModel() {

    private var mMessage = MutableLiveData<String>()
    var message: LiveData<String> = mMessage

    private var mResult = MutableLiveData<Boolean>()
    var result: LiveData<Boolean> = mResult

    fun payBankSlip(idOrigem: String, valor: String) {
        try {
            val idInt: Int = idOrigem.toInt()
            val valorDouble: Double = valor.toDouble()
            var conta = searchAccount(idInt)

            if (conta.valorMax() < valorDouble) {
                throw InsuficientValueException("Valor maior do que o saldo da conta")
            }

            CaixaEletronico.pagar(conta, valorDouble)
            mMessage.value = "Boleto pago com sucesso"
            mResult.value = true
        } catch (excp: InsuficientValueException) {
            mMessage.value = excp.message
        } catch (excp: NumberFormatException) {
            mMessage.value = "Insira numeros válidos"
        } catch (excp: NoSuchElementException) {
            mMessage.value = "Id da conta não existe"
        }
    }

    fun transfer(idOrigem: String, idDestino: String, valor: String) {
        try {
            val idOrigemInt: Int = idOrigem.toInt()
            val valorDouble: Double = valor.toDouble()
            val idDestinoInt: Int = idDestino.toInt()
            var contaOrigem: Conta = searchAccount(idOrigemInt)
            var contaDestino: Conta = searchAccount(idDestinoInt)
            if (contaOrigem.valorMax() < valorDouble) {
                throw InsuficientValueException("Valor maior do que o saldo da conta")
            }
            CaixaEletronico.pagar(
                contaOrigem = contaOrigem,
                contaDestino = contaDestino,
                valor = valorDouble
            )
            mMessage.value = "Transferência efetuada"
            mResult.value = true
        } catch (excp: InsuficientValueException) {
            mMessage.value = excp.message
        } catch (excp: NumberFormatException) {
            mMessage.value = "Insira numeros válidos"
        } catch (excp: NoSuchElementException) {
            mMessage.value = "Id da conta não existe"
        }
    }

    fun searchAccount(id: Int) : Conta {
        return ContaConstants.CONTA.LISTACONTAS.first { it.id == id }
    }
}