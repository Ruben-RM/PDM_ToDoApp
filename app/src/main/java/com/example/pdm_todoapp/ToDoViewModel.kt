package com.example.pdm_todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm_todoapp.data.ToDo
import com.example.pdm_todoapp.data.ToDoList

class ToDoViewModel : ViewModel() {
    private var _toDoList = MutableLiveData<List<ToDo>>()
    val toDoList: LiveData<List<ToDo>> = _toDoList

    private var _title = MutableLiveData<String>()
    val title: LiveData<String> = _title
    private var _date = MutableLiveData<String>()
    val date: LiveData<String> = _date
    private var _description = MutableLiveData<String>()
    val description: LiveData<String> = _description
    private var _faved = MutableLiveData<Boolean>()
    val faved: LiveData<Boolean> = _faved
    private var _prioridad = MutableLiveData<Int>()
    val prioridad: LiveData<Int> = _prioridad
    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

    init {
        addToDo("Cena Familiar", "Hay que ir bien vestido", "04/04/2025", true, 2)
        addToDo("Terminar la App de ToDos", "", "18/02/2025", false, 3)
        addToDo("Terminar el Videojuego", "Estaría bien que se te ocurriera una idea sobre qué hacerlo...", "16/02/2025", false, 3)
        addToDo("Terminar Proyecto de Angular", "Solo queda el documento extra.",  "14/02/2025", false, 1)
        addToDo("Terminar Ejercicio de Acceso a Datos", "",  "20/02/2025", false, 2)
        addToDo("Ir al Cine", "",  "01/03/2025", true, 0)
        addToDo("Examen Inglés", "",  "17/02/2025", false, 0)
        addToDo("Examen Bootstrap & Angular", "",  "20/02/2025", false, 2)
        addToDo("Examen Node & Express", "Se permiten apuntes.",  "13/02/2025", false, 2)

        _title.value = ""
        _date.value = ""
    }

    fun onTitleChange(title: String)
    {
        _title.value = title
        checkAddingEnabled()
    }

    fun onDescriptionChange(description: String)
    {
        _description.value = description
    }

    fun onDateChange(date: String)
    {
        _date.value = date
        checkAddingEnabled()
    }

    fun onFavedChange(faved: Boolean)
    {
        _faved.value = faved
    }

    fun onPrioridadChange(prioridad: Int)
    {
        _prioridad.value = prioridad
    }

    fun checkAddingEnabled()
    {
        _isLoginEnabled.value = _title.value != "" && _date.value != ""
    }

    fun getAllToDo()
    {
        _toDoList.value = ToDoList.getAllToDos().toList()
    }

    fun addToDo(title: String, descripcion: String, date: String, isFaved: Boolean, prioridad: Int)
    {
        ToDoList.addToDo(title, descripcion, date, isFaved, prioridad)
        getAllToDo()
    }

    fun deleteToDo(id: Int)
    {
        ToDoList.removeToDo(id)
        getAllToDo()
    }
}