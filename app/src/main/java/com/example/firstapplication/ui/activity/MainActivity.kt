package com.example.firstapplication.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplication.R
import com.example.firstapplication.dao.ProdutosDAO
import com.example.firstapplication.models.Produtos
import com.example.firstapplication.ui.recyclervie.ExemploDeRecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    val dao = ExemploDeRecyclerView(contexto = this, produtos = ProdutosDAO().getAll())
    lateinit var recyclerView: RecyclerView
    lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Toast.makeText(this, "Você está no onCreate", Toast.LENGTH_LONG).show()
        //  var findViewById = findViewById<TextView>(R.id.textView)
        //findViewById.text = "text 1111"
        //var findViewById2 = findViewById<TextView>(R.id.textView2)
        //findViewById2.text = "adçamdsfoik"

       /* var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ExemploDeRecyclerView(contexto = this, produtos = ProdutosDAO().getAll())
        //recyclerView.layoutManager = LinearLayoutManager(this)

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }*/


        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }
        recyclerView.adapter = dao
    }

    override fun onResume() {
        super.onResume()
        dao.update(ProdutosDAO().getAll())
    }
}