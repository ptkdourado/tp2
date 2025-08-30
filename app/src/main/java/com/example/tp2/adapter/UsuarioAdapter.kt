package com.example.tp2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2.R
import com.example.tp2.model.Usuario

class UsuarioAdapter(private val usuarios: List<Usuario>):
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txvNomeUsuario = itemView.findViewById<TextView>(R.id.txv_nome_usuario)
        val txvTelefoneUsuario = itemView.findViewById<TextView>(R.id.txv_telefone_usuario)
        val txvEmailUsuario = itemView.findViewById<TextView>(R.id.txv_email_usuario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context) // adicionar a view dentro de onde quem chamou
            .inflate(R.layout.item_usuario,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usuarios.size // função para pegar quantos usuarios existem para saber o tamanho da lista que irá ser apresentada
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.txvNomeUsuario.text = usuario.nome
        holder.txvTelefoneUsuario.text = usuario.telefone
        holder.txvEmailUsuario.text = usuario.email
    }

}