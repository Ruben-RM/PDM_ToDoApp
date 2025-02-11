package com.example.pdm_todoapp.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun MyBotNav(index: Int, function: (Int) -> Unit)
{
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White,
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { function(0) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Home Icon"
                )
            },
            label = { Text("Ver ToDos") },
            colors = NavigationBarItemColors(
                selectedIndicatorColor = Color.White,
                selectedIconColor = Color.Black,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.Transparent,
                disabledTextColor = Color.White
            )
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { function(1) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Fav Icon"
                )
            },
            label = { Text("Ver ToDos FAV") },
            colors = NavigationBarItemColors(
                selectedIndicatorColor = Color.White,
                selectedIconColor = Color.Black,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                disabledIconColor = Color.Transparent,
                disabledTextColor = Color.White
            )
        )
    }
}