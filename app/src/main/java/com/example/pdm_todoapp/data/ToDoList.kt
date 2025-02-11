package com.example.pdm_todoapp.data

object ToDoList
{
    private val toDoList = mutableListOf<ToDo>()

    fun getAllToDos(): List<ToDo>
    {
        return toDoList
    }

    fun addToDo(title: String, descripcion: String, date: String, isFaved: Boolean)
    {
        toDoList.add(
            ToDo(id = toDoList.size,
                title = title,
                descripcion = descripcion,
                fechaToDo = date,
                isFaved = isFaved),
        )
    }

    fun removeToDo(id: Int)
    {
        toDoList.removeAt(id)

        for(i in toDoList.indices)
            toDoList[i].id = i
    }
}