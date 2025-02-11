package com.example.pdm_todoapp.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pdm_todoapp.R
import com.example.pdm_todoapp.ToDoViewModel
import com.example.pdm_todoapp.data.ToDo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MyContent(innerPadding: PaddingValues, index: Int, seeFavs: Boolean, viewModel: ToDoViewModel)
{
    val toDoList by viewModel.toDoList.observeAsState(initial = emptyList())

    toDoList.let { list ->
        LazyColumn(
            modifier = Modifier.consumeWindowInsets(innerPadding),
            contentPadding = innerPadding
        )
        {
            when(index)
            {
                0 -> {
                    val listToUse =
                        if (seeFavs) { list.filter { it.isFaved } }
                        else { list }

                    items(listToUse.size) { i ->
                        ToDoPanel(viewModel, listToUse, i)
                    }
                }
                1 -> {
                    val sortedList = list.sortedByDescending { it.prioridad }

                    val listToUse =
                        if (seeFavs) { sortedList.filter { it.isFaved } }
                        else { sortedList }

                    items(listToUse.size) { i ->
                        ToDoPanel(viewModel, listToUse, i)
                    }
                }
                2 -> {
                    val sortedList = list.sortedWith { tarea1, tarea2 ->
                        val fecha1 = LocalDate.parse(tarea1.fechaToDo, DateTimeFormatter.ofPattern("dd/MM/yyyy") )
                        val fecha2 = LocalDate.parse(tarea2.fechaToDo, DateTimeFormatter.ofPattern("dd/MM/yyyy") )
                        fecha1.compareTo(fecha2)
                    }

                    val listToUse =
                        if (seeFavs) { sortedList.filter { it.isFaved } }
                        else { sortedList }

                    items(listToUse.size) { i ->
                        ToDoPanel(viewModel, listToUse, i)
                    }
                }
            }
        }
    }
}

@Composable
fun ToDoPanel(viewModel:ToDoViewModel, list: List<ToDo>, i: Int)
{
    val colors = listOf(
        Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt())
    )

    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth()
            .background(colors[i % colors.size])
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(.9f)
        ) {
            Text(text = "ToDo número ${list.get(i).id + 1}: ", color = Color.Black)

            Text(text = list.get(i).title,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            if(list.get(i).descripcion != "")
                Text(text = list.get(i).descripcion, color = Color.Black)
            Text(text = "Fecha límite: ${list.get(i).fechaToDo}", color = Color.Black)
        }

        Column(
            modifier = Modifier.weight(.1f),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            val heartColor = if(list.get(i).isFaved) { Color.Red } else { Color.Black }
            val priorityImage = when(list.get(i).prioridad) {
                0 -> painterResource(id = R.drawable.icon_nullpriority)
                1 -> painterResource(id = R.drawable.icon_lowpriority)
                2 -> painterResource(id = R.drawable.icon_midpriority)
                else -> painterResource(id = R.drawable.icon_highpriority)
            }

            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Desc",
                modifier = Modifier.size(25.dp),
                tint = heartColor
            )

            Spacer(modifier = Modifier.size((2.dp)))

            Icon(
                painter = priorityImage,
                contentDescription = "Desc",
                modifier = Modifier.size(25.dp),
                tint = Color.Black
            )

            Spacer(modifier = Modifier.size((2.dp)))

            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    Toast.makeText(context, "El ToDo se ha eliminado correctamente", Toast.LENGTH_SHORT).show()
                    viewModel.deleteToDo(list.get(i).id)
                }
            ){
                Icon(
                    Icons.Filled.Delete,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "Desc",
                    tint = Color.Black
                )
            }
        }
    }
    HorizontalDivider(thickness = 2.dp, color = Color.Black)
}