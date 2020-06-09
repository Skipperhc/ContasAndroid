package com.example.contasandroid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contasandroid.ui.service.utils.EmptyFieldsException
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.ContaPoupanca
import com.example.contasandroid.ui.service.repository.ContaRepository
import java.lang.NumberFormatException

class CriarContaPoupancaViewModel() : ViewModel() {
    private var mSavedConta = MutableLiveData<Boolean>()
    var savedConta = mSavedConta

    private var mMessageToast = MutableLiveData<String>()
    var message = mMessageToast

    fun saveConta(nomeCliente: String, nomeBanco: String, saldo: String) {

        var saldoDouble: Double
        try {
            if (nomeCliente == "" || nomeBanco == "" || saldo == "") {
                throw EmptyFieldsException("Preencha todos os campos corretamente")
            }

            saldoDouble = saldo.toDouble()

            val conta =
                ContaPoupanca(
                    nomeCliente = nomeCliente,
                    nomeBanco = nomeBanco,
                    saldo = saldoDouble,
                    valorMax = saldoDouble
                )
            ContaRepository(ContaConstants.GAMBI.CONTEXT).saveConta(conta)
            mMessageToast.value = "Conta criada com sucesso"
            mSavedConta.value = true;
        } catch (excp: NumberFormatException) {
            mMessageToast.value = "Insira um saldo válido"
            savedConta.value = false
        } catch (excp: EmptyFieldsException) {
            mMessageToast.value = excp.message
            mSavedConta.value = false
        }
    }
}