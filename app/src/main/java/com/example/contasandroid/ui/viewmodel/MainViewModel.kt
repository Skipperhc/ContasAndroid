package com.example.contasandroid.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.Conta

class MainViewModel : ViewModel() {
    private var mListaContas = MutableLiveData<List<Conta>>()
    var listaContas: LiveData<List<Conta>> = mListaContas

    fun load() {
        mListaContas.value = ContaConstants.CONTA.LISTACONTAS
    }

    init {
        mListaContas.value = ContaConstants.CONTA.LISTACONTAS
    }
}