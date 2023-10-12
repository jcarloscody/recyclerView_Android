package com.example.firstapplication.dao

import com.example.firstapplication.models.Produtos

class ProdutosDAO {

    fun add(produtos: Produtos){
        Companion.produtos.add(produtos)
    }

    fun getAll():List<Produtos>
    {
        return produtos.toList()
    }

    companion object {
        private val  produtos = mutableListOf<Produtos>()
    }
}