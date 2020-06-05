package com.example.contasandroid.ui.service.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.model.Operacao
import com.example.contasandroid.ui.service.utils.SaveShared.Companion.fromJson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSerializer
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.lang.reflect.Modifier
import java.util.*
import kotlin.Exception
import kotlin.collections.ArrayList


class SaveShared(context: Context) {

    companion object {
        inline fun <reified T> fromJson(json: String): T {
            return Gson().fromJson(json, object: TypeToken<T>(){}.type)
        }
    }

    private val context = context
    private val mShared = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    private val mGson = Gson()
    fun saveList() {
        val array: JSONArray = JSONArray()
        val arrayOperacao: JSONArray = JSONArray()

        var obj: JSONObject
        for(c: Conta in ContaConstants.CONTA.LISTACONTAS) {
            obj = JSONObject()
            obj.put("id", c.id)
            obj.put("nomecliente", c.id)
            obj.put("nomebanco", c.id)
            obj.put("saldo", c.id)
            if(c is ContaCorrente) {
                obj.put("limite", c.limite)
            }
            for(op:Operacao in c.listaOperacoes) {
                val objOp: JSONObject = JSONObject()
                objOp.put("id",op.id)
                objOp.put("date",op.date)
                objOp.put("iddestino",op.idDestino)
                objOp.put("idorigem",op.idOrigem)
                objOp.put("valor",op.valor)
                arrayOperacao.put(obj)
            }
            obj.put("listoperacoes", arrayOperacao)
            array.put(obj)
        }
        val listaContas = array.toString()
        mShared.edit().putString("list", listaContas).apply()
    }

    fun loadList() {
        val array: JSONArray = JSONArray(mShared.getString("", null))
        var lista = mutableListOf<Conta>()
        var obj:JSONObject
        var i = 0
        while(i < array.length()) {
            obj = array.getJSONObject(i)
            if(obj.) {

            }
            i++
        }

    }
}