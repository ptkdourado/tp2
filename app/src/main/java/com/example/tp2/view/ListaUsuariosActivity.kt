package com.example.tp2.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2.R
import com.example.tp2.adapter.UsuarioAdapter
import com.example.tp2.model.UsuarioDAOimpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaUsuariosActivity : AppCompatActivity(R.layout.activity_lista_usuarios) {
    private val dao = UsuarioDAOimpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvUsuarios = findViewById<RecyclerView>(R.id.rv_usuarios)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)
        val listaUsuarios = dao.obterUsuarios()
        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = UsuarioAdapter(listaUsuarios)

        fabVolta.setOnClickListener {
            finish()
        }


    }
}