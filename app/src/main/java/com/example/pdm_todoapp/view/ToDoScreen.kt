package com.example.pdm_todoapp.view

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.example.pdm_todoapp.ToDoViewModel
import kotlinx.coroutines.launch

@Composable
fun ToDoScreen(viewModel: ToDoViewModel)
{
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Black,
                drawerContentColor = Color.White
            ) {
                MyNavigationDrawer() { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            content = { innerPadding ->
                MyContent(innerPadding, viewModel)
            },
            bottomBar = { MyBotNav() },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { MyFAB() }
        )
    }
}