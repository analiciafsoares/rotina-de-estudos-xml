package com.example.rotinadeestudosdasemana

// 'object' em Kotlin cria um Singleton: uma única instância que persiste
// enquanto o aplicativo estiver rodando. Ótimo para dados em memória.
object Repository {
    // Mapa mutável que armazena a rotina:
    // Chave: Nome do dia (String)
    // Valor: Lista mutável de tarefas (ex: "Matemática - 08:00")
    val rotina: MutableMap<String, MutableList<String>> = mutableMapOf()

    init {
        // Bloco de inicialização: Define os valores iniciais quando o objeto é criado pela primeira vez.
        rotina["Segunda-feira"] = mutableListOf("Matemática - 08:00", "Português - 10:00")
        rotina["Terça-feira"] = mutableListOf("História - 09:00")
        rotina["Quarta-feira"] = mutableListOf("Física - 14:00")
        rotina["Quinta-feira"] = mutableListOf("Química - 11:00")
        rotina["Sexta-feira"] = mutableListOf("Inglês - 10:00")
        rotina["Sábado"] = mutableListOf("Revisão geral - 09:00")
        rotina["Domingo"] = mutableListOf("Descanso")
    }

    // As outras Activities chamam diretamente Repository.rotina para ler/gravar dados.
}