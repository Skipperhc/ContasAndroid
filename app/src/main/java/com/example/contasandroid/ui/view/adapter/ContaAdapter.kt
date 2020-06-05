package com.example.contasandroid.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.model.ContaPoupanca
import com.example.contasandroid.ui.view.viewholder.BaseViewHolder
import com.example.contasandroid.ui.view.viewholder.ContaCorrenteViewHolder
import com.example.contasandroid.ui.view.viewholder.ContaPoupancaViewHolder
import com.example.contasandroid.ui.view.viewholder.ContaViewHolder

private const val POUPANCA_VIEW_TYPE = 1
private const val CORRENTE_VIEW_TYPE = 2


class ContaAdapter : RecyclerView.Adapter<ContaViewHolder>() {

    private var mList: List<Conta> = arrayListOf()

    //para cada um dos itens que chegarem, ele vai fazer isso aqui com os dados do item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            CORRENTE_VIEW_TYPE -> {
                val item = inflater.inflate(R.layout.item_conta_corrente,
                    parent, false)
                ContaCorrenteViewHolder(item)
            }

            POUPANCA_VIEW_TYPE -> {
                val item = inflater.inflate(R.layout.item_conta_poupanca,
                    parent, false)
                ContaPoupancaViewHolder(item)
            }
            else -> throw IllegalStateException("Cria a view rapa")
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (mList[position]) {
            is ContaCorrente -> CORRENTE_VIEW_TYPE
            is ContaPoupanca -> POUPANCA_VIEW_TYPE
            else -> throw IllegalStateException("Cria a view rapa")
        }

    //qtd de itens que irá criar
    override fun getItemCount(): Int {
        return mList.count()
    }

    //cada vez reutilizada, quando sumir lá de cima vai ser reusada em baixo
    override fun onBindViewHolder(holder: ContaViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    fun updateList(list: List<Conta>) {
        mList = list
        this.notifyDataSetChanged()
    }
}

