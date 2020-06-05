package com.example.contasandroid.ui.view.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.view.DetailsActivity
import kotlinx.android.synthetic.main.item_conta_corrente.view.*

class ContaCorrenteViewHolder(itemView: View) : ContaViewHolder(itemView) {

    override fun bind(conta: Conta) {
        if(conta !is ContaCorrente) throw IllegalArgumentException("")
        val nome = itemView.findViewById<TextView>(R.id.text_corrente_name)
        val banco = itemView.findViewById<TextView>(R.id.text_corrente_banco)
        val id = itemView.findViewById<TextView>(R.id.text_corrente_id)
        val saldo = itemView.findViewById<TextView>(R.id.text_corrente_saldo)
        val limite = itemView.findViewById<TextView>(R.id.text_corrente_limite)

        val image = itemView.findViewById<ImageView>(R.id.image_view_details)

        image.setOnClickListener {
            val intent = Intent(itemView.context, DetailsActivity::class.java)
            intent.putExtra("idConta", conta.id)
            itemView.context.startActivity(intent) ////////////////////////////////queeeeeeeeeeee
        }

        nome.text = conta.nomeCliente
        banco.text = conta.nomeBanco
        id.text = conta.id.toString()
        saldo.text = conta.saldo.toString()
        limite.text = conta.limite.toString()
    }
}