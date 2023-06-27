package com.example.metask

import AddTaskScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    viewModel: TaskViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(viewModel, navController)
        }
        composable(route = Screen.AddTask.route) {
            AddTaskScreen(viewModel, navController)
        }
    }
}