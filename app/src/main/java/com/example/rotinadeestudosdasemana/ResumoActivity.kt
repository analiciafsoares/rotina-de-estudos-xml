package com.example.rotinadeestudosdasemana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResumoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo)

        val txtResumo = findViewById<TextView>(R.id.txtResumo)

        // monta resumo básico: quantidade de tarefas por dia
        val sb = StringBuilder()
        sb.append("Resumo semanal:\n\n")


        var total = 0
        Repository.rotina.forEach { (dia, lista) ->
            sb.append("$dia: ${lista.size} tarefa(s)\n")
            total += lista.size
        }

        sb.append("\nTotal de tarefas na semana: $total")

        txtResumo.text = sb.toString()
    }
}