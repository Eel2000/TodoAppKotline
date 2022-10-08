package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.theme.TodoAppTheme
import com.example.todoapp.viewModels.MemoViewModel
import com.example.todoapp.views.HomePage
import com.example.todoapp.views.NewMemo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                val vm by remember {
                    mutableStateOf(MemoViewModel())
                }
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.Home.route){
                    composable(route=Route.Home.route){
                        MainScreen("My memo", navController, vm)
                    }
                    composable(route = Route.Add.route){
                        NewMemo(navController, vm)
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(name: String,nav: NavController, viewModel: MemoViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name)}
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { nav.navigate(route = Route.Add.route) },
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        HomePage(viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoAppTheme {
        val navController = rememberNavController()
        MainScreen(name = "My memo",navController,MemoViewModel())
    }
}