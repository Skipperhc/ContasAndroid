package com.example.contasandroid.ui.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contasandroid.R
import com.example.contasandroid.ui.service.model.Conta
import com.example.contasandroid.ui.service.model.ContaCorrente
import com.example.contasandroid.ui.service.model.ContaPoupanca

abstract class BaseViewHolder<T> (itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}