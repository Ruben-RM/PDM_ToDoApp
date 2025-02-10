package com.example.pdm_todoapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pdm_todoapp.data.getFakeToDos

@Composable
fun MyContent(innerPadding: PaddingValues) {
    val colors = listOf(
        Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt())
    )

    val toDoList = getFakeToDos()

    LazyColumn(
        modifier = Modifier.consumeWindowInsets(innerPadding),
        contentPadding = innerPadding
    ) {
        items(toDoList.size) { i ->
            Box(
                Modifier
                .fillMaxWidth()
                .background(colors[i % colors.size])
                .padding(10.dp)
            )
            {
                Column {
                    Text(text = "ToDo ${toDoList.get(i).id}", color = Color.Black)
                    Text(text = toDoList.get(i).title, color = Color.Black)
                    Text(text = toDoList.get(i).descripcion, color = Color.Black)
                    Text(text = "Fecha límite: ${toDoList.get(i).fechaToDo}", color = Color.Black)
                }
            }
        }
    }
}