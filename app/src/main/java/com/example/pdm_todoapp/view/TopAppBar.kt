package com.example.pdm_todoapp.view

import android.app.Activity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickDrawer: () -> Unit)
{
    val activity = LocalContext.current as? Activity

    TopAppBar(
        title = { Text("My To Do App") },
        colors = topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() })
            {
                Icon(Icons.Filled.Menu,
                    contentDescription = "Desc",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = {})
            {
                Icon(Icons.Filled.Add,
                    contentDescription = "Desc",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.size(6.dp))
            IconButton(onClick = { activity?.finish() })
            {
                Icon(Icons.Filled.Close,
                    contentDescription = "Desc",
                    tint = Color.White
                )
            }
        }
    )
}