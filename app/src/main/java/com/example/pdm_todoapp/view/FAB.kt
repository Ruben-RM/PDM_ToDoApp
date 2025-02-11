package com.example.pdm_todoapp.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun MyFAB()
{
    FloatingActionButton(
        onClick = {  }
    ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = "FAB Check")
    }
}