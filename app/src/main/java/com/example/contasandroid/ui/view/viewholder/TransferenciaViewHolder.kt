package com.example.contasandroid.ui.view.viewholder

import android.view.View
import android.widget.TextView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.model.Operacao

class TransferenciaViewHolder(itemView: View) : OperacaoViewHolder(itemView) {
    override fun bind(item: Operacao) {
        val origem = itemView.findViewById<TextView>(R.id.TextIdOrigem)
        val valor = itemView.findViewById<TextView>(R.id.TextValor)
        val destino = itemView.findViewById<TextView>(R.id.TextIdDestino)

        origem.text = item.idOrigem.toString()
        valor.text = item.valor.toString()
        destino.text = item.idDestino.toString()
    }
}