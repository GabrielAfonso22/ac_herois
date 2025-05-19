package com.example.ac_herois

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Resultados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val heroi = intent.getStringExtra("heroi") ?: "Herói Desconhecido"

        val imagemResultado: ImageView = findViewById(R.id.imagemResultado)
        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)
        val botaoReiniciar: Button = findViewById(R.id.botaoReiniciar)
        val botaoCompartilhar: Button = findViewById(R.id.botaoCompartilhar)

        // Atualiza o texto e a imagem com base no herói
        when (heroi) {
            "Homem de Ferro" -> {
                imagemResultado.setImageResource(R.drawable.homem_de_ferro)
                resultadoTextView.text = "Você é o Homem de Ferro!"
            }
            "Batman" -> {
                imagemResultado.setImageResource(R.drawable.batman)
                resultadoTextView.text = "Você é o Batman!"
            }
            else -> {
                imagemResultado.setImageResource(R.drawable.capitao_america)
                resultadoTextView.text = "Você é o Capitão América!"
            }
        }

        botaoReiniciar.setOnClickListener {
            val intent = Intent(this, Perguntas::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        botaoCompartilhar.setOnClickListener {
            val textoCompartilhar = "Eu acabei de fazer o quiz de heróis e o meu resultado é: $heroi"

            val intentCompartilhar = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textoCompartilhar)
            }

            startActivity(Intent.createChooser(intentCompartilhar, "Compartilhar resultado"))
        }
    }
}
