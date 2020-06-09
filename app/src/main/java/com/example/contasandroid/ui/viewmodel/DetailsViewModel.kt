package com.example.contasandroid.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.model.Operacao
import kotlinx.android.synthetic.main.activity_details.*

class DetailsViewModel : ViewModel() {

    private var mListaOperacoes = MutableLiveData<List<Operacao>>()
    var listaOperacoes = mListaOperacoes
    private var mNomeCliente = MutableLiveData<String>()
    var nomeCliente = mNomeCliente
    private var mId = MutableLiveData<String>()
    var id = mId
    private var mNomeBanco = MutableLiveData<String>()
    var nomeBanco = mNomeBanco
    private var mSaldo = MutableLiveData<String>()
    var saldo = mSaldo
    private var mLimite = MutableLiveData<String>()
    var limite = mLimite

    fun create(conta: Conta) {
        mNomeCliente.value = conta.nomeCliente
        mSaldo.value = conta.saldo.toString()
        mNomeBanco.value = conta.nomeBanco
        mId.value = conta.contaId.toString()
    }
}