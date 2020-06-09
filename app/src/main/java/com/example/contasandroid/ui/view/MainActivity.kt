package com.example.contasandroid.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.constants.ContaConstants
import com.example.contasandroid.ui.view.adapter.ContaAdapter
import com.example.contasandroid.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: MainViewModel
    private val mContaAdapter = ContaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        ContaConstants.GAMBI.CONTEXT = this;
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //1 - Obter a recycler
        val recycler = recycle_view_contas

        //2 - Definir um layout
        recycler.layoutManager = LinearLayoutManager(this)

        //3 - Definir um adapter
        recycler.adapter = mContaAdapter

        setupListeners()
        setupObservers()
    }

    fun setupListeners() {
        button_contapoupanca.setOnClickListener {
            startActivity(Intent(this, CriarContaPoupancaActivity::class.java))
        }

        button_contaCorrente.setOnClickListener {
            startActivity(Intent(this, CriarContaCorrenteActivity::class.java))
        }

        button_transferencia.setOnClickListener {
            startActivity(Intent(this, TransferenciaActivity::class.java))
        }
    }

    private fun setupObservers() {
        mViewModel.listaContas.observe(this, Observer {
            mContaAdapter.updateList(it)
        })
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}
