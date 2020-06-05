package com.example.contasandroid.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.view.adapter.OperacaoAdapter
import com.example.contasandroid.ui.viewmodel.DetailsViewModel
import com.example.contasandroid.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var mViewModel: DetailsViewModel
    private val mOperacaoAdapter = OperacaoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var extras = intent.extras

        if (extras != null) {
            val idConta = extras.getInt("idConta")
            var conta = ContaConstants.CONTA.LISTACONTAS.first { it.id == idConta }

            mViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
            //1 - Obter a recycler
            val recycler = recycler_view_operacoes

            //2 - Definir um layout
            recycler.layoutManager = LinearLayoutManager(this)

            //3 - Definir um adapter
            recycler.adapter = mOperacaoAdapter
            mViewModel.create(conta)
        }
        setObservers()
        setListeners()
    }

    fun setListeners() {
        ButtonVoltar.setOnClickListener {
            finish()
        }
    }

    fun setObservers() {
        mViewModel.id.observe(this, Observer {
            TextId.text = it
        })

        mViewModel.nomeBanco.observe(this, Observer {
            TextBanco.text = it
        })

        mViewModel.nomeCliente.observe(this, Observer {
            TextName.text = it
        })

        mViewModel.saldo.observe(this, Observer {
            TextSaldo.text = it
        })

        mViewModel.limite.observe(this, Observer {
            TextLimite.text = it
        })

        mViewModel.listaOperacoes.observe(this, Observer {
            mOperacaoAdapter.updateList(it)
        })
    }
}
