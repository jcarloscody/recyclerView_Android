package com.example.firstapplication.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.firstapplication.R
import com.example.firstapplication.dao.ProdutosDAO
import com.example.firstapplication.models.Produtos
import java.math.BigDecimal

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val salvar = findViewById<Button>(R.id.salvar)
        salvar.setOnClickListener {
            val nome = findViewById<EditText>(R.id.nome).text.toString()
            val preco = findViewById<EditText>(R.id.prec).text.toString()
            val prec = if (preco.isBlank()){
                BigDecimal.ZERO
            }else {
                BigDecimal(preco)
            }

            ProdutosDAO().add(Produtos(nome = nome, preco = prec))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }



    }
}