package com.example.contasandroid.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.viewmodel.CriarContaPoupancaViewModel
import kotlinx.android.synthetic.main.activity_criar_conta_poupanca.*

class CriarContaPoupancaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: CriarContaPoupancaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta_poupanca)
        ContaConstants.GAMBI.CONTEXT = this;
        mViewModel = ViewModelProvider(this).get(CriarContaPoupancaViewModel::class.java)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        button_criar_conta.setOnClickListener {
            val nome = edit_text_nome_cliente.text.toString()
            val banco = edit_text_nome_banco.text.toString()
            val saldo = edit_text_saldo.text.toString()
            mViewModel.saveConta(nome, banco, saldo)
        }

        button_voltar.setOnClickListener {
            finish()
        }
    }

    private fun setObservers() {
        mViewModel.message.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        mViewModel.savedConta.observe(this, Observer {
            if (it) {
                finish()
            }
        })
    }

    override fun onClick(v: View) {

    }
}
