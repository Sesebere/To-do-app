package com.example.metask

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RepositoryImpl {
    @Inject
    private lateinit var taskDao: TaskDao

    suspend fun getTask(id: Int) = taskDao.selectTaskById(id)

}