package com.example.metask

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object AddTask: Screen(route = "add_task_screen")
    object TaskDetail: Screen(route = "task_detail_screen")
}
