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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.metask.Priority
import com.example.metask.Screen
import com.example.metask.Task
import com.example.metask.TaskViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(viewModel: TaskViewModel, navController: NavHostController) {
    val message = remember { mutableStateOf("") }
    val duration = remember { mutableStateOf("") }
    var isRepetitive = remember{ mutableStateOf(false)}//whether or not the user has selected the task to be
    //a repetitive something
Column(
    modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.Yellow)
) {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.Green)

    ) {

        Spacer(modifier = Modifier.height(25.dp))
        TextField(
            value = message.value,
            onValueChange = { message.value = it },
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(275.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = { Text("Add task here") },
            shape = RoundedCornerShape(30.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 25.dp)
        ) {
            Text(text = "Estimated time")
            Spacer(modifier = Modifier.width(20.dp))
            TextField(
                modifier = Modifier
                    .width(75.dp)
                    .height(35.dp),
                value = duration.value,
                onValueChange = {
                    duration.value = it
                },
                placeholder = { Text("00:00") },
                shape = RoundedCornerShape(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text("Repetitive")
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Checkbox(checked = isRepetitive.value, onCheckedChange = {
                    isRepetitive.value = it
                })
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text("Schedule task")
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.DateRange, contentDescription = "Calendar")

            }
        }
    }

    TextButton(
        onClick = {
            viewModel.addTask(Task(message.value, Priority.HIGH, "a date","01:23",3,
                isRepetitive.value.toString(), "false"))
            navController.navigate(route = Screen.Home.route)
                  },
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp)
            .align(Alignment.CenterHorizontally),
        shape = RoundedCornerShape(30.dp),
        elevation = ButtonDefaults.buttonElevation(5.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
    ) {
        Text(
            text = "Done"
//                color = Color.White
        )
    }

    }
}

