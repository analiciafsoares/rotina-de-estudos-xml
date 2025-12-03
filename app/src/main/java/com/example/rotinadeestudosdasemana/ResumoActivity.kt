package com.example.rotinadeestudosdasemana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResumoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo)

        val txtResumo = findViewById<TextView>(R.id.txtResumo)

        // Usa StringBuilder para montar eficientemente a string de saída
        val sb = StringBuilder()
        sb.append("Resumo semanal:\n\n")

        var total = 0

        // Itera sobre o mapa de rotina no Repository (dia e sua lista de tarefas)
        Repository.rotina.forEach { (dia, lista) ->
            // Conta quantas tarefas existem (lista.size) para cada dia
            sb.append("$dia: ${lista.size} tarefa(s)\n")
            total += lista.size
        }

        sb.append("\nTotal de tarefas na semana: $total")

        // Exibe o texto completo no TextView
        txtResumo.text = sb.toString()
    }
}