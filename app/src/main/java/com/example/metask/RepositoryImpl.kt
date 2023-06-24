package com.example.metask

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class RepositoryImpl(var taskDao:TaskDao): Repository {
    override suspend fun selectTaskById(id: Int): Task {
        return taskDao.selectTaskById(id)
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override suspend fun selectAllTasks():  MutableList<Task> {
        return taskDao.selectAllTasks()
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    override suspend fun deleteAllTasks(task: Task) {
        taskDao.deleteAllTasks()
    }


}