package com.example.contasandroid.ui.viewmodel

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.repository.ContaRepository

class MainViewModel() : ViewModel() {
    private var mListaContas = MutableLiveData<List<Conta>>()
    var listaContas: LiveData<List<Conta>> = mListaContas

    fun load() {
        mListaContas.value = ContaRepository(ContaConstants.GAMBI.CONTEXT).listContas()
    }
}