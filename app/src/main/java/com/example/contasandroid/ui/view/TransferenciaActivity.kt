package com.example.contasandroid.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contasandroid.R
import com.example.contasandroid.ui.viewmodel.MainViewModel
import com.example.contasandroid.ui.viewmodel.TransferenciaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_transferencia.*

class TransferenciaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: TransferenciaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferencia)

        mViewModel = ViewModelProvider(this).get(TransferenciaViewModel::class.java)

        setListeners()
        setObservers()
    }

    fun setListeners() {
        ButtonVoltar.setOnClickListener {
            finish()
        }

        ButtonTransferir.setOnClickListener {
            if(checkbox_boleto.isChecked) {
                val idOrigem: String = edit_id_origem.text.toString()
                val valor:String = edit_valor.text.toString()
                mViewModel.payBankSlip(idOrigem = idOrigem, valor = valor)
            } else {
                val idOrigem: String = edit_id_origem.text.toString()
                val idDestino: String = EditIdDestino.text.toString()
                val valor:String = edit_valor.text.toString()
                mViewModel.transfer(idOrigem = idOrigem, valor = valor, idDestino = idDestino)
            }
        }

        checkbox_boleto.setOnClickListener {
            if(checkbox_boleto.isChecked) {
                text_id_Destino.visibility = View.GONE
                EditIdDestino.visibility = View.GONE
                ButtonTransferir.text = "Pagar Boleto"
            } else {
                text_id_Destino.visibility = View.VISIBLE
                EditIdDestino.visibility = View.VISIBLE
                ButtonTransferir.text = "Transferir"
            }
        }
    }

    fun setObservers() {
        mViewModel.message.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        mViewModel.result.observe(this, Observer {
            if(it) finish()
        })
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
