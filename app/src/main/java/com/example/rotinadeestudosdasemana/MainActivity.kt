package com.example.rotinadeestudosdasemana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewDias)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dias)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val dia = dias[position]
            val intent = Intent(this, DiaActivity::class.java)
            intent.putExtra("dia", dia)
            startActivity(intent)
        }
    }
}