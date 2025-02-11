package com.example.pdm_todoapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pdm_todoapp.ToDoViewModel
import com.example.pdm_todoapp.data.ToDo

@Composable
fun MyContent(innerPadding: PaddingValues, index: Int, viewModel: ToDoViewModel)
{
    val toDoList by viewModel.toDoList.observeAsState(initial = emptyList())

    toDoList?.let { list ->
        LazyColumn(
            modifier = Modifier.consumeWindowInsets(innerPadding),
            contentPadding = innerPadding
        )
        {
            if(index == 0)
                items(list.size) { i ->
                    ToDoPanel(list, i)
                }
            else
            {
                val filteredList = list.filter{ it.isFaved }
                items(filteredList.size) { i ->
                    ToDoPanel(filteredList, i)
                }
            }
        }
    }
}

@Composable
fun ToDoPanel(list: List<ToDo>, i: Int)
{
    val colors = listOf(
        Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt())
    )

    Row(
        Modifier
            .fillMaxWidth()
            .background(colors[i % colors.size])
            .padding(10.dp)
    ){
        Column(
            modifier = Modifier.weight(.9f)
        ) {
            Text(text = "ToDo número ${list.get(i).id}: ", color = Color.Black)

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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            if(list.get(i).isFaved)
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Desc",
                    tint = Color.Red
                )
            else
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = "Desc",
                    tint = Color.Black
                )

            IconButton(
                onClick = { }
            ){
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Desc",
                    tint = Color.Black
                )
            }
        }
    }
    HorizontalDivider(thickness = 1.dp, color = Color.Black)
}