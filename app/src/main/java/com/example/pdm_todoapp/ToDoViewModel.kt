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
    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

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

    fun checkAddingEnabled()
    {
        _isLoginEnabled.value = _title.value != "" && _date.value != ""
    }

    fun getAllToDo()
    {
        _toDoList.value = ToDoList.getAllToDos().toList()
    }

    fun addToDo(title: String, descripcion: String, date: String, isFaved: Boolean)
    {
        ToDoList.addToDo(title, descripcion, date, isFaved)
        getAllToDo()
    }

    fun deleteToDo(id: Int)
    {
        ToDoList.removeToDo(id)
        getAllToDo()
    }
}