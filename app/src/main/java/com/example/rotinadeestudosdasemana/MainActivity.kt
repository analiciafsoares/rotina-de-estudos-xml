package com.example.rotinadeestudosdasemana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

// A primeira tela que lista os dias da semana
class MainActivity : AppCompatActivity() {

    // Lista estática dos dias da semana
    private val dias = listOf(
        "Segunda-feira",
        "Terça-feira",
        "Quarta-feira",
        "Quinta-feira",
        "Sexta-feira",
        "Sábado",
        "Domingo"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o layout XML para esta Activity
        setContentView(R.layout.activity_main)

        // 1. Encontra o componente ListView no layout
        val listView = findViewById<ListView>(R.id.listViewDias)

        // 2. Cria um ArrayAdapter: ele liga a lista de 'dias' ao ListView
        // android.R.layout.simple_list_item_1 é um layout padrão do Android para itens de lista
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dias)

        // 3. Atribui o adaptador ao ListView
        listView.adapter = adapter

        // Configura a ação ao clicar em um item da lista
        listView.setOnItemClickListener { _, _, position, _ ->
            val dia = dias[position] // Obtém o nome do dia clicado

            // Cria um Intent para iniciar a próxima tela (DiaActivity)
            val intent = Intent(this, DiaActivity::class.java)

            // Adiciona o nome do dia como um "extra" no Intent.
            // Isso permite que DiaActivity saiba qual dia abrir.
            intent.putExtra("dia", dia)

            // Inicia a DiaActivity
            startActivity(intent)
        }
    }
}