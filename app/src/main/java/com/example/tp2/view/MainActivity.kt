package com.example.tp2.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp2.R
import com.example.tp2.model.Usuario
import com.example.tp2.model.UsuarioDAOimpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val dao = UsuarioDAOimpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeUsuario = findViewById<EditText>(R.id.edt_nome_usuario)
        val edtEmailUsuario = findViewById<EditText>(R.id.edt_email_usuario)
        val edtTelefoneUsuario = findViewById<EditText>(R.id.edt_telefone_usuario)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)




        btnCadastrar.setOnClickListener {
            val nomeUsuario = edtNomeUsuario.text.toString()
            val emailUsuario = edtEmailUsuario.text.toString()
            val telefoneUsuario = edtTelefoneUsuario.text.toString()
            val newusuario = Usuario(nomeUsuario,emailUsuario,telefoneUsuario)
            dao.adicionarUsuario(newusuario)
            edtNomeUsuario.text.clear()
            edtEmailUsuario.text.clear()
            edtTelefoneUsuario.text.clear()

            val builder = AlertDialog.Builder(this, )
            builder.setTitle("Sucesso")
            builder.setMessage("Usuario criado com sucesso")
            var alert = builder.create()
            alert.show()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, ListaUsuariosActivity::class.java)
            startActivity(intent)

        }

    }
}