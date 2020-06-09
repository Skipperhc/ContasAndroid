package com.example.contasandroid.ui.service.repository

import android.content.Context
import com.example.contasandroid.ui.service.model.Conta

class ContaRepository (context: Context) {

    private val mDatabase = ContaDatabase.getDatabase(context).contaDao()

    fun getConta(id: Int) : Conta {
        return mDatabase.getConta(id)
    }

    fun saveConta(conta: Conta) {
        mDatabase.save(conta)
    }

    fun listContas() : List<Conta> {
        return mDatabase.listContas()
    }

    fun deleteConta(conta: Conta) {
        mDatabase.delete(conta)
    }

    fun editConta(conta: Conta) : Boolean {
        return mDatabase.update(conta) > 0
    }
}