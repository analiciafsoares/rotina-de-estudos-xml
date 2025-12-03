package com.example.rotinadeestudosdasemana

object Repository {
    // Map: dia -> lista de pares (materia, horario)
    val rotina: MutableMap<String, MutableList<String>> = mutableMapOf()

    init {
        // valores iniciais (podem ser alterados em runtime)
        rotina["Segunda-feira"] = mutableListOf("Matemática - 08:00", "Português - 10:00")
        rotina["Terça-feira"] = mutableListOf("História - 09:00")
        rotina["Quarta-feira"] = mutableListOf("Física - 14:00")
        rotina["Quinta-feira"] = mutableListOf("Química - 11:00")
        rotina["Sexta-feira"] = mutableListOf("Inglês - 10:00")
        rotina["Sábado"] = mutableListOf("Revisão geral - 09:00")
        rotina["Domingo"] = mutableListOf("Descanso")
    }
}