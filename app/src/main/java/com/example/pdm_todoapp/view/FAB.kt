package com.example.pdm_todoapp.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun MyFAB(onClickDrawer: () -> Unit)
{
    FloatingActionButton(
        onClick = { onClickDrawer() }
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "FAB Add ToDos")
    }
}