package com.example.pdm_todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm_todoapp.data.ToDo
import com.example.pdm_todoapp.data.ToDoList
import java.time.LocalDate

class ToDoViewModel : ViewModel() {
    private var _toDoList = MutableLiveData<List<ToDo>>()
    val toDoList: LiveData<List<ToDo>> = _toDoList

    init {
        val lista = listOf<ToDo>(
            ToDo(id = 1, title = "Primer ToDo", descripcion = "Primer ToDo.", fechaToDo = LocalDate.of(2024, 5, 2), isFaved = false),
            ToDo(id = 2, title = "Segundo ToDo", descripcion = "Segundo ToDo.", fechaToDo = LocalDate.of(2024, 10, 29), isFaved = false),
            ToDo(id = 3, title = "Tercer ToDo", descripcion = "El Tercer ToDo tiene mucho texto aposta para que yo pueda ver qué pasa si pones una descripción ultra larga como descripción del ToDo, no sé si esto será suficiente pero bueno, por probar que no quede.", fechaToDo = LocalDate.of(2025, 1, 16), isFaved = true),
            ToDo(id = 4, title = "Cuarto ToDo", fechaToDo = LocalDate.of(2024, 5, 15), isFaved = false),
            ToDo(id = 5, title = "Quinto ToDo", fechaToDo = LocalDate.of(2024, 6, 14), isFaved = true),
            ToDo(id = 6, title = "Sexto ToDo", fechaToDo = LocalDate.of(2023, 3, 20), isFaved = false),
            ToDo(id = 7, title = "Séptimo ToDo", fechaToDo = LocalDate.of(2024, 8, 8), isFaved = false),
            ToDo(id = 8, title = "Octavo ToDo", fechaToDo = LocalDate.of(2024, 12, 30), isFaved = true),
            ToDo(id = 9, title = "Noveno ToDo", fechaToDo = LocalDate.of(2024, 1, 1), isFaved = false),
        )

        _toDoList.value = lista
    }

    fun getAllToDo()
    {
        _toDoList.value = ToDoList.getAllToDos()
    }

    fun addToDo(title: String, descripcion: String, isFaved: Boolean)
    {
        ToDoList.addToDo(title, descripcion, isFaved)
        getAllToDo()
    }

    fun deleteToDo(id: Int)
    {
        ToDoList.removeToDo(id)
        getAllToDo()
    }
}