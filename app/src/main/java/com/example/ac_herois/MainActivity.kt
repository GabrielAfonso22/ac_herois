package com.example.ac_herois

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.core.view.WindowCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botaoIniciar = findViewById<Button>(R.id.botaoIniciar)
        botaoIniciar.setOnClickListener {
            val intent = Intent(this, Tela_inicial::class.java)
            startActivity(intent)
        }
    }
}
