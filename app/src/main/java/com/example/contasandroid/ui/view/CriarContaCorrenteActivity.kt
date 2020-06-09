package com.example.contasandroid.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.viewmodel.CriarContaCorrenteViewModel
import kotlinx.android.synthetic.main.activity_criar_conta_corrente.*
import kotlinx.android.synthetic.main.activity_criar_conta_corrente.button_criar_conta
import kotlinx.android.synthetic.main.activity_criar_conta_corrente.button_voltar
import kotlinx.android.synthetic.main.activity_criar_conta_corrente.edit_text_nome_banco
import kotlinx.android.synthetic.main.activity_criar_conta_corrente.edit_text_nome_cliente
import kotlinx.android.synthetic.main.activity_criar_conta_corrente.edit_text_saldo

class CriarContaCorrenteActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: CriarContaCorrenteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta_corrente)
        ContaConstants.GAMBI.CONTEXT = this;
        mViewModel = ViewModelProvider(this).get(CriarContaCorrenteViewModel::class.java)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        button_criar_conta.setOnClickListener {
            val nome = edit_text_nome_cliente.text.toString()
            val banco = edit_text_nome_banco.text.toString()
            val saldo = edit_text_saldo.text.toString()
            val limite = edit_text_limite.text.toString()
            mViewModel.saveConta(nome, banco, saldo, limite)
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
            if(it) {
                finish()
            }
        })
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
