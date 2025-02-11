package com.example.pdm_todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pdm_todoapp.ui.theme.PDM_ToDoAppTheme
import com.example.pdm_todoapp.view.ToDoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDM_ToDoAppTheme {
                ToDoScreen(ToDoViewModel())
            }
        }
    }
}