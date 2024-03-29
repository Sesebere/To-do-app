package com.example.metask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.metask.ui.theme.MeTaskTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TaskViewModel by viewModels()
    lateinit var navController: NavHostController
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            navController = rememberNavController()//A predefined composable function that allows us to immediately create a navhost
//                    controller which will handle the navigation in our app
            Scaffold(
                snackbarHost =SnackbarHost(
                    hostState = rememberSnackbarHostState()
                )
        ){

qQQ
            }

            }
            SetupNavGraph(navController = navController, viewModel = viewModel)
    }
}
@Preview(showBackground = true)
@Composable
fun showHomeScreen() {
    HomeScreen(viewModel, navController )
}
}