package com.example.pdm_todoapp.data

import java.time.LocalDate

data class ToDo(
    var id: Int,
    var title: String = "",
    var descripcion: String = "",
    var fechaToDo: LocalDate,
    var isFaved: Boolean = false
)