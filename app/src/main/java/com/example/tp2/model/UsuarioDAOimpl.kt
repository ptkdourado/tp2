package com.example.tp2.model

class UsuarioDAOimpl: UsuarioDAO {
    companion object{
        val usuarios = mutableListOf<Usuario>()
    }

    override fun adicionarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    override fun obterUsuarios(): List<Usuario> {
        return usuarios
    }
}