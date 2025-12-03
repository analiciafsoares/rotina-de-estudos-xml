package com.example.rotinadeestudosdasemana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class DiaActivity : AppCompatActivity() {

    private lateinit var dia: String
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var lista: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia)

        dia = intent.getStringExtra("dia") ?: "Dia"

        val txtDia = findViewById<TextView>(R.id.txtDia)
        txtDia.text = dia

        listView = findViewById(R.id.listViewMaterias)

        lista = Repository.rotina.getOrDefault(dia, mutableListOf())
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listView.adapter = adapter

        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        btnAdicionar.setOnClickListener {
            showAddDialog()
        }

        val btnResumo = findViewById<Button>(R.id.btnResumo)
        btnResumo.setOnClickListener {
            val intent = Intent(this, ResumoActivity::class.java)
            startActivity(intent)
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            // opcional: permitir remover ou editar
            val item = lista[position]
            Toast.makeText(this, "Tarefa: $item", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Adicionar matéria")

        val input = EditText(this)
        input.hint = "Formato: Matéria - HH:MM"
        builder.setView(input)

        builder.setPositiveButton("Adicionar") { dialog, _ ->
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                lista.add(text)
                // atualiza repository
                Repository.rotina[dia] = lista
                adapter.notifyDataSetChanged()
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}