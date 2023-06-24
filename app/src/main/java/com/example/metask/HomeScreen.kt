package com.example.metask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.Elevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults.Elevation
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//@OptIn(ExperimentalMaterial3Api::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: TaskViewModel, navController: NavHostController) {
    var stuff = listOf(Task("go home", Priority.LOW, "tomorrow", "00:55", 1, "true"))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
        ) {
            items(viewModel.tasks.value) { task ->
                var message = remember { mutableStateOf(task.message) }
                var duration = remember { mutableStateOf(task.duration) }
                var isCompleted = remember { mutableStateOf(task.isCompleted) }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Checkbox(
                        modifier = Modifier
                            .fillMaxWidth(0.1f)
                            .clip(RoundedCornerShape(50)),
                        checked = if (isCompleted.value == "true") true else false,
                        onCheckedChange = {
                            if (isCompleted.value == "true") isCompleted.value =
                                "false" else isCompleted.value = "true"
                        },
                    )
                    IconButton(
                        modifier = Modifier.fillMaxWidth(0.1f),
                        onClick = { viewModel.removeTask(task) }
                    ) {
                        Icon(Icons.Filled.Close, contentDescription = "Delete")
                    }
                    TextField(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        value = message.value,
                        onValueChange = {
                            message.value = it
                            CoroutineScope(IO).launch {
                                viewModel.repository.updateTask(task.copy(message = it))
                            }
                        },
                        placeholder = { Text("Do [this] at [that]") },
                        shape = RoundedCornerShape(30.dp)
                    )
                    TextField(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        value = duration.value,
                        onValueChange = {
                            duration.value = it
                            CoroutineScope(IO).launch {
                                viewModel.repository.updateTask(task.copy(duration = it))
                            }
                        },
                        placeholder = { Text("00:00") },
                        shape = RoundedCornerShape(30.dp)
                    )

                }
            }
        }
//        TextButton(
//            onClick = { /* Do something! */ },
//            modifier = Modifier.padding(16.dp).width(175.dp),
////            elevation = ButtonDefaults.buttonElevation(5.dp),
//            shape = RoundedCornerShape(30.dp),
//            backgroundColor = Color.LightGray
//            ) {
//            Text(
//                text = "Add task",
//                color = Color.White
//            )
//        }
        TextButton(
            onClick = { navController.navigate(route = Screen.TaskDetail.route) },
            modifier = Modifier.padding(16.dp).width(200.dp),
            shape = RoundedCornerShape(30.dp),
            elevation = ButtonDefaults.buttonElevation(5.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
        ) {
            Text(
                text = "Add Task",
//                color = Color.White
            )
        }
    }

}
