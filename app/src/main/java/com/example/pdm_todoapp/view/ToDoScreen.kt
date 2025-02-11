package com.example.pdm_todoapp.view

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.pdm_todoapp.ToDoViewModel
import kotlinx.coroutines.launch

@Composable
fun ToDoScreen(viewModel: ToDoViewModel)
{
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var index by rememberSaveable { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Black,
                drawerContentColor = Color.White
            ) {
                MyNavigationDrawer(viewModel) { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            content = { innerPadding ->
                MyContent(innerPadding, index, viewModel)
            },
            bottomBar = { MyBotNav(index){ index = it } },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { MyFAB() }
        )
    }
}