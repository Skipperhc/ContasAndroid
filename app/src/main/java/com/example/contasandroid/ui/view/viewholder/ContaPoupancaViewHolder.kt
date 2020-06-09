package com.example.contasandroid.ui.view.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.view.DetailsActivity

class ContaPoupancaViewHolder(itemView: View) : ContaViewHolder(itemView) {
    override fun bind(conta: Conta) {
        val nome = itemView.findViewById<TextView>(R.id.text_name)
        val banco = itemView.findViewById<TextView>(R.id.text_banco)
        val id = itemView.findViewById<TextView>(R.id.text_id_conta)
        val saldo = itemView.findViewById<TextView>(R.id.text_saldo)
        val image = itemView.findViewById<ImageView>(R.id.image_view_details)

        image.setOnClickListener {
            var intent = Intent(itemView.context, DetailsActivity::class.java)
            intent.putExtra("idConta", conta.contaId)
            itemView.context.startActivity(intent)
        }

        nome.text = conta.nomeCliente
        banco.text = conta.nomeBanco
        id.text = conta.contaId.toString()
        saldo.text = conta.saldo.toString()
    }
}