package com.example.metask

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao{
    @Insert
    suspend fun insertTask(task: Task)
    @Update
    suspend fun updateTask(task:Task)
    @Delete
    suspend fun deleteTask(task:Task)
    @Query("SELECT * from tasks WHERE id = :id")
    suspend fun selectTaskById(id: Int): Task
    @Query("SELECT * from tasks")
    suspend fun selectAllTasks(): MutableList<Task>
    @Query("DELETE from tasks")
    suspend fun deleteAllTasks()

}