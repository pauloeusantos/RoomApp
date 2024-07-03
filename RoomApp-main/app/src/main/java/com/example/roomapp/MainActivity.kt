package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roomapp.model.UsuarioModel
import com.example.roomapp.repository.UsuarioDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usuarioDatabase = UsuarioDataBase.getDataBase(this).usuarioDAO()


        val retornoInsert = usuarioDatabase.insertUser(UsuarioModel().apply {

            this.nome = "Paulo Henrique"
            this.idade = 17
        })

        val retornoSelectMultiplo = usuarioDatabase.getAll()

        for(item in retornoSelectMultiplo){
            Log.d("Retorno Múltiplo", "id_usuario: ${item.id_usuario}, nome: ${item.nome}, idade: ${item.idade}")
        }


    }
}