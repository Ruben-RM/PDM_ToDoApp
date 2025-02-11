package com.example.pdm_todoapp.view

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pdm_todoapp.R

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
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(25.dp)
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
                    painter = painterResource(R.drawable.icon_lowpriority),
                    contentDescription = "Fav Icon",
                    modifier = Modifier.size(25.dp)
                )
            },
            label = { Text("Ordena por prioridad") },
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
            selected = index == 2,
            onClick = { function(2) },
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Sort by Date",
                    modifier = Modifier.size(25.dp)
                )
            },
            label = { Text("Ordena por fecha") },
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