package com.example.ac_herois

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class Tela_inicial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val botaoIniciar = findViewById<Button>(R.id.botaoIniciar)
        botaoIniciar.setOnClickListener {
            val intent = Intent(this, Perguntas::class.java)
            startActivity(intent)
        }
    }
}
