package com.example.metask

interface Repository{
    suspend fun selectTaskById(id: Int): Task

    suspend fun insertTask(task:Task)

    suspend fun updateTask(task:Task)

    suspend fun selectAllTasks(): MutableList<Task>

    suspend fun deleteTask(task:Task)
    suspend fun deleteAllTasks()
}