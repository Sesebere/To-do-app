package com.example.metask

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    val repository: RepositoryImpl
): ViewModel(){
//    lateinit var tasks: SnapshotStateList<Task>
    lateinit var tasks: MutableState<MutableList<Task>>
    private lateinit var text: String

    init {
//        tasks = mutableStateListOf<Task>()
        tasks = mutableStateOf(mutableListOf())
//        CoroutineScope(IO).launch{
//            repository.insertTask(
//                Task("go to space", Priority.HIGH,"A date","00:55",1,"true"))
//            repository.insertTask(
//                Task("go to space", Priority.HIGH,"A date","00:55",1,"true"))
//
//
//            tasks.value = repository.selectAllTasks()
//
//        }
        viewModelScope.launch {
            val job1 = launch { repository.insertTask(
                Task("go to space", Priority.HIGH, "A date", "00:55", 1, "true"))
                repository.insertTask(
                    Task("go to space", Priority.HIGH, "A date", "00:55", 1, "true"))
            }

            tasks.value = repository.selectAllTasks()

        }

    }

    fun removeTask(task: Task){
        tasks.value.remove(task)
    }
    fun addTask(task: Task){
        tasks.value.remove(task)
    }


}