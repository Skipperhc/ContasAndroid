package com.example.contasandroid.ui.viewmodel

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.repository.ContaRepository
import com.example.contasandroid.ui.service.utils.EmptyFieldsException
import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

class CriarContaCorrenteViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application.applicationContext

    private var mSavedConta = MutableLiveData<Boolean>()
    var savedConta: LiveData<Boolean> = mSavedConta

    private var mMessageToast = MutableLiveData<String>()
    var message: LiveData<String> = mMessageToast

    fun saveConta(nomeCliente: String, nomeBanco: String, saldo: String, limite: String) {

        val saldoDouble: Double
        val limiteDouble: Double
        try {
            if (nomeCliente == "" || nomeBanco == "" || saldo == "" || limite == "") {
                throw EmptyFieldsException("Preencha todos os campos corretamente")
            }
            saldoDouble = saldo.toDouble()
            limiteDouble = limite.toDouble()
            if (limiteDouble < 0 && saldoDouble < -limiteDouble) {
                throw IllegalArgumentException("Insira um saldo maior que seu limite")
            }

            val conta = ContaCorrente(nomeBanco = nomeBanco, valorMax = limiteDouble + saldoDouble,
                                        saldo = saldoDouble, nomeCliente = nomeCliente)

            ContaRepository(mContext).saveConta(conta)
            mMessageToast.value = "Conta criada com sucesso"
            mSavedConta.value = true;
        } catch (excp: NumberFormatException) {
            mMessageToast.value = "Insira numeros válidos"
            mSavedConta.value = false
        } catch (excp: IllegalArgumentException) {
            mMessageToast.value = excp.message
            mSavedConta.value = false
        } catch (excp: EmptyFieldsException) {
            mMessageToast.value = excp.message
            mSavedConta.value = false
        }
    }
}