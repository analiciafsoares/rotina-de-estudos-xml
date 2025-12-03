# 📘 Rotina de Estudos da Semana - Projeto Android (Kotlin + XML)

Este é um aplicativo Android simples desenvolvido para fins
educacionais.\
Ele utiliza **Kotlin**, **Activities**, **XML** e um **Repository em
memória**, conforme solicitado na atividade da disciplina.

------------------------------------------------------------------------

## 📱 Funcionalidades do App

### **Tela inicial**

-   Exibe todos os dias da semana.
-   Ao clicar em um dia, abre a tela detalhada.

### **Tela detalhada de cada dia**

-   Lista de matérias/atividades daquele dia.
-   Horários associados.
-   Botão para **adicionar nova atividade**.
-   Botão para **ver o Resumo da Semana**.
-   Uso de `Toast` ao clicar em uma matéria.

### **Tela de Resumo da Semana**

-   Quantidade de tarefas por dia.
-   Total geral de atividades.
-   Dados carregados do repositório em memória.

------------------------------------------------------------------------

## 📂 Estrutura de Pastas

    app/
     └── src/main/
         ├── java/com/example/rotinadasemana/
         │     ├── MainActivity.kt
         │     ├── DiaActivity.kt
         │     ├── ResumoActivity.kt
         │     └── Repository.kt
         └── res/
               ├── layout/
               │     ├── activity_main.xml
               │     ├── activity_dia.xml
               │     ├── activity_resumo.xml
               │     └── item_subject.xml
               └── values/
                     ├── strings.xml
                     └── colors.xml

    AndroidManifest.xml  
    README.md

------------------------------------------------------------------------

## 🧠 Funcionamento do App

### **Repository - Armazenamento em Memória**

O app **não utiliza banco de dados**.
Os dados são armazenados em um objeto Kotlin chamado `Repository`, que é
mantido enquanto o app estiver aberto.

Ele armazena:

    dia da semana → lista de disciplinas

Exemplo:

    Segunda → ["Matemática - 08:00", "Português - 10:00"]

------------------------------------------------------------------------

## 🚀 Activities do Aplicativo

### **1. MainActivity - Tela Inicial**

-   Exibe os dias da semana usando `ListView`.
-   Ao selecionar um dia, abre a `DiaActivity`.

### **2. DiaActivity - Rotina do Dia**

-   Exibe matérias do dia selecionado.
-   Permite adicionar novas atividades via `AlertDialog`.
-   Botão para acessar o **Resumo da Semana**.
-   Atualiza automaticamente o `Repository`.

### **3. ResumoActivity - Resumo Semanal**

Exemplo de exibição:

    Resumo semanal:
    Segunda-feira: 2 tarefa(s)
    Terça-feira: 1 tarefa(s)
    ...
    Total de tarefas na semana: 8

------------------------------------------------------------------------

## 🖼️ Layouts (XML)

O projeto segue o padrão solicitado:

-   Interface simples
-   Componentes básicos:
    -   `LinearLayout`
    -   `TextView`
    -   `Button`
    -   `ListView`
    -   `ScrollView`

------------------------------------------------------------------------

## 📑 AndroidManifest - Declaração das Activities

``` xml
<activity android:name=".ResumoActivity" />
<activity android:name=".DiaActivity" />
<activity android:name=".MainActivity" android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

------------------------------------------------------------------------

## ▶️ Como Rodar o Projeto

1.  Abra o **Android Studio**
2.  Crie um projeto **Empty Activity**
3.  Substitua os arquivos pelos deste repositório
4.  Mantenha o mesmo package:

```{=html}
com.example.rotinadasemana
```

5.  Rode no emulador ou em um celular físico

------------------------------------------------------------------------

## 🎯 Objetivo Educacional

Este mini-projeto foi criado para ajudar a praticar:

-   Navegação entre telas (Intents)
-   Manipulação de listas (`ListView` + `ArrayAdapter`)
-   Criação de diálogos (`AlertDialog`)
-   Organização de layouts com XML
-   Armazenamento simples em memória (Repository)

Ideal para treinar conceitos iniciais de desenvolvimento Android!
