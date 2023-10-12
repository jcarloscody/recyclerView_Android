package com.example.firstapplication.ui.recyclervie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import  androidx.recyclerview.widget.RecyclerView
import com.example.firstapplication.models.Produtos
import com.example.firstapplication.R

class ExemploDeRecyclerView( produtos: List<Produtos>, val contexto: Context) : RecyclerView.Adapter<ExemploDeRecyclerView.ViewHolderEspecifico>() {

    private val produtos = produtos.toMutableList()

    class ViewHolderEspecifico(view: View) : RecyclerView.ViewHolder(view){
        fun vincula(produto: Produtos) {
            val desc = itemView.findViewById<TextView>(R.id.textView)
            desc.text = produto.nome
            val valor = itemView.findViewById<TextView>(R.id.textView2)
            valor.text = produto.preco.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderEspecifico {
        val inflater = LayoutInflater.from(contexto)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolderEspecifico(view)
    }

    override fun onBindViewHolder(holder: ViewHolderEspecifico, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    fun update(produtos: List<Produtos>){
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}
