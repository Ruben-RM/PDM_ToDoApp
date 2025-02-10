package com.example.pdm_todoapp.data

import java.time.LocalDate

data class ToDo(
    var id: Int,
    var title: String,
    var descripcion: String,
    var fechaToDo: LocalDate
)

fun getFakeToDos(): List<ToDo>
{
    return listOf<ToDo>(
        ToDo(id = 0, title = "First ToDo", descripcion = "First ToDo.", fechaToDo = LocalDate.of(2024, 5, 2)),
        ToDo(id = 1, title = "Second ToDo", descripcion = "Second ToDo.", fechaToDo = LocalDate.of(2024, 10, 29)),
        ToDo(id = 2, title = "Third ToDo", descripcion = "Third ToDo.", fechaToDo = LocalDate.of(2025, 1, 16))
    )
}