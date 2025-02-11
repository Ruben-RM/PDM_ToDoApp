package com.example.pdm_todoapp.data

data class ToDo(
    var id: Int,
    var title: String = "",
    var descripcion: String = "",
    var fechaToDo: String,
    var isFaved: Boolean = false,
    var prioridad: Int = 0
)