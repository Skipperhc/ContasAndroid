package com.example.contasandroid.ui.service.constants

import android.content.Context
import android.content.SharedPreferences
import com.example.contasandroid.ui.service.model.Conta

class ContaConstants private constructor()  {
    companion object {
    }

    object CONTA {
        var LISTACONTAS: ArrayList<Conta> = ArrayList()
        var IDCONTA = 1
        }
    
    object CONTROL {
        const val ID_DESTINO_DEFAULT = 0
        const val BOLETO = 1
        const val TRANSFERENCIA = 2
    }

    fun salvarSharedPreferences(context: Context) {
    }
}
