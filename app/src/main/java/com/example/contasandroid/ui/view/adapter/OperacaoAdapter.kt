package com.example.contasandroid.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.model.ContaPoupanca
import com.example.contasandroid.ui.service.model.Operacao
import com.example.contasandroid.ui.view.viewholder.BoletoViewHolder
import com.example.contasandroid.ui.view.viewholder.OperacaoViewHolder
import com.example.contasandroid.ui.view.viewholder.TransferenciaViewHolder

class OperacaoAdapter : RecyclerView.Adapter<OperacaoViewHolder>() {

    private var mList: List<Operacao> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperacaoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            ContaConstants.CONTROL.BOLETO -> {
                val item = inflater.inflate(R.layout.item_operacao_boleto,
                    parent, false)
                BoletoViewHolder(item)
            }

            ContaConstants.CONTROL.TRANSFERENCIA -> {
                val item = inflater.inflate(R.layout.item_operacao_transferencia,
                    parent, false)
                TransferenciaViewHolder(item)
            }
            else -> throw IllegalStateException("Cria um tipo de operação")
        }

    }

    override fun getItemViewType(position: Int): Int {
        val op = mList[position]
        return when(op.idDestino) {
            ContaConstants.CONTROL.ID_DESTINO_DEFAULT -> ContaConstants.CONTROL.BOLETO
            else -> ContaConstants.CONTROL.TRANSFERENCIA
        }
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: OperacaoViewHolder, position: Int) {
        holder.bind(mList[position])
    }


    fun updateList(list: List<Operacao>) {
        mList = list
        this.notifyDataSetChanged()
    }
}