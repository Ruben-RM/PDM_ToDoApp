package com.example.pdm_todoapp.data

import java.time.LocalDate

data class ToDo(
    var id: Int,
    var title: String,
    var descripcion: String,
    var fechaToDo: LocalDate,
    var isFaved: Boolean
)

fun getFakeToDos(): List<ToDo>
{
    return listOf<ToDo>(
        ToDo(id = 0, title = "Primer ToDo", descripcion = "Primer ToDo.", fechaToDo = LocalDate.of(2024, 5, 2), false),
        ToDo(id = 1, title = "Segundo ToDo", descripcion = "Segundo ToDo.", fechaToDo = LocalDate.of(2024, 10, 29), false),
        ToDo(id = 2, title = "Tercer ToDo", descripcion = "El Tercer ToDo tiene mucho texto aposta para que yo pueda ver qué pasa si pones una descripción ultra larga como descripción del ToDo, no sé si esto será suficiente pero bueno, por probar que no quede.", fechaToDo = LocalDate.of(2025, 1, 16), true),
        ToDo(id = 3, title = "Cuarto ToDo", descripcion = "Cuarto ToDo.", fechaToDo = LocalDate.of(2024, 5, 15), false),
        ToDo(id = 4, title = "Quinto ToDo", descripcion = "Quinto ToDo.", fechaToDo = LocalDate.of(2024, 6, 14), true),
        ToDo(id = 5, title = "Sexto ToDo", descripcion = "Sexto ToDo.", fechaToDo = LocalDate.of(2023, 3, 20), false),
        ToDo(id = 6, title = "Séptimo ToDo", descripcion = "Séptimo ToDo.", fechaToDo = LocalDate.of(2024, 8, 8), false),
        ToDo(id = 7, title = "Octavo ToDo", descripcion = "Octavo ToDo.", fechaToDo = LocalDate.of(2024, 12, 30), true),
        ToDo(id = 8, title = "Noveno ToDo", descripcion = "Noveno ToDo.", fechaToDo = LocalDate.of(2024, 1, 1), false),
        )
}