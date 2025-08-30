package com.example.tp2.model

interface UsuarioDAO {
    fun adicionarUsuario(usuario: Usuario)
    fun obterUsuarios(): List<Usuario>
}