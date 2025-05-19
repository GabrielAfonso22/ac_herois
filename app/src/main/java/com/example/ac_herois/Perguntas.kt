package com.example.ac_herois

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class Perguntas : AppCompatActivity() {

    private val respostasUsuario = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas)

        // Referências aos RadioGroups e Botão
        val radioGroup1: RadioGroup = findViewById(R.id.radioGroup1)
        val botaoFinalizar: Button = findViewById(R.id.botao)

        botaoFinalizar.setOnClickListener {
            val radioButtonSelecionado = radioGroup1.findViewById<RadioButton>(radioGroup1.checkedRadioButtonId)

            if (radioButtonSelecionado != null) {
                respostasUsuario.add(radioButtonSelecionado.text.toString())
            }

            val heroi = determinarHeroi(respostasUsuario)

            val intent = Intent(this, Resultados::class.java)
            intent.putExtra("heroi", heroi)
            startActivity(intent)
            finish()
        }
    }

    private fun determinarHeroi(respostas: List<String>): String {
        return when {
            respostas.contains("Super força") -> "Capitão América"
            respostas.contains("Velocidade") -> "Batman"
            respostas.contains("Inteligência") -> "Homem de Ferro"
            else -> "Herói desconhecido"
        }
    }
}
