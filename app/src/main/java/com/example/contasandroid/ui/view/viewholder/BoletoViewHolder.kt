package com.example.contasandroid.ui.view.viewholder

import android.view.View
import android.widget.TextView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.model.Operacao

class BoletoViewHolder(itemView: View) : OperacaoViewHolder(itemView) {
    override fun bind(item: Operacao) {
        val origem = itemView.findViewById<TextView>(R.id.TextIdOrigem)
        val valor = itemView.findViewById<TextView>(R.id.TextValor)

        origem.text = item.idOrigem.toString()
        valor.text = item.valor.toString()
    }

}