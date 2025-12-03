package com.example.rotinadeestudosdasemana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class DiaActivity : AppCompatActivity() {

    private lateinit var dia: String // Guarda o dia da semana atual
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var lista: MutableList<String> // A lista de tarefas do dia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dia)

        // 1. RECEBE O DIA: Recupera o nome do dia que veio da MainActivity via Intent
        dia = intent.getStringExtra("dia") ?: "Dia"

        val txtDia = findViewById<TextView>(R.id.txtDia)
        txtDia.text = dia // Atualiza o título da tela

        listView = findViewById(R.id.listViewMaterias)

        // 2. LÊ DO REPOSITORY: Pega a lista de tarefas para o dia específico
        lista = Repository.rotina.getOrDefault(dia, mutableListOf())

        // Configura o adaptador para exibir a lista de tarefas
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        listView.adapter = adapter

        // Ação do botão ADICIONAR
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        btnAdicionar.setOnClickListener {
            showAddDialog() // Abre o pop-up para adicionar tarefa
        }

        // Ação do botão RESUMO
        val btnResumo = findViewById<Button>(R.id.btnResumo)
        btnResumo.setOnClickListener {
            val intent = Intent(this, ResumoActivity::class.java)
            startActivity(intent) // Navega para a tela de resumo
        }

        // Ação ao clicar em uma tarefa (exibe um Toast)
        listView.setOnItemClickListener { _, _, position, _ ->
            val item = lista[position]
            Toast.makeText(this, "Tarefa: $item", Toast.LENGTH_SHORT).show()
        }
    }

    // Função para mostrar o diálogo de adição de matéria
    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Adicionar matéria")

        // Cria um campo de texto para o usuário digitar
        val input = EditText(this)
        input.hint = "Formato: Matéria - HH:MM"
        builder.setView(input)

        builder.setPositiveButton("Adicionar") { dialog, _ ->
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                lista.add(text) // Adiciona o texto à lista local

                // 3. ATUALIZA REPOSITORY: Salva a lista modificada no objeto Singleton
                Repository.rotina[dia] = lista

                // Notifica o adaptador que os dados mudaram para redesenhar o ListView
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